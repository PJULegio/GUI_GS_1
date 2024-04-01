import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Zlecenie implements Runnable {
    private List<Praca> listaPrac; // TODO kolekcja prac, czy to powinna być lista?
    private Brygada brygada;
    private enum Planned {Planowane, Nieplanowane}; // TODO czy to jest ok?
    private final Planned isPlanned;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;

    // Constructors
    public Zlecenie(boolean isPlanned) {
        if(isPlanned)
            this.isPlanned = Planned.Planowane;
        else
            this.isPlanned = Planned.Nieplanowane;

        this.dataUtworzenia = LocalDateTime.now();
    }

    public Zlecenie(boolean isPlanned, Brygada brygada) {
        this(isPlanned);
        this.brygada = brygada;
    }

    public Zlecenie(boolean isPlanned, List<Praca> listaPrac) {
        this(isPlanned);
        this.listaPrac = listaPrac;
    }

    public Zlecenie(boolean isPlanned, List<Praca> listaPrac, Brygada brygada) {
        this(isPlanned);
        this.listaPrac = listaPrac;
        this.brygada = brygada;
    }

    // Methods
    public void dodajPrace(Praca praca) {
        this.listaPrac.add(praca);
    }

    public boolean dodajBrygade(Brygada brygada) {
        if(this.brygada == null) {
            this.brygada = brygada;
            return true;
        }
        else {
            return false;
        }
    }

    public String statusZlecenia() { // TODO add conditions to check dates of start and completion
        if(dataZakonczenia != null) return "Zakonczone";
        else if(dataRozpoczecia != null) return "Rozpoczete";
        else return "Utworzone";
    }

    @Override
    public void run() { // TODO I don't know how it works

    }
}