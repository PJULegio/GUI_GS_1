import java.util.HashSet;

public class Brygadzista extends Uzytkownik {
    private static int iloscBrygadzistow = 0;
    private final int id;
    private HashSet<Brygada> przypisaneBrygady = new HashSet<>(); // HashSet for searching

    public Brygadzista(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String login, String haslo
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
        this.id = ++iloscBrygadzistow;
    }

    public void addToBrigade(Brygada brygada) {
        przypisaneBrygady.add(brygada);
    }

    public HashSet<Brygada> showAssignedBrigades() {
        return przypisaneBrygady;
    }

    public void assignedTasks(Brygada brygada) { // TODO

    }

    @Override
    public String toString() {
        return id + ". " + super.getImie() + " " + super.getNazwisko() + " " + super.getInicjaly() + " | " + showAssignedBrigades();
    }
}
