import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(divider("TEST DZIALOW"));
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Dzial dostaw");
        System.out.println(dzial1);
        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow() + " " + IConsoleFormatting.ANSI_WHITE + "puste OK" + IConsoleFormatting.ANSI_RESET);

        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Dzial budowlany");
        System.out.println(dzial2);
        System.out.println("Pracownicy dzialu 2: " + dzial2.getListaPracownikow() + " " + IConsoleFormatting.ANSI_WHITE + "puste OK" + IConsoleFormatting.ANSI_RESET);

        DzialPracownikow dzial3 = DzialPracownikow.createDzial("Dzial naprawczy");
        System.out.println(dzial3);
        System.out.println("Pracownicy dzialu 3: " + dzial3.getListaPracownikow() + " " + IConsoleFormatting.ANSI_WHITE + "puste OK" + IConsoleFormatting.ANSI_RESET);

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST PRACOWNIKOW"));

        Pracownik test = new Specjalista("Grzegorz", "Sniezko", "2000-08-16 20:00", 1, "Kierowca");
        Pracownik test3 = new Specjalista("Grzegorz", "Alfa", "2002-01-01 12:00", 2, "Monter instalacji");
        Pracownik test2 = new Specjalista("Grzegorz", "Skala", "1999-01-01 12:00", 2, "Monter instalacji");
        Pracownik test4 = new Specjalista("Grzegorz", "AlfaOld", "1970-01-01 12:00", 3, "Mechanik");

        System.out.println("Lista pracownikow przed sortowaniem: " + List.of(Pracownik.pracownicy));
        Collections.sort(Pracownik.pracownicy);
        System.out.println("Lista pracownikow po sortowaniu: " + List.of(Pracownik.pracownicy));

        Pracownik user1 = new Uzytkownik("Grzegorz", "Lambda", "1990-01-01 12:00", 2, "grzeg", "1234");
        System.out.println("Uzytkownik 1: " + user1);
        user1.zmienNazwe("Robert", "Funkcja");
        System.out.println("Uzytkownik 1 po zmianie: " + user1 + " " + IConsoleFormatting.ANSI_WHITE + user1.getImie() + " " + user1.getNazwisko() + IConsoleFormatting.ANSI_RESET);

        System.out.println("Pracownicy dzialu 1: " + dzial1.getListaPracownikow());

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST BRYGAD I BRYGADZISTOW"));

        Brygadzista brygadzista1 = new Brygadzista("Adam", "Imienny", "2000-01-01 12:00", 1, "ada", "haslo");
        Brygada brygada1 = new Brygada("Brygada dostawcza", brygadzista1);
        System.out.println("Brygadzista1:\n" + brygadzista1);

        Brygadzista brygadzista2 = new Brygadzista("Andrzej", "Holuj", "1980-01-01 12:00", 2, "and", "haslo");
        Brygada brygada2 = new Brygada("Brygada remontowa", brygadzista2);

        Brygadzista brygadzista3 = new Brygadzista("Monika", "Podolska", "1985-04-04 13:00", 3, "mon", "haslo");
        Brygada brygada3 = new Brygada("Brygada naprawcza", brygadzista3);

        Brygadzista brygadzistaTest = new Brygadzista("User", "Test", "1970-01-01 00:00", 1, "test", "test");

        brygada1.addWorker(user1);
        brygada1.addWorker(brygadzistaTest);

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST ZLECEN"));

        Zlecenie zleceniePrzegladowe = new Zlecenie(true);
        System.out.println("Dodano brygade 3 do zlecenia przegladowego: " + zleceniePrzegladowe.dodajBrygade(brygada3));
        System.out.println("Dodano brygade 3 do zlecenia przegladowego: " + zleceniePrzegladowe.dodajBrygade(brygada3));

        System.out.println("Zlecenie " + zleceniePrzegladowe);

        System.out.println("\nZlecenia brygadzisty 3:\n" + brygadzista3.getZlecenia());


        // ------------------------------------------------------------------------
        System.out.println(divider("TEST PRAC"));

        Praca praca1 = new Praca(Praca.rodzajPracy.Ogolna, 5, "Przeglad starych urzadzen");
        Praca praca2 = new Praca(Praca.rodzajPracy.Ogolna, 20, "Dostawa nowych urzadzen", praca1);
        Praca praca3 = new Praca(Praca.rodzajPracy.Demontaz, 10, "Demontaz przestarzalej instalacji 1", praca2);
        Praca praca4 = new Praca(Praca.rodzajPracy.Demontaz, 30, "Demontaz przestarzalej instalacji 2", praca2);
        Praca praca5 = new Praca(Praca.rodzajPracy.Demontaz, 10, "Demontaz przestarzalej instalacji 3", praca2);
        Praca praca6 = new Praca(Praca.rodzajPracy.Montaz, 10, "Montaz nowej instalacji 1", praca3);
        Praca praca7 = new Praca(Praca.rodzajPracy.Wymiana, 5, "Wymiana urzadzenia", new ArrayList<>(Arrays.asList(praca6, praca4, praca5)));

        Zlecenie zlecenieDostawcze = new Zlecenie(true, new ArrayList<>(List.of(praca2)), brygada1);
        Zlecenie zlecenieRemontowe = new Zlecenie(false, new ArrayList<>(Arrays.asList(praca3, praca4, praca5, praca6)), brygada2);
        zleceniePrzegladowe.dodajPrace(praca1);
        zleceniePrzegladowe.dodajPrace(praca7);

        System.out.println("\nZlecenia brygadzisty 1:\n" + brygadzista1.getZlecenia());
        System.out.println("\nZlecenia brygadzisty 2:\n" + brygadzista2.getZlecenia());
        System.out.println("\nZlecenia brygadzisty 3:\n" + brygadzista3.getZlecenia());

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST GETTEROW"));

        System.out.println("getPowizaneZlecenie: " + Zlecenie.getPowiazaneZlecenie(praca1));
        System.out.println("getPowizanePrace: " + Zlecenie.getPowiazanePrace(zlecenieRemontowe));
        // System.out.println("test: " + Zlecenie.getMapaPrac());

        System.out.println("getPowizaneZlecenie: " + Praca.getPowiazaneZlecenie(praca2));
        System.out.println("getPowizanePrace: " + Praca.getPowiazanePrace(zleceniePrzegladowe));

        // ------------------------------------------------------------------------
        System.out.println(divider("TEST ZAJETOSCI PRACOWNIKOW"));
        Praca pracaTestowa = new Praca(Praca.rodzajPracy.Montaz, 10, "Montaz probny");
        Zlecenie zlecenieTestowe = new Zlecenie(true, new ArrayList<>(List.of(pracaTestowa)), brygada2);

        // ------------------------------------------------------------------------
        System.out.println(divider("DZIALANIE PROGRAMU"));

        Thread watekZleceniaPrzegladowego = new Thread(zleceniePrzegladowe);
        watekZleceniaPrzegladowego.start();

        Thread watekZleceniaDostawczego = new Thread(zlecenieDostawcze);
        watekZleceniaDostawczego.start();

        Thread watekZleceniaRemontowego = new Thread(zlecenieRemontowe);
        watekZleceniaRemontowego.start();

        Thread watekZleceniaTestowego = new Thread(zlecenieTestowe);
        watekZleceniaTestowego.start();

        // ------------------------------------------------------------------------
        /*System.out.println(divider("TEST UNIKALNYCH NAZW DZIALOW"));

        DzialPracownikow dzialTestowy = DzialPracownikow.createDzial("Dzial przegladow");
        System.out.println(dzialTestowy);
        DzialPracownikow dzialTestowy2 = DzialPracownikow.createDzial("Dzial przegladow");
        System.out.println(dzialTestowy2);*/
    }

    protected static String divider(String dividerText) { return IConsoleFormatting.HEADER_COLOR + "\n------ " + dividerText + " ------" + IConsoleFormatting.ANSI_RESET; }
}
