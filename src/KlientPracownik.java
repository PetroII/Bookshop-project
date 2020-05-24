import java.time.LocalDate;

public class KlientPracownik extends Pracownik implements IKlient{
    Klient klient;
    private static int rabatPracowniczy = 25;

    public KlientPracownik(String imie, String nazwisko, LocalDate dataUrodzenia, String plec,
                           LocalDate dataZatrudnienia, float pensjaBrutto, String rodzajUmowy) {
        super(imie, nazwisko, dataUrodzenia, plec, dataZatrudnienia, pensjaBrutto, rodzajUmowy);
        klient = new Klient(imie, nazwisko, dataUrodzenia, plec);
    }

    public static int getRabatPracowniczy() {
        return rabatPracowniczy;
    }

    public static void setRabatPracowniczy(int rabatPracowniczy) {
        KlientPracownik.rabatPracowniczy = rabatPracowniczy;
    }

    public boolean getCzyNowy()throws Exception{
        return klient.getCzyNowy();
    }

    public int getRabatPowitalny(){
        return Klient.getRabatPowitalny();
    }

    public void setRabatPowitalny(int rabatPowitalny){
        Klient.setRabatPowitalny(rabatPowitalny);
    }



}
