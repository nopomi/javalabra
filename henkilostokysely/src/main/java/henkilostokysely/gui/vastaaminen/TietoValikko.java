package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Vastaaja;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Valikko-luokka, jossa vastaaja antaa omat tietonsa ja uusi vastaaja luodaan /
 * liitetään tulevat vastaukset vastaaja-olioon
 *
 * @author Miska
 * @see Vastaaja
 */
public class TietoValikko extends JPanel {

    private Kayttoliittyma kayttis;

    public TietoValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis = kayttis;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JTextField nimiKentta = new JTextField();
        JTextField henkilostoNumeroKentta = new JTextField();
        JButton tallennuspainike = new JButton("");
        
        TietoValikkoKuuntelija kuuntelija = new TietoValikkoKuuntelija(this, nimiKentta,
        henkilostoNumeroKentta, tallennuspainike);
        
        nimiKentta.addActionListener(kuuntelija);
        henkilostoNumeroKentta.addActionListener(kuuntelija);
        tallennuspainike.addActionListener(kuuntelija);
        
        
    }

    void vaihdaValikko(Valikko valikko, Vastaaja vastaaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
