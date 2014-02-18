/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.gui.Valikko;
import henkilostokysely.gui.luonti.LopetusValikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Miska
 */
public class KiitosValikkoKuuntelija implements ActionListener {

    private KiitosValikko valikko;
    private final JButton takaisinValikkoonPainike;

    public KiitosValikkoKuuntelija(KiitosValikko valikko, JButton painike) {

        this.takaisinValikkoonPainike = painike;
        this.valikko = valikko;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == takaisinValikkoonPainike) {
            valikko.vaihdaValikko(Valikko.ALOITUS);

        }

    }
}
