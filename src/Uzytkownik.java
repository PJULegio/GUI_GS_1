public class Uzytkownik extends Pracownik {
    private final int id;
    private String login;
    private String haslo;
    private String inicjal;
    private static int iloscSpecjalistow = 1;

    public Uzytkownik(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String login, String haslo
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.id = iloscSpecjalistow;
        this.login = login;
        this.haslo = haslo;

        this.inicjal = "";
        this.inicjal += imie.charAt(0);
        this.inicjal += nazwisko.charAt(0);

        uzytkownikConstructorHelper();
    }

    private void uzytkownikConstructorHelper() {
        iloscSpecjalistow++;
    }

    @Override
    public void zmienNazwe(String imie, String nazwisko) {
        super.zmienNazwe(imie, nazwisko);
        this.inicjal = "";
        this.inicjal += imie.charAt(0);
        this.inicjal += nazwisko.charAt(0);
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + login + " " + haslo + " " + inicjal;
    }
}
