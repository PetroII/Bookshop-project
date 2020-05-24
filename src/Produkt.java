import java.io.Serializable;

public abstract class Produkt extends ObjectPlusPlus implements Serializable {
    private String nazwa;
    private String producent;
    private float cena;
    private String status;

    private boolean czyMaPracownika = false;

    protected Produkt(String nazwa, String producent, float cena, String status){
        super();
        this.nazwa = nazwa;
        this.producent = producent;
        this.cena = cena;
        this.status = status;
    }

    public String toString() {
        return "nazwa: " + nazwa + '\n' +
                "producent: " + producent + '\n' +
                "cena: " + cena + '\n' +
                "status: " + status + '\n';
    }

    public void dodajDostawca(Dostawca d1)throws Exception{
        if(d1 == null){
            throw new Exception("Taki dostawca nie istnieje!");
        }
        if(this instanceof Ksiazka) {
            this.dodajPowiazanie("dostawca", "ksiazka", d1);
        }
    }

    public void dodajInwentaryzacja(Inwentaryzacja i1)throws Exception{
        if(i1 == null){
            throw new Exception("Nie ma takiej inwentaryzacji!");
        }
        if(this instanceof Ksiazka){
            this.dodajPowiazanie("inwentaryzacja", "ksiazka", i1);
        }
    }

    public void dodajPracownik(Pracownik p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki pracownik nie istnieje!");
        }
        if(!czyMaPracownika) {
            if (this instanceof Ksiazka) {
                this.dodajPowiazanie("pracownik", "ksiazka", p1);
                czyMaPracownika = true;
            }
        }else{
            System.out.println("Produkt juz ma przypisanego pracownika");
        }
    }

    public void dodajZamowienie(Zamowienie z1)throws Exception{
        if(z1 == null){
            throw new Exception("Takie zamowienie nie istnieje!");
        }
        if(this instanceof Ksiazka){
            this.dodajPowiazanie("zamowienie", "ksiazka", z1);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
