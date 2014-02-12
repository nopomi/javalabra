
package henkilostokysely.domain;

import java.util.HashMap;

/**
 *
 * @author Miska
 */
public class Kyselysailio {
    
    private HashMap<String, Kysely> kyselyt;
    
    public Kyselysailio(){
        this.kyselyt=new HashMap<>();
    }
    
    public Kysely luoKysely(String nimi){
        Kysely uusiKysely = new Kysely(nimi);
        kyselyt.put(nimi, uusiKysely);
        
        return uusiKysely;
    }
    
    
}
