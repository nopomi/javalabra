package javalabra.henkilostokysely.domain;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kysely {

    private HashMap<Integer, Kysymys> kysymykset;
    //private List<Integer> vastanneet;
    //tähän tulee myöhemmin toiminto joka varmistaa että 1 vastaus / tyyppi / kysely
    private String nimi;

    public Kysely(String nimi) {
        this.kysymykset = new HashMap<>();
        //this.vastanneet = new ArrayList<>();
        this.nimi = nimi;
    }

    public boolean lisaaKysymys(String kysymys, Vastaustyyppi tyyppi) {
        Kysymys lisattava = luoKysymys(kysymys,tyyppi);
        if (this.kysymykset.containsValue(lisattava)) {
            return false;
        }
        this.kysymykset.put(kysymykset.size() + 1, lisattava);
        lisattava.setIndeksi(kysymykset.size());
        return true;
    }
    
    public Kysymys luoKysymys(String kysymysteksti, Vastaustyyppi tyyppi){
        Kysymys kysymys = new Kysymys(kysymysteksti, tyyppi);
        return kysymys;
        
    }

    public HashMap getKysymykset() {
        return this.kysymykset;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
}
