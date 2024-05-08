import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Zlecenie implements Runnable {
    private static int iloscZlecen = 1;
    private final int id;
    private List<Praca> listaPrac;
    private Brygada brygada;
    private enum Planned {Planowane, Nieplanowane};
    private final Planned isPlanned;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;

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
        this.listaPrac = listaPrac;
    }

    public Zlecenie(boolean isPlanned, List<Praca> listaPrac, Brygada brygada) {
        this(isPlanned);
        this.listaPrac = listaPrac;
        this.brygada = brygada;
        przypiszDoBrygadzisty(brygada);
    }
    // Constructors - end

    // Methods
    public void dodajPrace(Praca praca) { this.listaPrac.add(praca); }

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
        if(dataZakonczenia != null) return "Zakonczone";
        else if(dataRozpoczecia != null) return "Rozpoczete";
        else return "Utworzone";
    }

    // Overrides
    @Override
    public void run() {
        System.out.println(id + statusZlecenia());
        dataRozpoczecia = LocalDateTime.now();
        System.out.println(id + statusZlecenia());

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
        System.out.println(id + statusZlecenia());
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
}
