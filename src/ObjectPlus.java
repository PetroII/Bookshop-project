import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public abstract class ObjectPlus implements Serializable {
    private static Hashtable ekstensje = new Hashtable();

    protected ObjectPlus(){
        Vector ekstensja = null;
        Class klasa = this.getClass();

        if(ekstensje.containsKey(klasa)){
            ekstensja = (Vector) ekstensje.get(klasa);
        }else{
            ekstensja = new Vector();
            ekstensje.put(klasa, ekstensja);
        }

        ekstensja.add(this);
    }

    public static void pokazEkstensje(Class klasa) throws Exception{
        Vector ekstensja = null;
        if(ekstensje.containsKey(klasa)){
            ekstensja = (Vector) ekstensje.get(klasa);
        }else{
            throw new Exception("Nieznana klasa " + klasa);
        }

        System.out.println("Ekstensja klasy: " + klasa.getSimpleName());
        for(Object obiekt : ekstensja){
            System.out.println(obiekt);
        }

    }

    public static int policzEkstensje(Class klasa) throws Exception{
        Vector ekstensja = null;
        int licznik = 0;
        if(ekstensje.containsKey(klasa)){
            ekstensja = (Vector) ekstensje.get(klasa);
        }else{
            throw new Exception("Nieznana klasa " + klasa);
        }

        for(Object obiekt : ekstensja){
            licznik += 1;
        }

        return licznik;
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException{
        stream.writeObject(ekstensje);
    }

    public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensje = (Hashtable) stream.readObject();
    }


}
