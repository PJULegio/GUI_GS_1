public class Uzytkownik extends Pracownik {
    private static String login;
    private static String haslo;
    private static char[] inicjal;

    public Uzytkownik(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String login, String haslo
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.login = login;
        this.haslo = haslo;

        this.inicjal = new char[2];
        inicjal[0] = imie.charAt(0);
        inicjal[1] = nazwisko.charAt(0);
    }

    @Override
    public String toString() {
        return login + " " + haslo + " " + inicjal[0] + inicjal[1];
    }
}
