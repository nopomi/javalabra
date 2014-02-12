
package henkilostokysely.gui.luonti;

import henkilostokysely.gui.Kayttoliittyma;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Miska
 */
public class KysymysValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    
    public KysymysValikko(Kayttoliittyma kayttis){
        super(new GridLayout(3, 3));
        this.kayttis=kayttis;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel otsikko = new JLabel("Syötä kysymykset:");
        
    }
    
}
