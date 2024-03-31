import java.util.ArrayList;
import java.util.List;

public class Brygada {
    private String name;
    private Brygadzista brygadzista;
    private List<Pracownik> listaPracownikow = new ArrayList<>();

    public Brygada(String name, Brygadzista brygadzista) {
        this.name = name;
        this.brygadzista = brygadzista;
    }

    public Brygada(String name, Brygadzista brygadzista, List<Pracownik> listaPracownikow) {
        this(name, brygadzista);
        this.listaPracownikow = listaPracownikow;
    }

    public void addWorker(Pracownik nowyPracownik) {
        listaPracownikow.add(nowyPracownik);
    }

    public void addWorker(List<Pracownik> nowyPracownik) {
        for(Pracownik e : nowyPracownik)
            listaPracownikow.add(e);
    }
}
