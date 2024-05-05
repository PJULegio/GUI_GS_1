import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Praca extends Thread {
    private static int iloscPrac = 1;
    private final int id;

    enum rodzajPracy {Ogolna, Montaz, Demontaz, Wymiana;};
    private final Praca.rodzajPracy rodzajPracy;
    private int czasPracy;
    private boolean czyZrealizowane;
    private String opis;
    private List<Praca> waitFor;

    private static final Object readyLock = new Object();
    private boolean gameReady = false;

    // Constructors
    public Praca(Praca.rodzajPracy rodzajPracy, int czasPracy, String opis) {
        this.id = iloscPrac++;
        this.rodzajPracy = rodzajPracy;
        this.czasPracy = czasPracy;
        this.czyZrealizowane = false;
        this.opis = opis;
        this.waitFor = new ArrayList<>();
    }

    public Praca(
            Praca.rodzajPracy rodzajPracy, int czasPracy, String opis,
            List<Praca> waitFor
    ) {
        this(rodzajPracy, czasPracy, opis);
        this.waitFor.addAll(waitFor);
    }

    public Praca(
            Praca.rodzajPracy rodzajPracy, int czasPracy, String opis,
            Praca waitFor
    ) {
        this(rodzajPracy, czasPracy, opis);
        this.waitFor.add(waitFor);
    }

    // Methods
    public void setWaitFor(Praca praca) { waitFor.add(praca); }
    public void setWaitFor(List<Praca> prace) { waitFor.addAll(prace); }

    // Overrides
    @Override
    public void run() {
        if(id != 1) { // TODO
            synchronized (readyLock) {
                try {
                    waitFor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(IConsoleFormatting.ANSI_YELLOW + "[RUNNING]: " + IConsoleFormatting.ANSI_RESET + this);
        try {
            Thread.sleep(czasPracy * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(IConsoleFormatting.ANSI_GREEN + "[DONE]: " + IConsoleFormatting.ANSI_RESET + this);
        synchronized (readyLock) {
            readyLock.notify();
        }
        czyZrealizowane = true;
    }

    @Override
    public String toString() {
        return id + ". " + rodzajPracy + " \"" + opis + "\"";
    }
}
