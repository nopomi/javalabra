
package henkilostokysely.sna;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.Collection;


public class Kaavio {
    
    DirectedSparseMultigraph<Noodi,Linkki> kaavio;
    
    public Kaavio(){
        this.kaavio=new DirectedSparseMultigraph<>();
    }
    
    public void lisaaLinkki(Noodi lahtoNoodi, Noodi paamaaraNoodi){
        kaavio.addEdge(new Linkki(2.0, 48), lahtoNoodi, paamaaraNoodi, EdgeType.DIRECTED);
    }
    
    public Noodi lisaaNoodi(Noodi noodi){
        if(!kaavio.containsVertex(noodi)){
            kaavio.addVertex(noodi);
            return noodi;
        } else {
            Collection<Noodi> noodit = kaavio.getVertices();
            for (Noodi seuraava : noodit) {
                if(noodi.equals(seuraava)){
                    return seuraava;
                }
            }
        }
        return noodi;
    }
    
    public Object getKaavio(){
        return this.kaavio;
    }
    
    @Override
    public String toString(){
        return this.kaavio.toString();
    }


    
}
