/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;

/**
 *
 * @author Miska
 */
public class KysymysValintaKuuntelija implements ActionListener {

    private KysymysValintaValikko valikko;
    private JList kyselyValikko;
    private JButton valintaPainike;
    private String[] kysymystekstit;

    public KysymysValintaKuuntelija(KysymysValintaValikko valikko, JList lista,
            JButton valintaPainike) {
        this.valikko = valikko;
        this.kyselyValikko = lista;
        this.valintaPainike = valintaPainike;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valintaPainike) {
            int valintaIndeksi;
            valintaIndeksi = kyselyValikko.getSelectedIndex();
            if (valintaIndeksi == -1) {
                return;
            }

            valikko.vaihdaValikko(valintaIndeksi);
        }
    }
}
