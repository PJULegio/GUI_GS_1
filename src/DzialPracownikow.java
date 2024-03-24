import java.util.ArrayList;
import java.util.List;

public class DzialPracownikow {
    private final int id;
    private final String nazwa;
    private static int iloscDzialow = 0;
    private static List<String> nameList = new ArrayList<>();

    private DzialPracownikow(String nazwa) {
        id = iloscDzialow;
        this.nazwa = nazwa;
    }

    private DzialPracownikow(String nazwa, boolean isNameUnique) {
        throw new NotUniqueNameException(nazwa);
        // trying to follow the task instructions
        // the exception should be thrown by the constructor
    }

    // static factory
    public static DzialPracownikow createDzial(String nazwa) {
        if (!nameList.contains(nazwa)) {
            iloscDzialow++;
            nameList.add(nazwa);
            return new DzialPracownikow(nazwa);
        }
        else
            return new DzialPracownikow(nazwa, false);
    }

    public int getId() { return id; }
    public String getNazwa() { return nazwa; }

    // TODO create a method that returns workers from department
}
