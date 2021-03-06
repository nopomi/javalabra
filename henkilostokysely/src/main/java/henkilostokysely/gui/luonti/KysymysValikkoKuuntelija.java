/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mnoponen@cs
 */
public class KysymysValikkoKuuntelija implements ActionListener {

    private final KysymysValikko valikko;
    private final JTextField kysymys;
    private final JComboBox vastaustyyppi;
    private final JButton valmis;
    private final JButton lisaa;
    private final JLabel lisaystieto;

    public KysymysValikkoKuuntelija(KysymysValikko valikko,
            JTextField tekstikentta, JComboBox vastaustyyppi,
            JButton lisayspainike, JButton valmisPainike,
            JLabel lisaysTeksti) {
        this.valikko = valikko;
        this.kysymys = tekstikentta;
        this.vastaustyyppi = vastaustyyppi;
        this.valmis = valmisPainike;
        this.lisaa = lisayspainike;
        this.lisaystieto = lisaysTeksti;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Vastaustyyppi tyyppi = null;
        String kysymysTekstina = kysymys.getText();

        int tyyppiIndeksi = vastaustyyppi.getSelectedIndex();

        if (tyyppiIndeksi == 0) {
            tyyppi = Vastaustyyppi.AVOIN;
        } else if (tyyppiIndeksi == 1) {
            tyyppi = Vastaustyyppi.LIKERT;
        } else if (tyyppiIndeksi == 2) {
            tyyppi = Vastaustyyppi.ASTEIKKO;
        } else if (tyyppiIndeksi == 3) {
            tyyppi = Vastaustyyppi.KOLMIKENTTA;
        }

        if (e.getSource() == valmis) {

            if (!kysymysTekstina.isEmpty()) {
                valikko.lisaaKysymys(kysymysTekstina, tyyppi);
            }
            
            if(valikko.annaKyselynKoko()==0){
                lisaystieto.setText("Lisää ensin kysymys!");
                return;
            }
            valikko.vaihdaValikko(Valikko.LUONTILOPETUS);

        }
        if (e.getSource() == lisaa) {
            if (kysymysTekstina.isEmpty()) {
                lisaystieto.setText("Täytä kysymys!");
                return;
            }
            valikko.lisaaKysymys(kysymysTekstina, tyyppi);
            lisaystieto.setText("Lisätty! Kysymyksiä: " + valikko.annaKyselynKoko());
            kysymys.setText("");
        }
    }
}
