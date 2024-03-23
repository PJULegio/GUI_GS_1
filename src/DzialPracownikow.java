import java.util.ArrayList;
import java.util.List;

public class DzialPracownikow {
    private int id;
    private String nazwa;
    private static int iloscDzialow = 0;
    private static List<String> nameList = new ArrayList<>();

    private DzialPracownikow(String nazwa) {
        id = iloscDzialow;
        this.nazwa = nazwa;
    }

    // static factory
    public static DzialPracownikow createDzial(String nazwa) throws NotUniqueNameException { // TODO according to the task, the exception should be thrown by the constructor
        if (!nameList.contains(nazwa)) {
            iloscDzialow++;
            nameList.add(nazwa);
            return new DzialPracownikow(nazwa);
        }
        else
            throw new NotUniqueNameException(nazwa);
    }

    public int getId() { return id; }
    public String getNazwa() { return nazwa; }
}
