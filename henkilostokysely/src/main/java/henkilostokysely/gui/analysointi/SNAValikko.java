/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import henkilostokysely.sna.Kaavio;
import henkilostokysely.sna.Linkki;
import henkilostokysely.sna.Noodi;
import henkilostokysely.sna.SNATiedostonPurkaja;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @see Valikko
 * @author Miska
 */
public class SNAValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private Kysymys kysymys;

    SNAValikko(Kayttoliittyma kayttis, Kysymys valittuKysymys) {
        super(new FlowLayout(FlowLayout.LEADING));
        this.kayttis = kayttis;
        this.kysymys = valittuKysymys;
        luoKomponentit();

    }

    private void luoKomponentit() {
        
        JLabel kysymysLabel = new JLabel(kysymys.getKysymys());
        
       
        SNATiedostonPurkaja purkaja = new SNATiedostonPurkaja();
        Kaavio kaavio = purkaja.puraVastauksetKaavioksi(kysymys.getIndeksi() + "_vastaukset.csv");
        DirectedSparseMultigraph<Noodi, Linkki> graph =
                (DirectedSparseMultigraph<Noodi, Linkki>) kaavio.getKaavio();

        VisualizationImageServer kaavioKuva =
                new VisualizationImageServer(
                new ISOMLayout(graph), new Dimension(400, 400));
        
        JButton takaisinPainike = new JButton("Takaisin");
        
        
        SNAValikkoKuuntelija kuuntelija = new SNAValikkoKuuntelija(this, takaisinPainike);
        takaisinPainike.addActionListener(kuuntelija);
        
        add(kysymysLabel);
        add(kaavioKuva);
        add(takaisinPainike);


    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        kayttis.poistaValikko(Valikko.ANALYSOINTISNA);
        kayttis.vaihdaValikko(vaihdettava);
    }
}
