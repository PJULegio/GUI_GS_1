import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik> {
    static List<Pracownik> pracownicy = new ArrayList<>();
    private static int workersCount = 0;
    private final int id;
    private final String imie;
    private final String nazwisko;
    private LocalDateTime dataUrodzenia;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private int dzial;

    public Pracownik(String imie, String nazwisko, String dataUrodzenia, int dzial) {
        this.id = ++workersCount;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = LocalDateTime.parse(dataUrodzenia, formatter);
        this.dzial = dzial;
        pracownicy.add(this);
    }

    @Override
    public int compareTo(Pracownik comparedWorker) { // TODO I want it to be more impressive
        if(this.nazwisko.charAt(0) == comparedWorker.nazwisko.charAt(0))
            return this.dataUrodzenia.getYear() - comparedWorker.dataUrodzenia.getYear();
        else
            return this.nazwisko.charAt(0) - comparedWorker.nazwisko.charAt(0);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
