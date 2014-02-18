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
public class AsteikkoVastausKentta extends JPanel{
    private Kysymys kysymys;
    private String[] vaihtoehdot = {"1", "2", "3", "4", "5"};
    
    public AsteikkoVastausKentta(Kysymys kysymys){
        super(new GridLayout(1,2));
        this.kysymys=kysymys;
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JLabel(kysymys.getKysymys()));
        JComboBox vastaus = new JComboBox(vaihtoehdot);
        add(vastaus);
    }
}
