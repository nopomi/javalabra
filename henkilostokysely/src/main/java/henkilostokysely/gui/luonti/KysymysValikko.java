
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Kysely;
import henkilostokysely.gui.Kayttoliittyma;
import java.awt.*;
import javax.swing.*;

/**
 * Valikko-luokka jossa luodaan uuden kyselyn kysymykset
 * @author Miska
 */
public class KysymysValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    private Kysely kysely;
    
    /**
     * 
     * @param kayttis
     */
    public KysymysValikko(Kayttoliittyma kayttis, Kysely kysely){
        super(new GridLayout(3, 10));
        this.kayttis=kayttis;
        this.kysely=kysely;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel otsikko = new JLabel("Syötä kysymykset:");
        
        
    }
    
}
