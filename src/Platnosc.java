import java.io.Serializable;
import java.time.LocalDate;

public class Platnosc extends ObjectPlusPlus implements Serializable {
    private LocalDate dataPlatnosci;
    private String rodzajPlatnosci(){
        if(czyMaOperatora) {
            return "Karta";
        }else{
            return "Gotowka";
        }
    }
    private float ileZaplacono;

    private boolean czyMaZamowienie = false;
    private boolean czyMaOperatora = false;

    public Platnosc(LocalDate dataPlatnosci, float ileZaplacono) {
        super();
        this.dataPlatnosci = dataPlatnosci;
        this.ileZaplacono = ileZaplacono;
    }

    public String toString() {
        return "data platnosci: " + dataPlatnosci + '\n' +
                "rodzaj platnosci: " + rodzajPlatnosci() + '\n' +
                "ile zaplacono: " + ileZaplacono + '\n';
    }

    public void dodajZamowienie(Zamowienie z1)throws Exception{
        if(z1 == null){
            throw new Exception("Takie zamowienie nie istnieje!");
        }
        if(!czyMaZamowienie){
            this.dodajPowiazanie("zamowienie", "platnosc", z1);
            czyMaZamowienie = true;
        }else{
            System.out.println("Platnosc juz ma przypisane zamowienie");
        }
    }

    public void dodajOperator(OperatorPlatnosci o1)throws Exception{
        if(o1 == null){
            throw new Exception("Taki operator platnosci nie istnieje!");
        }
        if(!czyMaOperatora){
            this.dodajPowiazanie("operator platnosci", "platnosc", o1);
            czyMaOperatora = true;
        }else{
            System.out.println("Platnosc juz ma przypisanego operatora platnosci");
        }
    }

    public LocalDate getDataPlatnosci() {
        return dataPlatnosci;
    }

    public void setDataPlatnosci(LocalDate dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    public float getIleZaplacono() {
        return ileZaplacono;
    }

    public void setIleZaplacono(float ileZaplacono) {
        this.ileZaplacono = ileZaplacono;
    }

    public String getRodzajPlatnosci(){
        return rodzajPlatnosci();
    }
}
