public class Specjalista extends Pracownik {
    private final int id;
    private final String specjalizacja;
    private static int iloscSpecjalistow = 1;

    public Specjalista(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String specjalizacja
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.id = iloscSpecjalistow;
        this.specjalizacja = specjalizacja;
        createSpecjalista();
    }

    private void createSpecjalista() {
        iloscSpecjalistow++;
    }

    @Override
    public String toString() {
        return id + ". " + super.getImie() + " " + super.getNazwisko() + " " + specjalizacja;
    }
}
