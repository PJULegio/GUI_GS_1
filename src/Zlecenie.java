import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Zlecenie implements Runnable {
    private static int iloscZlecen = 1;
    private final int id;
    private List<Praca> listaPrac;
    private static Map<Praca, Zlecenie> mapaPrac = new HashMap<>();
    private Brygada brygada;
    private enum Planned {Planowane, Nieplanowane};
    private final Planned isPlanned;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;

    private static final Object readyLock = new Object();

    // Constructors - start
    public Zlecenie(boolean isPlanned) {
        this.id = iloscZlecen++;

        if(isPlanned)
            this.isPlanned = Planned.Planowane;
        else
            this.isPlanned = Planned.Nieplanowane;

        this.dataUtworzenia = LocalDateTime.now();
        this.listaPrac = new ArrayList<>();
    }

    public Zlecenie(boolean isPlanned, Brygada brygada) {
        this(isPlanned);
        this.brygada = brygada;
        przypiszDoBrygadzisty(brygada);
    }

    public Zlecenie(boolean isPlanned, List<Praca> listaPrac) {
        this(isPlanned);
        listaPrac.forEach(this::dodajPrace);
    }

    public Zlecenie(boolean isPlanned, List<Praca> listaPrac, Brygada brygada) {
        this(isPlanned);
        listaPrac.forEach(this::dodajPrace);
        this.brygada = brygada;
        przypiszDoBrygadzisty(brygada);
    }
    // Constructors - end

    // Methods
    public void dodajPrace(Praca praca) {
        this.listaPrac.add(praca);
        mapaPrac.put(praca, this);
    }

    public boolean dodajBrygade(Brygada brygada) {
        if(this.brygada == null) {
            this.brygada = brygada;
            przypiszDoBrygadzisty(brygada);
            return true;
        }
        else {
            return false;
        }
    }

    private void przypiszDoBrygadzisty(Brygada brygada) {
        brygada.getBrygadzista().dodajZlecenie(this);
    }

    public String statusZlecenia() {
        if(dataZakonczenia != null) return IConsoleFormatting.ANSI_GREEN + "Zakonczone" + IConsoleFormatting.ANSI_RESET;
        else if(dataRozpoczecia != null) return IConsoleFormatting.ANSI_YELLOW + "Rozpoczete" + IConsoleFormatting.ANSI_RESET;
        else return "Utworzone";
    }

    public void canBeRunCheck() {
        if (brygada.isOccupied()) {
            try {
                readyLock.wait();
                canBeRunCheck();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else
            brygada.setIsOccupied(true);
    }

    // Overrides
    @Override
    public void run() {
        System.out.println("Zlecenie " + id + " " + statusZlecenia());
        synchronized (readyLock) {
            canBeRunCheck();
        }

        dataRozpoczecia = LocalDateTime.now();
        System.out.println("Zlecenie " + id + " " + statusZlecenia());

        Thread[] listaWatkow = new Thread[listaPrac.size()];

        for(int i = 0; i < listaPrac.size(); i++)
            listaWatkow[i] = new Thread(listaPrac.get(i));

        for (Thread thread : listaWatkow)
            thread.start();

        for (Thread thread : listaWatkow) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        dataZakonczenia = LocalDateTime.now();
        System.out.println("Zlecenie " + id + " " + statusZlecenia());

        synchronized (readyLock) {
            brygada.setIsOccupied(false);
            readyLock.notifyAll();
        }
    }

    @Override
    public String toString() {
        return id +
                ": (" + (isPlanned == Planned.Planowane ? "Zlecenie planowane)" : "Zlecenie nieplanowane)") +
                listaPrac +
                IConsoleFormatting.ANSI_WHITE +
                " -> brygada " +
                brygada +
                IConsoleFormatting.ANSI_RESET;
    }

    // Getters
    public static Optional<Zlecenie> getPowiazaneZlecenie(int idPracy) {
        return mapaPrac
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getNumerPracy() == idPracy)
                .map(Map.Entry::getValue)
                .findFirst();
    }

    public static List<Praca> getPowiazanePrace(int idZlecenia) {
        return mapaPrac
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(),
                        mapaPrac.entrySet().stream().filter(o -> o.getValue().id == idZlecenia).findFirst().get().getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Set getMapaPrac() {  // TEST
        return mapaPrac.keySet();
    }
}
