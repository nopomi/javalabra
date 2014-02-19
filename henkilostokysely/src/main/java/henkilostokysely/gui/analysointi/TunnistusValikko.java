/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import henkilostokysely.gui.vastaaminen.TietoValikkoKuuntelija;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @see Valikko
 * @author Miska
 */
public class TunnistusValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    
    public TunnistusValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis = kayttis;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel tyhja = new JLabel("");
        JLabel tayttoKehotus = new JLabel("Syötä nimesi ja tunnuslukusi");
        JLabel tyhja2 = new JLabel("");
        JTextField nimiKentta = new JTextField();
        JPasswordField tunnuslukuKentta = new JPasswordField();
        JLabel tyhja3 = new JLabel("");
        JButton tallennuspainike = new JButton("Tallenna");

        TunnistusValikkoKuuntelija kuuntelija = new TunnistusValikkoKuuntelija(this, nimiKentta,
                tunnuslukuKentta, tallennuspainike);

        nimiKentta.addActionListener(kuuntelija);
        tunnuslukuKentta.addActionListener(kuuntelija);
        tallennuspainike.addActionListener(kuuntelija);


        add(tyhja);
        add(tayttoKehotus);
        add(tyhja2);
        add(nimiKentta);
        add(tunnuslukuKentta);
        add(tyhja3);
        add(new JLabel(""));
        add(tallennuspainike);


    }

    void vaihdaValikko(Valikko valikko) {
        KyselyValintaValikko kyselyValikko = new KyselyValintaValikko(kayttis);
        kayttis.lisaaValikko(Valikko.ANALYSOINTIKYSELY, kyselyValikko);
        kayttis.vaihdaValikko(valikko);
    }
    
}
