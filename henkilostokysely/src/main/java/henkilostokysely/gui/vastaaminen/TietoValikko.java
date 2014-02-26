package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Vastaaja;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        JLabel tyhja = new JLabel("");
        JLabel tayttoKehotus = new JLabel("Syötä nimesi ja henkilöstönumerosi");
        JLabel syotePalaute = new JLabel("");
        JTextField nimiKentta = new JTextField();
        JTextField henkilostoNumeroKentta = new JTextField();
        JLabel tyhja3 = new JLabel("");
        JButton tallennuspainike = new JButton("Tallenna");

        TietoValikkoKuuntelija kuuntelija = new TietoValikkoKuuntelija(this, nimiKentta,
                henkilostoNumeroKentta, syotePalaute, tallennuspainike);

        nimiKentta.addActionListener(kuuntelija);
        henkilostoNumeroKentta.addActionListener(kuuntelija);
        tallennuspainike.addActionListener(kuuntelija);


        add(tyhja);
        add(tayttoKehotus);
        add(syotePalaute);
        add(nimiKentta);
        add(henkilostoNumeroKentta);
        add(tyhja3);
        add(new JLabel(""));
        add(tallennuspainike);




    }

    void vaihdaValikko(Valikko valikko, Vastaaja vastaaja) {
        ValintaValikko kyselynvalintaValikko = new ValintaValikko(kayttis,
                vastaaja);
        kayttis.lisaaValikko(Valikko.VASTAAJAVALINTA, kyselynvalintaValikko);
        kayttis.vaihdaValikko(valikko);

    }
}
