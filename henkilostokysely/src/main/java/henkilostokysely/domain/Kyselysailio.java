
package henkilostokysely.domain;

import java.util.HashMap;

/**
 * Luokka jossa on kyselyitä sisältävä Kyselysäiliö.
 * Kyselysäiliö sisältää kyselyitä -> kysely sisältää kysymyksiä
 * @author Miska
 */
public class Kyselysailio {
    
    private HashMap<String, Kysely> kyselyt;
    
    public Kyselysailio(){
        this.kyselyt=new HashMap<>();
    }
    
    /**
     * Metodi lisää kyselyn kyselysäiliöön, ei tarkista duplikaatteja
     * koska voi olla että halutaan tehdä identtinen kysely mutta uusilla 
     * vastauksilla (jos jotain jatkumotutkimuksia tehdään)
     * @param kysely lisättävä kysely
     */
    
public void lisaaKysely(Kysely kysely){
    kyselyt.put(kysely.getNimi(), kysely);
}

/**
 * Metodi palauttaa kyselysäiliön
 * @return kyselyt hashmapissa
 */

public HashMap getKyselyt(){
    return this.kyselyt;
}

public Kysely getKysely(String nimi){
    return kyselyt.get(nimi);
}

/**
 * luo uuden kyselyn annetulle nimelle, ja palauttaa luodun Kysely-olion.
 * Lisää uuden kyselyn säiliöönsä.
 * @param nimi Kyselyn nimi
 * @return luotu kysely-olio
 */

public Kysely luoKysely(String nimi){
    
    Kysely uusiKysely = new Kysely(nimi);
    kyselyt.put(nimi, uusiKysely);
    
    return uusiKysely;
}
    
    
}
