public class Ksiazka extends Produkt {
    private String tytul;
    private String gatunek;
    private int liczbaStron;
    private String oprawa;

    public Ksiazka(String nazwa, String producent, float cena, String status, String tytul, String gatunek,
                   int liczbaStron, String oprawa){
        super(nazwa, producent, cena, status);
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.liczbaStron = liczbaStron;
        this.oprawa = oprawa;
    }

    public String toString() {
        return super.toString() + "tytul: " + tytul + '\n' +
                "gatunek: " + gatunek + '\n' +
                "liczba stron: " + liczbaStron + '\n' +
                "oprawa: " + oprawa + '\n';
    }

    public void dodajAutora(Autor a1)throws Exception{
        if(a1 == null){
            throw new Exception("Taki autor nie istnieje!");
        }
        this.dodajPowiazanie("autor", "ksiazka", a1);
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getLiczbaStron() {
        return liczbaStron;
    }

    public void setLiczbaStron(int liczbaStron) {
        this.liczbaStron = liczbaStron;
    }

    public String getOprawa() {
        return oprawa;
    }

    public void setOprawa(String oprawa) {
        this.oprawa = oprawa;
    }
}
