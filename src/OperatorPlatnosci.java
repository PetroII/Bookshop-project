import java.io.Serializable;

public class OperatorPlatnosci extends ObjectPlusPlus implements Serializable {
    private String nazwaOperatora;
    private float prowizja;

    public OperatorPlatnosci(String nazwaOperatora, float prowizja) {
        super();
        this.nazwaOperatora = nazwaOperatora;
        this.prowizja = prowizja;
    }

    public String toString() {
        return "nazwa operatora: " + nazwaOperatora + '\n' +
                "prowizja: " + prowizja + '\n';
    }

    public void dodajPlatnosc(Platnosc p1)throws Exception{
        if(p1 == null){
            throw new Exception("Taka platnosc nie istnieje!");
        }
        this.dodajPowiazanie("platnosc", "operator platnosci", p1);
    }

    public String getNazwaOperatora() {
        return nazwaOperatora;
    }

    public void setNazwaOperatora(String nazwaOperatora) {
        this.nazwaOperatora = nazwaOperatora;
    }

    public float getProwizja() {
        return prowizja;
    }

    public void setProwizja(float prowizja) {
        this.prowizja = prowizja;
    }
}
