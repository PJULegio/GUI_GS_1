import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(divider("TEST DZIALOW"));
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzial1);
        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow() + " " + ANSI_WHITE + "Ma byc puste" + ANSI_RESET);

        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Dzial drugi");
        System.out.println(dzial2);
        System.out.println("Pracownicy dzialu 2: " + dzial2.getListaPracownikow() + " " + ANSI_WHITE + "Ma byc puste" + ANSI_RESET);

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST PRACOWNIKOW"));

        Pracownik test = new Specjalista("Grzegorz", "Sniezko", "2000-08-16 20:00", 1, "Informatyk");
        Pracownik test3 = new Specjalista("Grzegorz", "Alfa", "2002-01-01 12:00", 1, "Administrator");
        Pracownik test2 = new Specjalista("Grzegorz", "Skala", "1999-01-01 12:00", 2, "Programista");
        Pracownik test4 = new Specjalista("Grzegorz", "AlfaOld", "1970-01-01 12:00", 1, "Administrator");

        System.out.println("Lista pracownikow przed sortowaniem: " + List.of(Pracownik.pracownicy));
        Collections.sort(Pracownik.pracownicy);
        System.out.println("Lista pracownikow po sortowaniu: " + List.of(Pracownik.pracownicy));

        Pracownik user1 = new Uzytkownik("Grzegorz", "Lambda", "1990-01-01 12:00", 2, "grzeg", "1234");
        System.out.println("Uzytkownik 1: " + user1);
        user1.zmienNazwe("Robert", "Funkcja");
        System.out.println("Uzytkownik 1 po zmianie: " + user1 + " " + ANSI_WHITE + user1.getImie() + " " + user1.getNazwisko() + ANSI_RESET);

        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow());

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST BRYGADZISTOW"));

        Brygadzista brygadzista1 = new Brygadzista("Adam", "Imienny", "2000-01-01 12:00", 1, "ada", "haslo");
        Brygada brygada1 = new Brygada("Brygada1", brygadzista1);
        System.out.println("Brygadzista1:\n" + brygadzista1);

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST ZLECEN"));

        Zlecenie zlecenie1 = new Zlecenie(false);
        System.out.println(zlecenie1.dodajBrygade(brygada1));
        System.out.println(zlecenie1.dodajBrygade(brygada1));

        System.out.println(brygadzista1.getZlecenia());

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST UNIKALNYCH NAZW DZIALOW"));

        DzialPracownikow dzialTestowy = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzialTestowy);
    }

    private static String divider(String dividerText) { return HEADER_COLOR + "\n------ " + dividerText + " ------" + ANSI_RESET; }

    // Colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String HEADER_COLOR = ANSI_CYAN;
}
