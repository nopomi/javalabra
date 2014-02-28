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
public class LikertValikko extends JPanel{
    private final Kayttoliittyma kayttis;
    private final Kysymys valittuKysymys;

    public LikertValikko(Kayttoliittyma kayttis, Kysymys valittuKysymys) {
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

        String[] sarakkeidenNimet = {"Samaa mieltä", "Osittain samaa mieltä", 
            "Ei samaa eikä eri mieltä", "Osittain eri mieltä", "Eri mieltä"};
        String[][] nayttoData = new String[1][5];
        int[] jakaumat = aineisto.likertJakauma();
        nayttoData[0][0] = jakaumat[0]+"%";
        nayttoData[0][1] = jakaumat[1]+"%";
        nayttoData[0][2] = jakaumat[2]+"%";
        nayttoData[0][3] = jakaumat[3]+"%";
        nayttoData[0][4] = jakaumat[4]+"%";
        
        
        JTable taulukko = new JTable(nayttoData, sarakkeidenNimet);
        
        JButton takaisinPainike = new JButton("Takaisin");
        
        LikertValikkoKuuntelija kuuntelija = new LikertValikkoKuuntelija(
                this, takaisinPainike);
        takaisinPainike.addActionListener(kuuntelija);
        JScrollPane taulukkoSailio = new JScrollPane(taulukko);
        
        add(kysymys);
        add(taulukkoSailio);
        add(takaisinPainike);


    }

    public void vaihdaValikko(Valikko valikko) {
        kayttis.poistaValikko(Valikko.ANALYSOINTILIKERT);
        kayttis.vaihdaValikko(valikko);
    }
    
}
