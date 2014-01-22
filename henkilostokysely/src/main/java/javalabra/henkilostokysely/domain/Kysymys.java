
package javalabra.henkilostokysely.domain;


public class Kysymys {
    
    private String kysymys;
    private Vastaustyyppi tyyppi;
    
    public Kysymys(String kysymys, Vastaustyyppi tyyppi){
        this.kysymys = kysymys;
        this.tyyppi=tyyppi;
    }
    
    public String getKysymys(){
        return this.kysymys;
    }
    
    public Vastaustyyppi getTyyppi(){
        return this.tyyppi;
    }
    
}
