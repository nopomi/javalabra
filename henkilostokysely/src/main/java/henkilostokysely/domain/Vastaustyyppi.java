
package henkilostokysely.domain;



public enum Vastaustyyppi{
    

    /**
     * Luokka on kokoelma eri vastaustyyppejä, jotka vaikuttavat 
     * siihen minkälainen vastaustyyppi käyttöliittymässä näkyy.
     * 
     * Avoin vastaus on avoin tekstikenttä johon voi kirjottaa
     */
    AVOIN,
    
    /**
     *
     * Vastaustyyppi Likert on samaa mieltä, osittain samaa mieltä,
     * ei samaa eikä eri mieltä, osittain eri mieltä, eri mieltä
     */
    
    LIKERT,
    /**
     * Numeerinen asteikko, esim 1,2,3,4,5
     */
    ASTEIKKO,
    
    /**
     * Vastaaja nimeää kolme henkilöä vastauksena kysymykseen, voi olla esim
     * "Keneltä kolmelta pyydät todennäköisimmin apua kun kohtaat ongelmia
     * työssäsi?"
     */
    KOLMIKENTTA;
    
    
}
