import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzial1);
        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow());

        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Dzial drugi");
        System.out.println(dzial2);
        System.out.println("Pracownicy dzialu 2: " + dzial2.getListaPracownikow());

        System.out.println("-------------------------------------");

        Pracownik test = new Specjalista("Grzegorz", "Sniezko", "2000-08-16 20:00", 1, "Informatyk");
        Pracownik test3 = new Specjalista("Grzegorz", "Alfa", "2002-01-01 12:00", 1, "Administrator");
        Pracownik test2 = new Specjalista("Grzegorz", "Skala", "1999-01-01 12:00", 2, "Programista");
        Pracownik test4 = new Specjalista("Grzegorz", "AlfaOld", "1970-01-01 12:00", 1, "Administrator");

        System.out.println(List.of(Pracownik.pracownicy));
        Collections.sort(Pracownik.pracownicy);
        System.out.println(List.of(Pracownik.pracownicy));

        Pracownik user1 = new Uzytkownik("Grzegorz", "Lambda", "1990-01-01 12:00", 2, "grzeg", "1234");
        System.out.println("Uzytkownik 1: " + user1);
        user1.zmienNazwe("Robert", "Funkcja");
        System.out.println("Uzytkownik 1 po zmianie: " + user1);

        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow());

        System.out.println("-------------------------------------");

        Brygadzista brygadzista1 = new Brygadzista("Adam", "Imienny", "2000-01-01 12:00", 1, "ada", "haslo");
        Brygada brygada1 = new Brygada("Brygada1", brygadzista1);
        System.out.println("Brygadzista1:\n" + brygadzista1);

        System.out.println("-------------------------------------");

        DzialPracownikow dzialTestowy = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzialTestowy);
    }
}
