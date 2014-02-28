/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysymys;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mnoponen@cs
 */
class LikertVastausKentta extends JPanel implements VastausKentta {

    private final Kysymys kysymys;
    private final String[] vaihtoehdot = {"Samaa mieltä", "Osittain samaa mieltä",
        "Ei samaa eikä eri mieltä", "Osittain eri mieltä", "Eri mieltä"};
    private JComboBox vastaus;

    public LikertVastausKentta(Kysymys kysymys) {
        super(new GridLayout(1, 2));
        this.kysymys = kysymys;
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JLabel(kysymys.getKysymys()));
        vastaus = new JComboBox(vaihtoehdot);
        add(vastaus);

    }

    @Override
    public String getVastaus() {
        return vastaus.getSelectedIndex() + 1 + "";
    }
}
