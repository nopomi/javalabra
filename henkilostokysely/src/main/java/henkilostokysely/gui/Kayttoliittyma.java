package henkilostokysely.gui;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kyselysailio;
import henkilostokysely.gui.analysointi.*;
import henkilostokysely.gui.luonti.NimiValikko;
import henkilostokysely.gui.Valikko;
import henkilostokysely.gui.luonti.LopetusValikko;
import java.awt.Container;
import java.awt.Dimension;
import java.util.EnumMap;
import java.util.HashMap;
import javax.swing.*;

/**
 * Käyttöliittymän pääluokka
 * @author Miska
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private HashMap<Valikko, JPanel> valikot;
    private JPanel aktiivinen;
    private Kyselysailio sailio;

    /**
     * Saa parametrina kyselysäiliön, johon kyselyt talletetaan
     * @param sailio
     * @see Kyselysailio
     */
    public Kayttoliittyma(Kyselysailio sailio) {
        this.sailio = sailio;
        this.valikot = new HashMap<>();
    }

    @Override
    public void run() {
        frame = new JFrame("KIFinder");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoValikot(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo kaikki valikot, jotka tässä vaiheessa voidaan luoda.
     * Jotkut valikot ovat sen verran raskaita ja epätodennäköisesti
     * aktivoidaan - että ne luodaan vasta sitten kun sinne siirrytään.
     * @param container
     */
    public void luoValikot(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.setPreferredSize(new Dimension(700, 700));
        Aloitusvalikko aloitusvalikko = new Aloitusvalikko(this);
        NimiValikko luontinimi = new NimiValikko(this);
        LopetusValikko luontilopetus = new LopetusValikko(this);
        //tähän tulee kaikkien valikkojen luominen

        valikot.put(Valikko.ALOITUS, aloitusvalikko);
        valikot.put(Valikko.LUONTINIMI, luontinimi);
        valikot.put(Valikko.LUONTILOPETUS, luontilopetus);


        aloitusvalikko.setVisible(true);
        luontinimi.setVisible(false);
        luontilopetus.setVisible(false);
        
        
        setAktiivinen(aloitusvalikko);


        container.add(aloitusvalikko);
        container.add(luontinimi);
        container.add(luontilopetus);
        //tähän tulee kaikkien valikkojen lisääminen käyttöliittymään

    }

    /**
     * Vaihtaa aktiivista valikkoa, jonka avulla pidetään 
     * kirjaa mikä on näkyvissä
     * @param valikko valikko joka aktivoidaan
     */
    public void setAktiivinen(JPanel valikko) {
        this.aktiivinen = valikko;
    }

    /**
     * Vaihtaa aktiivista valikkoa, ja asettaa näkyvyydet
     * @param vaihdettava
     */
    public void vaihdaValikko(Valikko vaihdettava) {
        this.aktiivinen.setVisible(false);
        JPanel vaihdettavaPanel = valikot.get(vaihdettava);
        vaihdettavaPanel.setVisible(true);
        setAktiivinen(vaihdettavaPanel);

    }
    
    
    public void lisaaValikko(Valikko valikko, JPanel paneeli){
        valikot.put(valikko, paneeli);
        frame.getContentPane().add(paneeli);
    }

    
    
    /**
     * 
     * @return
     */
    public Kyselysailio getSailio(){
        return this.sailio;
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}
