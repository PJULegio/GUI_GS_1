import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DzialPracownikow {
    private static int iloscDzialow = 0;
    private final int id;
    private final String nazwa;
    private List<Pracownik> listaPracownikow;
    static Map<Integer, DzialPracownikow> listaDzialow = new HashMap<>();

    private DzialPracownikow(String nazwa) {
        this.id = iloscDzialow;
        this.nazwa = nazwa;
        this.listaPracownikow = new ArrayList<>();
    }

    private DzialPracownikow(String nazwa, boolean isNameUnique) {
        throw new NotUniqueNameException(nazwa);
        // trying to follow the task instructions
        // the exception should be thrown by the constructor
    }

    // static factory
    public static DzialPracownikow createDzial(String nazwa) {
        if (listaDzialow.values().stream().anyMatch(o -> o.getNazwa().equals(nazwa)))
            return new DzialPracownikow(nazwa, false);
        else {
            iloscDzialow++;
            DzialPracownikow newDzial = new DzialPracownikow(nazwa);
            listaDzialow.put(newDzial.id, newDzial);
            return newDzial;
        }
    }

    // SETTERS
    public void dodajPracownika(Pracownik nowyPracownik) {
        listaPracownikow.add(nowyPracownik);
    }

    // GETTERS
    public int getId() { return id; }
    public String getNazwa() { return nazwa; }
    public List<Pracownik> getListaPracownikow() { return listaPracownikow; }

    @Override
    public String toString() {
        return nazwa + ", id: " + id;
    }
}
