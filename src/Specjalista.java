public class Specjalista extends Pracownik {
    private final String specjalizacja;

    public Specjalista(
            String imie, String nazwisko, String dataUrodzenia, int dzial,
            String specjalizacja
    ) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.specjalizacja = specjalizacja;
    }
}
