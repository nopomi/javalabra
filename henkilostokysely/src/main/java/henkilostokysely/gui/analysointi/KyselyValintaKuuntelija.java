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
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Miska
 */
public class KyselyValintaKuuntelija implements ActionListener {

    private final KyselyValintaValikko valikko;
    private final JList kyselyValikko;
    private final JButton valintaPainike;
    private final JLabel syotePalaute;

    public KyselyValintaKuuntelija(KyselyValintaValikko valikko, JList lista,
            JLabel syotePalaute, JButton valintaPainike) {
        this.valikko = valikko;
        this.kyselyValikko = lista;
        this.syotePalaute = syotePalaute;
        this.valintaPainike = valintaPainike;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valintaPainike) {
            int valintaIndeksi;
            valintaIndeksi = kyselyValikko.getSelectedIndex();
            if (kyselyValikko.isSelectionEmpty() ||
                    valintaIndeksi >= valikko.getSailio().getKyselyt().size()) {
                syotePalaute.setText("Valitse kysely!");
                return;
            }
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSYMYS, valintaIndeksi);
        }
    }
}
