/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui;

/**
 * Enum-luokassa kaikki erilaiset valikot, jotka ovat olemassa
 * @author Miska
 */
public enum Valikko {
    
    /**
     * Ensimmäinen päävalikko
     */
    ALOITUS,
    
    /**
     * Valikko, jossa vastaaja antaa omat tietonsa
     */
    VASTAAJATIETO,
    /**
     * Vastaaja valitsee kyselyn johon haluaa vastata
     */
    VASTAAJAVALINTA,
    /**
     * Vastaaja täyttää vastaukset
     */
    VASTAAJAKYSELY,
    /**
     * Vastaajaa kiitetään ja ehdotetaan toista kyselyä
     */
    VASTAAJAKIITOS,
    
    /**
     * Analysoija antaa omat tietonsa (identifiointi)
     */
    ANALYSOINTITIETO,
    /**
     * Analysoija valitsee kyselyn
     */
    ANALYSOINTIKYSELY,
    /**
     * Analysoija valitsee analysoitavan kysymyksen
     */
    ANALYSOINTIKYSYMYS,
    /**
     * Numeeristen kysymysten tietovalikko
     */
    ANALYSOINTITILASTO,
    /**
     * Sosiogrammikysymysten tietovalikko
     */
    ANALYSOINTISNA,
    /**
     * Likert-kysymysten tietovalikko
     */
    ANALYSOINTILIKERT,
    /**
     * Avointen kysymyksten tietovalikko
     */
    ANALYSOINTIAVOIN,
    
    /**
     * Kyselyn nimen antamisen valikko
     */
    LUONTINIMI,
    /**
     * Kysymysten luomisen valikko
     */
    LUONTIKYSYMYKSET,
    /**
     * Talletuksen jälkeinen vahvistusvalikko
     */
    LUONTILOPETUS
    
   
    
    
}
