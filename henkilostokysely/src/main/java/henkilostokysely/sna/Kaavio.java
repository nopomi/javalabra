
package henkilostokysely.sna;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.Collection;


/**
 * Tässä luokassa luodaan sosiogrammin kapsoloiva olio, eli 
 * Graph-olio. Siihen lisätään ihmisiä kuvastavia noodeja ja
 * niiden välisiä yhteyksiä kuvastavia linkkjä.
 */
public class Kaavio {
    
    DirectedSparseMultigraph<Noodi,Linkki> kaavio;
    
    /**
     * Metodi luo uuden kaavion johon voidaan lisätä noodeja ja linkkejä.
     */
    public Kaavio(){
        this.kaavio=new DirectedSparseMultigraph<>();
    }
    
    /**
     * Metodi luo linkin kahden parametrina annetun noodin välille.
     * @param lahtoNoodi
     * @param paamaaraNoodi
     */
    public void lisaaLinkki(Noodi lahtoNoodi, Noodi paamaaraNoodi){
        kaavio.addEdge(new Linkki(2.0, 48), lahtoNoodi, paamaaraNoodi, EdgeType.DIRECTED);
    }
    
    /**
     * Metodi lisää uuden noodin kaavioon ja palauttaa lisätyn noodin.
     * Jos parametrina annettu noodi löytyy jo kaaviosta, palautetaan
     * sitä vastaava jo kaaviossa oleva noodi.
     * @param noodi lisättävä noodi
     * @return lisätty noodi tai jo olemassa oleva vastaava noodi.
     */
    public Noodi lisaaNoodi(Noodi noodi){
        if(!kaavio.containsVertex(noodi)){
            kaavio.addVertex(noodi);
            
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
    
    /**
     * Metodi palauttaa kaavion kokonaisuudessaan.
     * @return kaavio
     */
    public DirectedSparseMultigraph getKaavio(){
        return this.kaavio;
    }
    
    @Override
    public String toString(){
        return this.kaavio.toString();
    }


    
}
