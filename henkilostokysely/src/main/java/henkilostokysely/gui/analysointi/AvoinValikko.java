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
import henkilostokysely.vastausanalyysi.SanallistenVastaustenPurkaja;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @see Valikko
 * @author Miska
 */
public class AvoinValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private Kysymys valittuKysymys;

    public AvoinValikko(Kayttoliittyma kayttis, Kysymys valittuKysymys) {
        super(new FlowLayout());
        this.kayttis = kayttis;
        this.valittuKysymys = valittuKysymys;
        luoKomponentit();
    }

    private void luoKomponentit() {

        SanallistenVastaustenPurkaja purkaja = new SanallistenVastaustenPurkaja();
        ArrayList<String> vastaukset =
                purkaja.puraVastauksetAineistoksi(valittuKysymys.getIndeksi() + "_vastaukset.csv");
        
        JLabel kysymysLabel = new JLabel(valittuKysymys.getKysymys());
        
        JTextArea vastausTekstit = new JTextArea(20, 40);
        vastausTekstit.setLineWrap(true);
        vastausTekstit.setWrapStyleWord(true);
        for (String vastaus : vastaukset) {
            vastausTekstit.append(vastaus+"\n");
        }
        
        JScrollPane skrollattavaTeksti = new JScrollPane(vastausTekstit);
        skrollattavaTeksti.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        skrollattavaTeksti.setPreferredSize(new Dimension(250, 250));
        
        JButton takaisinPainike = new JButton("Takaisin");
        
        AvoinValikkoKuuntelija kuuntelija = new AvoinValikkoKuuntelija(this, takaisinPainike);
        takaisinPainike.addActionListener(kuuntelija);

        add(kysymysLabel);
        add(skrollattavaTeksti);
        add(takaisinPainike);

    }

    public void vaihdaValikko(Valikko valikko) {
        kayttis.poistaValikko(Valikko.ANALYSOINTIAVOIN);
        kayttis.vaihdaValikko(valikko);
    }
}
