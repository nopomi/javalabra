/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Vastaustyyppi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mnoponen@cs
 */
public class KysymysValikkoKuuntelija implements ActionListener {

    private KysymysValikko valikko;
    private JTextField kysymys;
    private JComboBox vastaustyyppi;
    private JButton valmis;
    private JButton lisaa;

    public KysymysValikkoKuuntelija(KysymysValikko valikko,
            JTextField tekstikentta, JComboBox vastaustyyppi,
            JButton valmisPainike, JButton lisayspainike) {
        this.valikko = valikko;
        this.kysymys = tekstikentta;
        this.vastaustyyppi = vastaustyyppi;
        this.valmis = valmisPainike;
        this.lisaa = lisayspainike;

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
            //tähän kysymyksen tallennus ja siirtyminen lopetusvalikkoon.
            if(!kysymysTekstina.isEmpty()){
                valikko.lisaaKysymys(kysymysTekstina, tyyppi);
            }
            valikko.tallennaKysely();

        }
        if (e.getSource() == lisaa) {
            valikko.lisaaKysymys(kysymysTekstina, tyyppi);
          


        }
    }
    }

