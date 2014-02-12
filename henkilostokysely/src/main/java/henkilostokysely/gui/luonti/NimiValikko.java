package henkilostokysely.gui.luonti;

import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Miska
 */
public class NimiValikko extends JPanel {

    private Kayttoliittyma kayttis;

    public NimiValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3));
        this.kayttis = kayttis;
        luoKomponentit();
        
    }

    private void luoKomponentit() {

        JLabel annaNimi = new JLabel("Kyselyn nimi:");
        JTextField tekstiKentta = new JTextField();
        JButton tallennuspainike = new JButton("Luo");
        
        
        NimiValikkoKuuntelija kuuntelija = new NimiValikkoKuuntelija(
                this, tekstiKentta, tallennuspainike);
        
        tekstiKentta.addActionListener(kuuntelija);
        tallennuspainike.addActionListener(kuuntelija);
        
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(annaNimi);
        add(tekstiKentta);
        add(new JLabel(""));
        add(new JLabel(""));
        add(tallennuspainike);
        add(new JLabel(""));
        
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        kayttis.vaihdaValikko(vaihdettava);
    }
}
