
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysely;
import henkilostokysely.gui.Kayttoliittyma;
import javax.swing.JPanel;

/**
 * Valikko-luokka, jossa vastaaja täyttää vastaukset
 * @author Miska
 */
public class KyselyValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    private Kysely kysely;
    
    
    public KyselyValikko(Kayttoliittyma kayttis, Kysely kysely){
        this.kayttis=kayttis;
        this.kysely=kysely;
        luoKomponentit();
    }
    
}
