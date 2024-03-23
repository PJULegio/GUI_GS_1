public class Main {
    public static void main(String[] args) {
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzial1 + " " + dzial1.getId() + " " + dzial1.getNazwa());

        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Dzial drugi");
        System.out.println(dzial2 + " " + dzial2.getId() + " " + dzial2.getNazwa());

        DzialPracownikow dzialTestowy = DzialPracownikow.createDzial("Dzial pierwszy");
        System.out.println(dzialTestowy);
    }
}
