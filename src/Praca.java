import java.util.ArrayList;
import java.util.List;

public class Praca extends Thread {

    private enum rodzajPracy {Ogolna, Montaz, Demontaz, Wymiana;};
    private final Praca.rodzajPracy rodzajPracy;
    private int czasPracy;
    private boolean czyZrealizowane;
    private String opis;
    private List<Praca> waitFor;

    public Praca(Praca.rodzajPracy rodzajPracy, int czasPracy, String opis) {
        this.rodzajPracy = rodzajPracy;
        this.czasPracy = czasPracy;
        this.czyZrealizowane = false;
        this.opis = opis;
        this.waitFor = new ArrayList<>();
    }
}
