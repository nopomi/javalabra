
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
    
public void lisaaKysely(Kysely kysely){
    kyselyt.put(kysely.getNimi(), kysely);
}
    
    
}
