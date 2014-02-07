package henkilostokysely.gui;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import henkilostokysely.gui.analysointi.*;
import henkilostokysely.gui.luonti.NimiValikko;
import henkilostokysely.gui.Valikko;
import java.awt.Container;
import java.awt.Dimension;
import java.util.EnumMap;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author Miska
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private HashMap<Valikko, JPanel> valikot;
    private JPanel aktiivinen;

    public Kayttoliittyma() {
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

    public void luoValikot(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.setPreferredSize(new Dimension(700, 700));
        Aloitusvalikko aloitusvalikko = new Aloitusvalikko(this);
        NimiValikko luontinimi = new NimiValikko(this);
        //tähän tulee kaikkien valikkojen luominen

        valikot.put(Valikko.ALOITUS, aloitusvalikko);
        valikot.put(Valikko.LUONTINIMI, luontinimi);


        aloitusvalikko.setVisible(true);
        luontinimi.setVisible(false);
        
        
        setAktiivinen(aloitusvalikko);


        container.add(aloitusvalikko);
        container.add(luontinimi);
        //tähän tulee kaikkien valikkojen lisääminen käyttöliittymään

    }

    public void setAktiivinen(JPanel valikko) {
        this.aktiivinen = valikko;
    }

    public void vaihdaValikko(Valikko vaihdettava) {
        this.aktiivinen.setVisible(false);
        JPanel vaihdettavaPanel = valikot.get(vaihdettava);
        vaihdettavaPanel.setVisible(true);
        setAktiivinen(vaihdettavaPanel);

    }

    public JFrame getFrame() {
        return frame;
    }
}
