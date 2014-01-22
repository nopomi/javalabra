

package javalabra.henkilostokysely.domain;


public class Vastaaja {

    private int henkilostoNumero;
    private String nimi;

    public Vastaaja(int henkilostoNumero, String nimi){
        this.henkilostoNumero = henkilostoNumero;
        this.nimi = nimi;
    }
    
    public int getNumero(){
        return this.henkilostoNumero;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
}
