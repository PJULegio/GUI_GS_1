import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Brygadzista extends Uzytkownik {
    private static int iloscBrygadzistow = 0;
    private final int id;
    private HashSet<Brygada> przypisaneBrygady; // HashSet for searching
    private List<Zlecenie> listaZlecen;

    // Constructor
    public Brygadzista(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String login, String haslo
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
        this.id = ++iloscBrygadzistow;
        this.przypisaneBrygady = new HashSet<>();
        this.listaZlecen = new ArrayList<>();
    }


    // Methods
    public void dodajBrygade(Brygada brygada) { przypisaneBrygady.add(brygada); }

    public void dodajZlecenie(Zlecenie zlecenie) { listaZlecen.add(zlecenie); }

    // Overrides
    @Override
    public String toString() {
        return id + ". " + super.getImie() + " " + super.getNazwisko() + " " + super.getInicjaly() + " | " + getPrzypisaneBrygady();
    }

    // Getters
    public HashSet<Brygada> getPrzypisaneBrygady() { return przypisaneBrygady; }

    public List<Zlecenie> getZlecenia() { return listaZlecen; }
}
