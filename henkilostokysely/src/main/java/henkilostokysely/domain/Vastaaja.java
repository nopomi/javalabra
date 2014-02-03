

package henkilostokysely.domain;

import java.util.ArrayList;


/**
 *
 * @author Miska
 */
public class Vastaaja {

    private int henkilostoNumero;
    private String nimi;
    private ArrayList<String> vastatut;

    /**
     * Metodi luo uuden Vastaaja-olion asettaen sille yksilöivän 
     * henkilostonumeron ja vastaajan nimen.
     * @param henkilostoNumero
     * @param nimi
     */
    public Vastaaja(int henkilostoNumero, String nimi){
        this.henkilostoNumero = henkilostoNumero;
        this.nimi = nimi;
        this.vastatut = new ArrayList<>();
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
