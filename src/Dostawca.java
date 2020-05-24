import java.io.Serializable;
import java.time.LocalDate;

public class Dostawca extends ObjectPlusPlus implements Serializable {
    private String nazwaDostawcy;
    private LocalDate dataOstatniejDostawy;

    private boolean czyMaAdres = false;

    public Dostawca(String nazwaDostawcy, LocalDate dataOstatniejDostawy){
        super();
        this.nazwaDostawcy = nazwaDostawcy;
        this.dataOstatniejDostawy = dataOstatniejDostawy;
    }

    public String toString() {
        return "nazwa dostawcy: " + nazwaDostawcy + '\n' +
                "data ostatniej dostawy: " + dataOstatniejDostawy + '\n';
    }

    public void dodajAdres(Adres a1)throws Exception{
        if(a1 == null){
            throw new Exception("Taki adres nie istnieje!");
        }
        if(!czyMaAdres) {
            this.dodajPowiazanie("adres", "dostawca", a1);
            czyMaAdres = true;
        }else{
            System.out.print("Ten dostawca juz ma adres\n");
        }
    }

    public void dodajProdukt(Produkt p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taki produkt nie istnieje!");
        }
        if(p1 instanceof Ksiazka){
            this.dodajPowiazanie("ksiazka", "dostawca", p1);
        }
    }

    public String getNazwaDostawcy() {
        return nazwaDostawcy;
    }

    public void setNazwaDostawcy(String nazwaDostawcy) {
        this.nazwaDostawcy = nazwaDostawcy;
    }

    public LocalDate getDataOstatniejDostawy() {
        return dataOstatniejDostawy;
    }

    public void setDataOstatniejDostawy(LocalDate dataOstatniejDostawy) {
        this.dataOstatniejDostawy = dataOstatniejDostawy;
    }
}
