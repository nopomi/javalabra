

package henkilostokysely.domain;


/**
 *
 * @author Miska
 */
public class Vastaaja {

    private int henkilostoNumero;
    private String nimi;

    /**
     * Metodi luo uuden Vastaaja-olion asettaen sille yksilöivän 
     * henkilostonumeron ja vastaajan nimen.
     * @param henkilostoNumero
     * @param nimi
     */
    public Vastaaja(int henkilostoNumero, String nimi){
        this.henkilostoNumero = henkilostoNumero;
        this.nimi = nimi;
    }
    
    
    /**
     * Metodi palauttaa kutsutulle oliolle henkilostonumeron.
     * @return yksilöivä henkilöstönumero
     */
    public int getNumero(){
        return this.henkilostoNumero;
    }
    

    
    /**
     * Metodi palauttaa kutsutulle oliolle vastaajan nimen.
     * @return vastaajan nimi.
     */
    public String getNimi(){
        return this.nimi;
    }
    
    
}
