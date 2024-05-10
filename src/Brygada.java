import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brygada {
    private static int iloscBrygad = 1;
    private final int id;
    private String nazwa;
    private Brygadzista brygadzista;
    private List<Pracownik> listaPracownikow;

    // Constructors
    public Brygada(String nazwa, Brygadzista brygadzista, List<Pracownik> listaPracownikow) {
        this.id = iloscBrygad;
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        // this.listaPracownikow = listaPracownikow;
        this.listaPracownikow = new ArrayList<>();
        this.addWorker(listaPracownikow);
        brygadaConstructorHelper(brygadzista);
    }

    public Brygada(String name, Brygadzista brygadzista) {
        this(name, brygadzista, new ArrayList<>(Collections.singletonList(brygadzista)));
    }

    private void brygadaConstructorHelper(Brygadzista brygadzista) {
        iloscBrygad++;
        brygadzista.dodajBrygade(this);
    }

    // Methods
    public void addWorker(Pracownik nowyPracownik) {
        if(nowyPracownik.getClass() != Uzytkownik.class)
            listaPracownikow.add(nowyPracownik);
        else
            System.out.println(IConsoleFormatting.ANSI_YELLOW + "\u26a0 WARNING \u26a0" +
                    IConsoleFormatting.ANSI_RESET + " Nie mozna bylo dodac uzytkownika " + nowyPracownik);
    }

    public void addWorker(List<Pracownik> nowyPracownik) {
        nowyPracownik.forEach(this::addWorker);
    }

    public void setIsOccupied(boolean statement) {
        listaPracownikow.forEach(pracownik -> pracownik.setIsOccupied(statement));
    }

    public boolean isOccupied() {
        for(Pracownik pracownik : listaPracownikow) {
            if (pracownik.getIsOccupied())
                    return true;
        }

        return false;
    }

    // Overrides
    @Override
    public String toString() {
        return id + ": " + nazwa;
    }

    // Getters
    public Brygadzista getBrygadzista() {
        return brygadzista;
    }
}
