
package henkilostokysely.sna;


/**
 *
 * Linkki on kahden noodin välinen yhteys, eli suunnattu viiva.
 */
public class Linkki {
    
    private final double kapasiteetti;
    private final double paino;
    private final int id;
    
    /**
     * En vielä tiedä onko painosta ja kapasiteetista mitään hyötyä, 
     * mutta käytännössä ne kertovat miten "vahva yhteys" noodien välillä on
     * ja miten paljon tavaraa se pystyy välittämään. 
     * ID on linkin yksilöivä koodi, ei todennäköisesti tule olemaan tarpeellinen.
     * @param paino
     * @param kapasiteetti
     */
    public Linkki(double paino, double kapasiteetti){
        this.paino=paino;
        this.kapasiteetti=kapasiteetti;
        this.id = 0;
    }
    
    
    @Override
    public String toString(){
        return "Linkki"+this.id;
    }
    
}
