import java.time.LocalDate;

public abstract class OsobaWSklepie extends Osoba {
    private Integer numerTelefonu;
    private String adresEmail;

    protected OsobaWSklepie(String imie, String nazwisko, LocalDate dataUrodzenia, String plec){
        super(imie, nazwisko, dataUrodzenia, plec);
        this.numerTelefonu = null;
        this.adresEmail = null;

    }

    public void dodajAdres(Adres a1)throws Exception{
        if(a1 == null){
            throw new Exception("Taki adres nie istnieje!");
        }
        if(this instanceof Pracownik) {
            this.dodajPowiazanie("adres", "pracownik", a1);
        }else if(this instanceof Klient){
            this.dodajPowiazanie("adres", "klient", a1);
        }
    }

    public String toString() {
        return super.toString() +
                ((numerTelefonu == null)?"":"numer telefonu: "+numerTelefonu+'\n') +
                ((adresEmail == null)?"":"adres email: "+adresEmail+'\n');
    }

    public Integer getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(Integer numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }
}
