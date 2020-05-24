import java.io.Serializable;
import java.util.ArrayList;

public class Adres extends ObjectPlusPlus implements Serializable {
    private String ulica;
    private short numer;
    private Integer numerMieszkania;
    private String miasto;
    private String kodPocztowy;
    private String panstwo;

    public Adres(String ulica, short numer, String miasto, String kodPocztowy, String panstwo) {
        super();
        this.ulica = ulica;
        this.numer = numer;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
        this.panstwo = panstwo;
    }

    public String toString() {
        return "ulica: " + ulica + '\n' +
                "numer: " + numer + '\n' +
                ((numerMieszkania==null)?"":"numerMieszkania: " + numerMieszkania + '\n') +
                "miasto: " + miasto + '\n' +
                "kodPocztowy: " + kodPocztowy + '\n' +
                "panstwo: " + panstwo + '\n';
    }

    public void dodajOsobaWSklepie(OsobaWSklepie o1)throws Exception{
        if(o1 == null){
            throw new Exception("Taka osoba nie istnieje!");
        }

        if(o1 instanceof Pracownik) {
            this.dodajPowiazanie("pracownik", "adres", o1);
        }else if(o1 instanceof Klient){
            this.dodajPowiazanie("klient", "adres", o1);
        }
    }

    public void dodajDostawce(Dostawca d1){
        this.dodajPowiazanie("dostawca", "adres", d1);
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public short getNumer() {
        return numer;
    }

    public void setNumer(short numer) {
        this.numer = numer;
    }

    public Integer getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(Integer numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(String panstwo) {
        this.panstwo = panstwo;
    }
}
