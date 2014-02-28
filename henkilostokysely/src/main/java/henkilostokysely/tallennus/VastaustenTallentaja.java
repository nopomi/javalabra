package henkilostokysely.tallennus;

import henkilostokysely.domain.Kysely;
import java.io.FileWriter;

/**
 *
 * Luokka kirjoittaa tiedostoon anettuja vastauksia.
 * Indeksi kertoo mihin kysymykseen se liittyy, myös tiedostot nimetään sen 
 * mukaan
 * 
 */

public class VastaustenTallentaja {
    
    private int indeksi;
    
    /**
     * Metodi luo vastaustentallentajan ja antaa sille indeksin.
     * @param indeksi
     * 
     */
    public VastaustenTallentaja(int indeksi){
        this.indeksi=indeksi;
    }
    
    /**
     * Metodi asettaa tallentajalle uuden indeksin.
     * Indeksiä voidaan tarvittaessa muuttaa mutta en usko, että
     * tulee olemaan tarpeellinen metodi.
     * @param indeksi
     */
    public void setIndeksi(int indeksi){
        this.indeksi=indeksi;
    }
    
    /**
     * Antaa vastaustentallentajan indeksin.
     * @return
     */
    public int getIndeksi(){
        return this.indeksi;
    }
    
    /**
     * Metodi kirjoittaa tiedostoon ja käsittelee mahdolliset virheet.
     * Kirjoittaja kirjoittaa eri riveille ja erittelee vastaukset siten
     * että sen muoto on "VASTAAJAID, VASTAUS".
     * @param kysely
     * @param vastaaja
     * @param vastaus
     */
    public void talletaVastaus(Kysely kysely, int vastaaja, String vastaus) {
        try{
            FileWriter kirjoittaja = new FileWriter(kysely.getNimi()+"_"+this.indeksi+"_vastaukset.csv", true);
            kirjoittaja.append(vastaaja+","+vastaus+"\n");
            kirjoittaja.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
