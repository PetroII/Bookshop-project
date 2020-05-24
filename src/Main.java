import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
       final String ekstensjaPlik = "./ekstensja.bin";
       final LocalDate teraz = LocalDate.now();

        Pracownik p1 = new Pracownik("Adam", "Nowak", LocalDate.of(1995, 02, 10),
                "mezczyzna", LocalDate.of(2020, 01, 12), (float) 2600.00,
                "Umowa o prace");
        Pracownik p2 = new Pracownik("Michal", "Kowalski", LocalDate.of(1991, 05, 24),
                "mezczyzna", LocalDate.of(2019, 06, 15), (float) 3000.00,
                "Umowa o prace");
        p2.setDrugieImie("Antoni");

        Klient klient = new Klient("Anna", "Abacka", LocalDate.of(1985,04,26),
                "kobieta");

        Autor autor = new Autor("Eryk", "Nowacki", LocalDate.of(1970, 11, 23),
                "mezczyzna", "Fantastyka", "Profesor");

        Adres a1 = new Adres("Nowa", (short) 47, "Warszawa", "02-360", "Polska");
        Adres a2 = new Adres("Pulawska", (short) 154, "Warszawa", "03-760", "Polska");
        Adres a3 = new Adres("Admiralow", (short) 19, "Plock", "12-345", "Polska");
        Adres a4 = new Adres("Neue", (short) 192, "Berlin", "423-154", "Niemcy");

        Dostawca d1 = new Dostawca("Bookworld", LocalDate.of(2020, 01, 8));

        p1.dodajAdres(a1);
        p2.dodajAdres(a2);
        d1.dodajAdres(a4);


        Ksiazka ksiazka = new Ksiazka("Ksiazka", "ZYSK", (float) 50.00, "Na stanie",
                "Tajemnice przyszlosci", "Fantastyka", 123, "Miekka");

        OperatorPlatnosci visa = new OperatorPlatnosci("Visa", (float) 1.0);

        Inwentaryzacja i1 = new Inwentaryzacja(teraz);

        ObjectPlus.pokazEkstensje(Inwentaryzacja.class);
        System.out.println();

        p2.wprowadzProduktDoInwentaryzacji(ksiazka, i1);

        ObjectPlus.pokazEkstensje(Inwentaryzacja.class);


        p1.wprowadzKsiazke(ksiazka, d1, autor);

        p1.wprowadzAdresKlienta(klient, a3);
        System.out.println();

        Zamowienie zamowienie = Zamowienie.utworzZamowienie(klient, teraz);

        p2.dodajProduktDoZamowienia(ksiazka, zamowienie);

        zamowienie.setRabat(5);
        System.out.println(zamowienie);

        Platnosc platnosc = new Platnosc(teraz, 20);

        p2.zrobPlatnoscKarta(zamowienie, platnosc, visa );

        System.out.println(zamowienie);




        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ekstensjaPlik));
        Pracownik.zapiszEkstensje(out);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(ekstensjaPlik));
        Pracownik.odczytajEkstensje(in);



    }
}
