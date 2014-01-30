
package henkilostokysely.domain;

import java.util.Objects;
import henkilostokysely.tallennus.VastaustenTallentaja;


public class Kysymys {
    
    private String kysymys;
    private Vastaustyyppi tyyppi;
    private VastaustenTallentaja tallentaja;
    private int indeksi;
    
    public Kysymys(String kysymys, Vastaustyyppi tyyppi, int indeksi){
        this.kysymys = kysymys;
        this.tyyppi=tyyppi;
        this.tallentaja= new VastaustenTallentaja(indeksi);
        this.indeksi=indeksi;
    }
    
    public String getKysymys(){
        return this.kysymys;
    }
    
    public Vastaustyyppi getTyyppi(){
        return this.tyyppi;
    }
    
        @Override
    public boolean equals(Object olio){
        if(olio==null){
            return false;
        }
        
        if(this.getClass()!=olio.getClass()){
            return false;
        }
        
        Kysymys verrattava = (Kysymys) olio;
        
        if(!verrattava.kysymys.equals(this.kysymys)){
            return false;
        }
        if(!verrattava.tyyppi.equals(this.tyyppi)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.kysymys);
        hash = 59 * hash + (this.tyyppi != null ? this.tyyppi.hashCode() : 0);
        return hash;
    }
        
    public int getIndeksi(){
        return this.indeksi;
    }
    
    public VastaustenTallentaja getTallentaja(){
        return this.tallentaja;
    }

    public void setIndeksi(int indeksi) {
        this.indeksi=indeksi;
        this.tallentaja.setIndeksi(indeksi);
    }
    
    public void lisaaVastaus(int henkilostoNumero, String vastaus){
        this.tallentaja.talletaVastaus(henkilostoNumero, vastaus);
    }
}
