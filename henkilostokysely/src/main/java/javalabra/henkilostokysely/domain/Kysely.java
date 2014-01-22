
package javalabra.henkilostokysely.domain;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Kysely {
    
    private Map<Integer, Kysymys> kysymykset;
    private List<Integer> vastanneet;
    private String nimi;
    
    
    
    
    
    public Kysely(String nimi){
        this.kysymykset = new HashMap<>();
        this.vastanneet = new ArrayList<>();
        this.nimi=nimi;
    }
    
    public void lisaaKysymys(Kysymys kysymys){
        this.kysymykset.put(kysymykset.size()+1, kysymys);
    }
    
    public Map getKysymykset(){
        return this.kysymykset;
    }
    
    
}
