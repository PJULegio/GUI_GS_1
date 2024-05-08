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

    // Wstrzymuje wątek do momentu wykonania poprzednich wątków
    public void canBeRunCheck() {
        for (Praca praca : waitFor) {
            if (!praca.czyZrealizowane) {
                synchronized (readyLock) {
                    try {
                        readyLock.wait();
                        canBeRunCheck();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    // Overrides
    @Override
    public void run() {
        canBeRunCheck();

        System.out.println(IConsoleFormatting.ANSI_YELLOW + "[RUNNING]: " + IConsoleFormatting.ANSI_RESET + this);
        // Symuluj wykonywanie pracy
        try {
            Thread.sleep(czasPracy * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(IConsoleFormatting.ANSI_GREEN + "[DONE]: " + IConsoleFormatting.ANSI_RESET + this);

        synchronized (readyLock) {
            readyLock.notifyAll();
        }
        czyZrealizowane = true;
    }

    @Override
    public String toString() {
        return id + ". " + rodzajPracy + " \"" + opis + "\"";
    }

    // Getters
    public boolean getCzyZrealizowane() {
        return czyZrealizowane;
    }
}
