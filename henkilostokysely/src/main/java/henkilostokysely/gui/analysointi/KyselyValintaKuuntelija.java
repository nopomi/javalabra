/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.gui.Valikko;
import henkilostokysely.gui.vastaaminen.ValintaValikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;

/**
 *
 * @author Miska
 */
public class KyselyValintaKuuntelija implements ActionListener {

    private KyselyValintaValikko valikko;
    private JList kyselyValikko;
    private JButton valintaPainike;
    private String[] nimet;

    public KyselyValintaKuuntelija(KyselyValintaValikko valikko, JList lista,
            JButton valintaPainike, String[] nimet) {
        this.valikko = valikko;
        this.kyselyValikko = lista;
        this.valintaPainike = valintaPainike;
        this.nimet = nimet;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valintaPainike) {
            int valintaIndeksi;
            valintaIndeksi = kyselyValikko.getSelectedIndex();
            if (valintaIndeksi == -1) {
                return;
            }

            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSYMYS, valintaIndeksi);
        }
    }
}
