import java.time.LocalDate;

public class Autor extends Osoba {
    private String glownyGatunek;
    private String stopienNaukowy;

    public Autor(String imie, String nazwisko, LocalDate dataUrodzenia, String plec, String glownyGatunek,
                 String stopienNaukowy){
        super(imie, nazwisko, dataUrodzenia, plec);
        this.glownyGatunek = glownyGatunek;
        this.stopienNaukowy = stopienNaukowy;
    }

    public String toString() {
        return super.toString() + "glowny gatunek: " + glownyGatunek + '\n'
                + "stopien naukowy: " + stopienNaukowy + '\n';
    }

    public void dodajKsiazke(Ksiazka k1) throws Exception{
        if(k1 == null){
            throw new Exception("Taka ksiazka nie istnieje!");
        }
        this.dodajPowiazanie("ksiazka", "autor", k1);
    }

    public String getGlownyGatunek() {
        return glownyGatunek;
    }

    public void setGlownyGatunek(String glownyGatunek) {
        this.glownyGatunek = glownyGatunek;
    }

    public String getStopienNaukowy() {
        return stopienNaukowy;
    }

    public void setStopienNaukowy(String stopienNaukowy) {
        this.stopienNaukowy = stopienNaukowy;
    }
}
