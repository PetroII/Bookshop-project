import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {
    private Hashtable<String, HashMap<Object, ObjectPlusPlus>> powiazania =
            new Hashtable<String, HashMap<Object, ObjectPlusPlus>>();

    private static HashSet<ObjectPlusPlus> wszystkieCzesci =
            new HashSet<ObjectPlusPlus>();

    public ObjectPlusPlus(){
        super();
    }

    private void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus obiektDocelowy,
                                 Object kwalifikator, int licznik) {
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        if(licznik < 1) {
            return;
        }
        if(powiazania.containsKey(nazwaRoli)) {
            powiazaniaObiektu = powiazania.get(nazwaRoli);
        }
        else {
            powiazaniaObiektu = new HashMap<Object, ObjectPlusPlus>();
            powiazania.put(nazwaRoli, powiazaniaObiektu);
        }
        if(!powiazaniaObiektu.containsKey(kwalifikator)) {
            powiazaniaObiektu.put(kwalifikator, obiektDocelowy);
            obiektDocelowy.dodajPowiazanie(odwrotnaNazwaRoli, nazwaRoli, this, this, licznik - 1);
        }
    }

    protected void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli,
                                ObjectPlusPlus obiektDocelowy, Object kwalifikator) {
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektDocelowy, kwalifikator, 2);
    }

    protected void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli,
                                ObjectPlusPlus obiektDocelowy) {
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektDocelowy, obiektDocelowy);
    }

    public void dodajCzesc(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus
            obiektCzesc) throws Exception {
        if(wszystkieCzesci.contains(obiektCzesc)) {
            throw new Exception("Ta czesc jest już powiazana z jakas caloscia!");
        }
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektCzesc);
        wszystkieCzesci.add(obiektCzesc);
    }

    public ObjectPlusPlus[] dajPowiazania(String nazwaRoli) throws Exception {
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        if(!powiazania.containsKey(nazwaRoli)) {
            throw new Exception("Brak powiazan dla roli: " + nazwaRoli);
        }
        powiazaniaObiektu = powiazania.get(nazwaRoli);
        return (ObjectPlusPlus[]) powiazaniaObiektu.values().toArray(new ObjectPlusPlus[0]);
    }

    public void wyswietlPowiazania(String nazwaRoli, PrintStream stream) throws Exception {
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        if(!powiazania.containsKey(nazwaRoli)) {
            throw new Exception("Brak powiazan dla roli: " + nazwaRoli);
        }
        powiazaniaObiektu = powiazania.get(nazwaRoli);
        Collection col = powiazaniaObiektu.values();
        stream.println("\n" + this.getClass().getSimpleName() + " powiazania w roli " + nazwaRoli + ":");
        for(Object obj : col) {
            stream.println(" " + obj);
        }
    }

    public boolean czyMa2Powiazania(String nazwaRoli){
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        int licznik = 0;
        if(!powiazania.containsKey(nazwaRoli)){
            return false;
        }else {
            powiazaniaObiektu = powiazania.get(nazwaRoli);
            Collection col = powiazaniaObiektu.values();
            for (Object obj : col) {
                licznik += 1;
            }
            return !(licznik <= 1);

        }

    }

    public Collection getObiekty(String nazwaRoli) throws Exception{
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        if(!powiazania.containsKey(nazwaRoli)) {
            throw new Exception("Brak powiazan dla roli: " + nazwaRoli);
        }
        powiazaniaObiektu = powiazania.get(nazwaRoli);
        Collection col = powiazaniaObiektu.values();

        return col;
    }



    public ObjectPlusPlus dajPowiazanyObiekt(String nazwaRoli, Object kwalifikator) throws Exception {
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;
        if(!powiazania.containsKey(nazwaRoli)) {
            throw new Exception("Brak powiazan dla roli: " + nazwaRoli);
        }
        powiazaniaObiektu = powiazania.get(nazwaRoli);
        if(!powiazaniaObiektu.containsKey(kwalifikator)) {
            throw new Exception("Brak powiazania dla kwalifikatora: " + kwalifikator);
        }
        return powiazaniaObiektu.get(kwalifikator);
    }




}
