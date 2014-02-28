
package henkilostokysely.domain;

import java.util.Objects;
import henkilostokysely.tallennus.VastaustenTallentaja;



public class Kysymys {
    
    private String kysymys;
    private Vastaustyyppi tyyppi;
    private VastaustenTallentaja tallentaja;
    private int indeksi;
    private Kysely kysely;
    
    /**
     * Metodi luo uuden Kysymys-olion ja lisää sille VastaustenTallentajan.
     * @param kysymys Kysyttävä kysymys tekstinä
     * @param tyyppi Kysymyksen vastaustyyppi
     * @param indeksi Kysymyksen järjestysnumero kyselyssä, monesko se on.
     */
    public Kysymys(String kysymys, Vastaustyyppi tyyppi, int indeksi){
        this.kysymys = kysymys;
        this.tyyppi=tyyppi;
        this.tallentaja= new VastaustenTallentaja(indeksi);
        this.indeksi=indeksi;
    }
    
    /**
     * Metodi palauttaa kysymyksen tekstinä.
     * @return kysymys
     */
    public String getKysymys(){
        return this.kysymys;
    }
    
    /**
     * Metodi palauttaa kysymyksen vastaustyypin.
     * @return vastaustyypi
     */
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
        
    /**
     * Metodi palauttaa kysymyksen indeksin, eli järjestysluvun kyselyssä.
     * @return indeksiluku
     */
    public int getIndeksi(){
        return this.indeksi;
    }
    
    /**
     * Metodi palauttaa kyselyyn liittyvän VastaustenTallentajan.
     * @return
     */
    public VastaustenTallentaja getTallentaja(){
        return this.tallentaja;
    }

    /**
     * Metodi asettaa kysymykselle uuden järjestysluvun kyselyssä ja antaa saman
     * indeksin vastaustentallentajalle.
     * @param indeksi
     */
    public void setIndeksi(int indeksi) {
        this.indeksi=indeksi;
        this.tallentaja.setIndeksi(indeksi);
    }
    
    /**
     * Metodi lisää uuden vastauksen kysymykselle ja tallentaa sen 
     * käyttäen VastaustenTallentaja-oliota.
     * @param henkilostoNumero vastaajan henkilostonumero
     * @param vastaus annettu vastaus tekstinä
     */
    public void lisaaVastaus(int henkilostoNumero, String vastaus){
        this.tallentaja.talletaVastaus(kysely, henkilostoNumero, vastaus);
    }
    
    public void setKysely(Kysely kysely){
        this.kysely=kysely;
    }
    
    public Kysely getKysely(){
        return this.kysely;
    }
}
