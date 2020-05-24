import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Osoba extends ObjectPlusPlus implements Serializable {
    private String imie;
    private String drugieImie;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private int wiek(){
        if(dataUrodzenia != null){
            return Period.between(dataUrodzenia, LocalDate.now()).getYears();
        }else{
            return 0;
        }
    }
    private String plec;

    protected Osoba(String imie, String nazwisko, LocalDate dataUrodzenia, String plec){
        super();
        this.imie = imie;
        this.drugieImie = null;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
    }


    public String toString() {
        return  "imie: " + imie + '\n' +
                ((drugieImie == null)?"":"drugie imie: " + drugieImie + '\n' )+
                "nazwisko: " + nazwisko + '\n' +
                "wiek: " + wiek() + '\n' +
                "plec: " + plec + '\n';
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugieImie() {
        return drugieImie;
    }

    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getWiek(){
        return wiek();
    }
}
