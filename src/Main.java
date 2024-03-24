import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzial1 + " " + dzial1.getId() + " " + dzial1.getNazwa());

        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Dzial drugi");
        System.out.println(dzial2 + " " + dzial2.getId() + " " + dzial2.getNazwa());

        Pracownik test = new Specjalista("Grzegorz", "Sniezko", "2000-08-16 20:00", 1, "Informatyk");
        Pracownik test2 = new Specjalista("Grzegorz", "Skala", "1999-01-01 12:00", 2, "Programista");
        Pracownik test3 = new Specjalista("Grzegorz", "Alfa", "2002-01-01 12:00", 1, "Administrator");

        System.out.println(List.of(Pracownik.pracownicy));
        Collections.sort(Pracownik.pracownicy);
        System.out.println(List.of(Pracownik.pracownicy));


        DzialPracownikow dzialTestowy = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzialTestowy);
    }
}
