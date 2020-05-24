import java.time.LocalDate;

public class Klient extends OsobaWSklepie {
    private boolean czyNowy(){
        return !this.czyMa2Powiazania("zamowienie");
    }
    private static int rabatPowitalny = 25;

    public Klient(String imie, String nazwisko, LocalDate dataUrodzenia, String plec) {
        super(imie, nazwisko, dataUrodzenia, plec);
    }

    public String toString()throws RuntimeException{
        try {
            return super.toString() + "nowy: " + czyNowy() + '\n';
        }
        catch(Exception e){
            return "Blad! Zly status";
        }
    }

    public boolean getCzyNowy(){
        return czyNowy();
    }

    public static int getRabatPowitalny() {
        return rabatPowitalny;
    }

    public static void setRabatPowitalny(int rabatPowitalny) {
        Klient.rabatPowitalny = rabatPowitalny;
    }
}
