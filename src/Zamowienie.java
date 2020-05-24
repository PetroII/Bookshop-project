import java.io.Serializable;
import java.time.LocalDate;

public class Zamowienie extends ObjectPlusPlus implements Serializable {
    private LocalDate dataZamowienia;
    private float wartoscZamowienia()throws Exception{
        float wartosc = 0;
        for(Object obj : this.getObiekty("ksiazka") ){
              wartosc = wartosc + ((Produkt) obj).getCena();
        }
        for(Object obj : this.getObiekty("klient")){
            if(((Klient) obj).getCzyNowy()){
                wartosc = wartosc - Klient.getRabatPowitalny();
            }
        }

        if(rabat!=null) {
            return wartosc - rabat;
        }else{
            return wartosc;
        }
    }
    private Integer rabat;

    private boolean czyMaPracownika = false;
    private boolean czyMaReklamacje = false;
    private boolean czyMaPlatnosc = false;

    private Zamowienie(LocalDate dataZamowienia) {
        super();
        this.dataZamowienia = dataZamowienia;
    }

    public String toString() {
        try {
            return "data zamowienia: " + dataZamowienia + '\n' +
                    "wartosc zamowienia: " + wartoscZamowienia() + '\n' +
                    ((rabat == null) ? "" : "rabat: " + rabat + '\n');
        }
        catch(Exception e){
            return "Blad! Nie mozna wyswietlic zamowienia!";
        }
    }

    public static Zamowienie utworzZamowienie(Klient klient, LocalDate dataZamowienia )throws Exception{
        if(klient == null){
            throw new Exception("Klient nie istnieje!");
        }
        Zamowienie z1 = new Zamowienie(dataZamowienia);
        klient.dodajCzesc("zamowienie", "klient", z1);

        return z1;
    }

    public void dodajProdukt(Produkt p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki produkt nie istnieje!");
        }
        if(p1 instanceof Ksiazka){
            this.dodajPowiazanie("ksiazka", "zamowienie", p1);
        }
    }

    public void dodajPracownik(Pracownik p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki pracownik nie istnieje!");
        }
        if(!czyMaPracownika) {
            this.dodajPowiazanie("pracownik", "zamowienie", p1);
            czyMaPracownika = true;
        }else{
            System.out.println("Zamowienie juz ma przypisanego pracownika");
        }
    }

    public void dodajReklamacja(Reklamacja r1)throws Exception{
        if(r1 == null){
            throw new Exception("Nie ma takiej reklamacji!");
        }
        if(!czyMaReklamacje) {
            this.dodajPowiazanie("reklamacja", "zamowienie", r1);
            czyMaReklamacje = true;
        }else{
            System.out.println("Zamowienie juz ma przypisana reklamacje");
        }
    }

    public void dodajPlatnosc(Platnosc p1)throws Exception{
        if(p1 == null){
            throw new Exception("Nie ma takiej platnosci!");
        }
        if(!czyMaPlatnosc) {
            this.dodajPowiazanie("platnosc", "zamowienie", p1);
            czyMaPlatnosc = true;
        }else{
            System.out.println("Zamowienie juz ma przypisana platnosc");
        }
    }



    public LocalDate getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(LocalDate dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public Integer getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public float getWartoscZamowienia() throws Exception {
        return wartoscZamowienia();
    }
}
