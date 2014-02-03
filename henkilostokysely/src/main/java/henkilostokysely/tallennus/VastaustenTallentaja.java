package henkilostokysely.tallennus;

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
     * @param vastaaja
     * @param vastaus
     */
    public void talletaVastaus(int vastaaja, String vastaus) {
        try{
            FileWriter kirjoittaja = new FileWriter(this.indeksi+"_vastaukset.csv", true);
            kirjoittaja.append(vastaaja+","+vastaus+"\n");
            kirjoittaja.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Metodi tallentaa kolmikenttävastauksia tiedostoon.
     * Kolmikenttä-vastaustyypissä vastauksia annetaan aina 3 vastaajaa kohden.
     * Metodia on siis kuormitettu sen takia että voitaisiin myös tämänlaisia
     * vastauksia käsitellä järkevällä tavalla.
     * @param vastaaja
     * @param vastaus1
     * @param vastaus2
     * @param vastaus3
     * @see henkilostokysely.domain.Vastaustyyppi
     */
    public void talletavastaus(int vastaaja, int vastaus1, int vastaus2, int vastaus3){
        try{
            FileWriter kirjoittaja = new FileWriter(this.indeksi+"_vastaukset.csv", true);
            kirjoittaja.append(vastaaja+","+vastaus1+","+vastaus2+","+vastaus3+"\n");
            kirjoittaja.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
