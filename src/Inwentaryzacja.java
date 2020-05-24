import java.io.Serializable;
import java.time.LocalDate;

public class Inwentaryzacja extends ObjectPlusPlus implements Serializable {
    private LocalDate dataInwentaryzacji;
    private String status() throws Exception {
        int licznik = 0;
        for(Object obj : this.getObiekty("ksiazka")){
            licznik += 1;
        }

        if(licznik==ObjectPlus.policzEkstensje(Ksiazka.class)){
            return "Liczba produktow zgadza sie";
        }else if(licznik>ObjectPlus.policzEkstensje(Ksiazka.class)){
            return "Jest za duzo produktow!";
        }else{
            return "Jest za malo produktow!";
        }

    }

    public String toString() {
        try {
            return "data inwentaryzacji: " + dataInwentaryzacji + '\n' +
                    "status: " + status() + '\n';
        }
        catch(Exception e){
            return "Brak obiektow w inwentaryzacji!";
        }
    }

    public Inwentaryzacja(LocalDate dataInwentaryzacji) {
        super();
        this.dataInwentaryzacji = dataInwentaryzacji;
    }

    public void dodajPracownik(Pracownik p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki pracownik nie istnieje!");
        }
        this.dodajPowiazanie("pracownik", "inwentaryzacja", p1);
    }

    public void dodajProdukt(Produkt p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki produkt nie istnieje!");
        }
        if(p1 instanceof Ksiazka) {
            this.dodajPowiazanie("ksiazka", "inwentaryzacja", p1);
        }
    }

    public LocalDate getDataInwentaryzacji() {
        return dataInwentaryzacji;
    }

    public void setDataInwentaryzacji(LocalDate dataInwentaryzacji) {
        this.dataInwentaryzacji = dataInwentaryzacji;
    }

    public String getStatus() throws Exception {
        return status();
    }
}
