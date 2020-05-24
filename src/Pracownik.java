import java.time.LocalDate;

public class Pracownik extends OsobaWSklepie {
    private LocalDate dataZatrudnienia;
    private float pensjaBrutto;
    private String rodzajUmowy;

    public Pracownik(String imie, String nazwisko, LocalDate dataUrodzenia, String plec,
                     LocalDate dataZatrudnienia, float pensjaBrutto, String rodzajUmowy){
        super(imie, nazwisko, dataUrodzenia, plec);
        this.dataZatrudnienia = dataZatrudnienia;
        this.pensjaBrutto = pensjaBrutto;
        this.rodzajUmowy = rodzajUmowy;
    }

    public String toString() {
        return super.toString() +
                "data zatrudnienia: " + dataZatrudnienia + '\n' +
                "pensja brutto: " + pensjaBrutto + '\n'+
                "rodzaj umowy: " + rodzajUmowy + '\n';
    }

    public void wprowadzAdresKlienta(Klient k1, Adres a1) throws Exception {
        k1.dodajAdres(a1);
        System.out.println("Wprowadzono adres dla klienta\n" + k1);
    }

    private void wprowadzProdukt(Produkt p1, Dostawca d1) throws Exception {
        p1.dodajDostawca(d1);
        p1.dodajPracownik(this);
        System.out.println("Wprowadzono produkt\n" + p1);
    }

    public void wprowadzKsiazke(Ksiazka k1, Dostawca d1, Autor a1) throws Exception {
        this.wprowadzProdukt(k1, d1);
        k1.dodajAutora(a1);
    }

    public void wprowadzProduktDoInwentaryzacji(Produkt p1, Inwentaryzacja i1) throws Exception {
        p1.dodajInwentaryzacja(i1);
        i1.dodajPracownik(this);
        System.out.println("Dodano do inwentaryzacji\n" + p1);
    }


    public void dodajProduktDoZamowienia(Produkt p1, Zamowienie z1) throws Exception {
        z1.dodajProdukt(p1);
        z1.dodajPracownik(this);
        System.out.println("Dodano do zamowienia\n" + p1);
    }

    public void zrobPlatnoscGotowka(Zamowienie z1, Platnosc p1) throws Exception {
        z1.dodajPlatnosc(p1);
        System.out.println("Zrealizowano platnosc gotowka za zamowienie\n" + z1);
    }

    public void zrobPlatnoscKarta(Zamowienie z1, Platnosc p1, OperatorPlatnosci o1) throws Exception {
        z1.dodajPlatnosc(p1);
        p1.dodajOperator(o1);
        System.out.println("Zrealizowano platnosc karta za zamowienie\n" + z1);
    }

    public void dodajInwentaryzacja(Inwentaryzacja i1)throws Exception{
        if(i1 == null){
            throw new Exception("Nie ma takiej inwentaryzacji!");
        }
        this.dodajPowiazanie("inwentaryzacja", "pracownik", i1);
    }

    public void dodajProdukt(Produkt p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki produkt nie istnieje!");
        }
        if(p1 instanceof  Ksiazka){
            this.dodajPowiazanie("ksiazka", "pracownik", p1);
        }
    }

    public void dodajZamowienie(Zamowienie z1)throws Exception{
        if(z1 == null){
            throw new Exception("Takie zamowienie nie istnieje!");
        }
        this.dodajPowiazanie("zamowienie", "pracownik", z1);
    }

    public void dodajReklamacja(Reklamacja r1)throws Exception{
        if(r1 == null){
            throw new Exception("Taka reklamacja nie istnieje!");
        }
        this.dodajPowiazanie("reklamacja", "pracownik", r1);
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public float getPensjaBrutto() {
        return pensjaBrutto;
    }

    public void setPensjaBrutto(float pensjaBrutto) {
        this.pensjaBrutto = pensjaBrutto;
    }

    public String getRodzajUmowy() {
        return rodzajUmowy;
    }

    public void setRodzajUmowy(String rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
    }
}
