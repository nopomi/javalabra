/*
 * 
 * 
 */
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Miska
 */
public class ValintaValikkoKuuntelija implements ActionListener {

    private ValintaValikko valikko;
    private JList kyselyValikko;
    private JButton valintaPainike;
    private JLabel syotePalaute;

    public ValintaValikkoKuuntelija(ValintaValikko valikko, JList lista,
            JButton valintaPainike, JLabel syotePalaute) {
        this.valikko = valikko;
        this.kyselyValikko = lista;
        this.valintaPainike = valintaPainike;
        this.syotePalaute = syotePalaute;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valintaPainike) {
            if (!kyselyValikko.isSelectionEmpty()
                    && kyselyValikko.getSelectedIndex() < valikko.getKyselySailio().getKyselyt().size()) {
                int valintaIndeksi;
                valintaIndeksi = kyselyValikko.getSelectedIndex();
                valikko.vaihdaValikko(Valikko.VASTAAJAKYSELY, valintaIndeksi);
            } else {
                syotePalaute.setText("Valitse ensin kysely!");
                return;
            }
        }
    }
}
