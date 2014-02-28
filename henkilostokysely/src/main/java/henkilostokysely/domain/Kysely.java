package henkilostokysely.domain;

import java.util.HashMap;

/**
 * Luokka jossa on kysymyksiä sisältävä Kysely-olio, jolla on nimi.
 * @author Miska
 */

public class Kysely {

    private HashMap<Integer, Kysymys> kysymykset;
    private String nimi;

    /**
     *Metodi luo uuden kyselyn, joka käytännössä on lista kysymyksiä
     * ja kyselyn nimi. Kysely tietää myös ketkä siihen ovat jo vastanneet,
     * jotta ei tule duplikaatteja
     * @param nimi kyselyn nimi
     */
    public Kysely(String nimi) {
        this.kysymykset = new HashMap<>();
        //this.vastanneet = new ArrayList<>();
        this.nimi = nimi;
    }

    /**
     *Metodi lisaa kyselyyn uuden kysymyksen, mikäli sitä ei ole vielä olemassa.
     * Uusi kysymys luodaan käyttäen metodia luoKysymys. Palauttaa falsen jos
     * kysymys on jo lisätty kyselyyn.
     * @param kysymys Kysymyksen kysymys tekstinä
     * @param tyyppi Kysymyksen vastaustyyppi.
     * @return
     */
    public boolean lisaaKysymys(String kysymys, Vastaustyyppi tyyppi) {
        Kysymys lisattava = luoKysymys(kysymys,tyyppi);
        if (this.kysymykset.containsValue(lisattava)) {
            return false;
        }
        this.kysymykset.put(kysymykset.size()+1, lisattava);
        lisattava.setKysely(this);
        return true;
    }
    
    /**
     * Metodi luo uuden kysymyksen käyttäen Kysymys-luokan konstruktoria.
     * Ottaa parametrina kysymyksen tekstinä ja vastaustyypin.
     * @param kysymysteksti Kysymys tekstinä
     * @param vastaustyyppi Kysymyksen vastauksen muoto (enum)
     * @return luotu Kysymys-olio
     */
    public Kysymys luoKysymys(String kysymysteksti, Vastaustyyppi tyyppi){
        Kysymys kysymys = new Kysymys(kysymysteksti, tyyppi, kysymykset.size()+1);
        return kysymys;
    }

    /**
     * Metodi palauttaa kyselyyn lisätyt kysymykset.
     * @return kysymykset HashMap:issa kyselyn kysymykset
     */
    public HashMap getKysymykset() {
        return this.kysymykset;
    }
    
    /**
     * Metodi palauttaa kyselyn nimen.
     * @return nimi kyselyn nimi
     */
    public String getNimi(){
        return this.nimi;
    }
    
    /**
     * Metodi palauttaa kyselyn kysymysten määrän, käytetään käyttöliittymässä
     * @see henkilostokysely.gui.luonti.KysymysValikko
     * @return kysymysten määrä kokonaislukuna
     */
    
    public int getKoko(){
        return this.kysymykset.size();
    }
        
}
