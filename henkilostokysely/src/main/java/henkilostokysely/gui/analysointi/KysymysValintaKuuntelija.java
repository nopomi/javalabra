/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

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
public class KysymysValintaKuuntelija implements ActionListener {

    private final KysymysValintaValikko valikko;
    private final JList kyselyValikko;
    private final JButton valintaPainike;
    private final JButton takaisinPainike;
    private final JLabel syotePalaute;

    public KysymysValintaKuuntelija(KysymysValintaValikko valikko, JList lista, 
            JLabel syotePalaute, JButton valintaPainike, JButton takaisinPainike) {
        this.valikko = valikko;
        this.kyselyValikko = lista;
        this.valintaPainike = valintaPainike;
        this.takaisinPainike=takaisinPainike;
        this.syotePalaute=syotePalaute;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valintaPainike) {
            
            if(kyselyValikko.isSelectionEmpty() ||
                   kyselyValikko.getSelectedIndex()>=valikko.getKysymystenMaara()){
                syotePalaute.setText("Valitse kysymys!");
                return;
            }
            int valintaIndeksi;
            valintaIndeksi = kyselyValikko.getSelectedIndex();
            valikko.vaihdaValikko(valintaIndeksi);
            
        } else if(e.getSource()==takaisinPainike){
            valikko.vaihdaValikko(Valikko.ALOITUS);
            syotePalaute.setText("");
        }
    }
}
