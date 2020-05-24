import java.io.Serializable;
import java.time.LocalDate;

public class Reklamacja extends ObjectPlusPlus implements Serializable {
    private LocalDate dataReklamacji;
    private String przyczyna;
    private String status;

    private boolean czyMaPracownika = false;
    private boolean czyMaZamowienie = false;

    private Reklamacja(LocalDate dataReklamacji, String przyczyna, String status) {
        super();
        this.dataReklamacji = dataReklamacji;
        this.przyczyna = przyczyna;
        this.status = status;
    }

    public String toString() {
        return "data reklamacji: " + dataReklamacji + '\n' +
                "przyczyna: " + przyczyna + '\n' +
                "status: " + status + '\n';
    }

    public static Reklamacja utworzReklamacje(Klient klient, LocalDate dataReklamacji,
                                              String przyczyna, String status )throws Exception{
        if(klient == null){
            throw new Exception("Klient nie istnieje!");
        }
        Reklamacja r1 = new Reklamacja(dataReklamacji, przyczyna, status);
        klient.dodajCzesc("reklamacja", "klient", r1);

        return r1;
    }

    public void dodajPracownik(Pracownik p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki pracownik nie istnieje!");
        }
        if(!czyMaPracownika){
            this.dodajPowiazanie("pracownik", "reklamacja", p1);
            czyMaPracownika = true;
        }else{
            System.out.println("Reklamacja juz ma przypisanego pracownika");
        }
    }

    public void dodajZamowienie(Zamowienie z1)throws Exception{
        if(z1 == null){
            throw new Exception("Takie zamowienie nie istnieje!");
        }
        if(!czyMaZamowienie){
            this.dodajPowiazanie("zamowienie", "reklamacja", z1);
            czyMaZamowienie = true;
        }else{
            System.out.println("Ta reklamacja juz ma zamowienie");
        }
    }

    public LocalDate getDataReklamacji() {
        return dataReklamacji;
    }

    public void setDataReklamacji(LocalDate dataReklamacji) {
        this.dataReklamacji = dataReklamacji;
    }

    public String getPrzyczyna() {
        return przyczyna;
    }

    public void setPrzyczyna(String przyczyna) {
        this.przyczyna = przyczyna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
