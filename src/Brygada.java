import java.util.ArrayList;
import java.util.Arrays;
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
        this.listaPracownikow = listaPracownikow;
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
        listaPracownikow.add(nowyPracownik);
    }

    public void addWorker(List<Pracownik> nowyPracownik) {
        listaPracownikow.addAll(nowyPracownik);
    }

    // Overrides
    @Override
    public String toString() {
        return "brygada " + id + ": " + nazwa;
    }

    // Getters
    public Brygadzista getBrygadzista() {
        return brygadzista;
    }
}
