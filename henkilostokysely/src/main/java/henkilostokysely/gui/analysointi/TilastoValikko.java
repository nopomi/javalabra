/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.domain.Kysymys;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import henkilostokysely.vastausanalyysi.NumeerinenAineisto;
import henkilostokysely.vastausanalyysi.NumeeristenVastaustenPurkaja;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @see Valikko
 * @author Miska
 */
public class TilastoValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private Kysymys valittuKysymys;

    public TilastoValikko(Kayttoliittyma kayttis, Kysymys valittuKysymys) {
        super();
        this.kayttis = kayttis;
        this.valittuKysymys = valittuKysymys;
        luoKomponentit();
    }

    
    private void luoKomponentit() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        NumeeristenVastaustenPurkaja purkaja = new NumeeristenVastaustenPurkaja();
        ArrayList<Integer> data = purkaja.puraVastauksetAineistoksi(
                valittuKysymys.getKysely().getNimi()+"_"
                        +valittuKysymys.getIndeksi() + "_vastaukset.csv");
        NumeerinenAineisto aineisto = new NumeerinenAineisto(data);
        
        JLabel kysymys = new JLabel(valittuKysymys.getKysymys());

        String[] sarakkeidenNimet = {"Keskiarvo", "Keskihajonta", "Varianssi"};
        Double[][] nayttoData = new Double[1][3];
        nayttoData[0][0] = aineisto.laskeKeskiarvo();
        nayttoData[0][1] = aineisto.laskeKeskihajonta();
        nayttoData[0][2] = aineisto.laskeVarianssi();
        
        JTable taulukko = new JTable(nayttoData, sarakkeidenNimet);
        
        JButton takaisinPainike = new JButton("Takaisin");
        
        TilastoValikkoKuuntelija kuuntelija = new TilastoValikkoKuuntelija(
                this, takaisinPainike);
        takaisinPainike.addActionListener(kuuntelija);
        JScrollPane taulukkoSailio = new JScrollPane(taulukko);
        
        add(kysymys);
        add(taulukkoSailio);
        add(takaisinPainike);


    }

    public void vaihdaValikko(Valikko valikko) {
        kayttis.poistaValikko(Valikko.ANALYSOINTITILASTO);
        kayttis.vaihdaValikko(valikko);
    }
}
