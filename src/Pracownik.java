import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik> {
    static List<Pracownik> pracownicy = new ArrayList<>();
    private static int iloscPracownikow = 1;
    private final int id;
    private String imie;
    private String nazwisko;
    private final LocalDateTime dataUrodzenia;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private int dzial;

    public Pracownik(String imie, String nazwisko, String dataUrodzenia, int dzial) {
        this.id = iloscPracownikow;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = LocalDateTime.parse(dataUrodzenia, formatter);
        this.dzial = dzial;
        createPracownik(dzial);

    }

    private void createPracownik(int dzial) {
        iloscPracownikow++;
        pracownicy.add(this);
        DzialPracownikow.listaDzialow.get(dzial).dodajPracownika(this);
    }

    public void zmienNazwe(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // GETTERS START
    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDateTime getDataUrodzenia() {
        return dataUrodzenia;
    }

    public int getDzial() {
        return dzial;
    }
    // GETTERS END

    @Override
    public int compareTo(Pracownik comparedWorker) {
        if(this.nazwisko.charAt(0) == comparedWorker.nazwisko.charAt(0))
            return this.dataUrodzenia.getYear() - comparedWorker.dataUrodzenia.getYear();
        else
            return this.nazwisko.charAt(0) - comparedWorker.nazwisko.charAt(0);
    }

    @Override
    public String toString() {
        return id + ". " + imie + " " + nazwisko;
    }
}
