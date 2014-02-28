/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kyselysailio;
import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Kuuntelija-luokka joka liittyy nimivalikkoon
 *
 * @author Miska
 * @see NimiValikko
 */
public class NimiValikkoKuuntelija implements ActionListener {

    private final NimiValikko valikko;
    private final JButton tallennuspainike;
    private final JTextField tekstikentta;
    private final JLabel syoteKehotus;
    private final Kyselysailio sailio;

    /**
     *
     * @param valikko
     * @param tekstikentta
     * @param tallennuspainike
     * @param syoteLabel
     * @param sailio
     */
    public NimiValikkoKuuntelija(NimiValikko valikko, JTextField tekstikentta,
            JButton tallennuspainike, JLabel syoteLabel, Kyselysailio sailio) {
        this.tallennuspainike = tallennuspainike;
        this.tekstikentta = tekstikentta;
        this.valikko = valikko;
        this.syoteKehotus = syoteLabel;
        this.sailio = sailio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("".equals(this.tekstikentta.getText())) {
            syoteKehotus.setText("Anna kyselylylle nimi!");

        }
        if (!"".equals(this.tekstikentta.getText())) {
            String kyselynNimi = this.tekstikentta.getText();
            Kysely uusiKysely = sailio.luoKysely(kyselynNimi);
            valikko.vaihdaValikko(Valikko.LUONTIKYSYMYKSET, uusiKysely);
            tekstikentta.setText("");
        }

    }
}
