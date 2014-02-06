package henkilostokysely.gui;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import henkilostokysely.gui.analysointi.*;
import henkilostokysely.gui.luonti.NimiValikko;
import java.awt.Container;
import java.awt.Dimension;
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
    }

    @Override
    public void run() {
        frame = new JFrame("KIFinder");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoValikot(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoValikot(Container container){
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        Aloitusvalikko aloitusvalikko = new Aloitusvalikko(this);
        NimiValikko luonti1 = new NimiValikko(this);
        
        //tähän tulee kaikkien valikkojen luominen
        
        valikot.put(Valikko.ALOITUS, aloitusvalikko);
        valikot.put(Valikko.LUONTINIMI, luonti1);
        
        
        
        aloitusvalikko.setVisible(false);
        
        //tähän tulee kaikkien valikkojen lisäys valikot-mappiin
        
        
        container.add(aloitusvalikko);
        container.add(luonti1);
        //tähän tulee kaikkien valikkojen lisääminen käyttöliittymään
        
    }

    public void luoAloitusvalikko(Container container) {
        
        container.add(new Aloitusvalikko(this));
        
    }
    


    
    public void setAktiivinen(JPanel valikko){
        this.aktiivinen=valikko;
    }
    
    void vaihdaValikko(Valikko vaihdettava) {
        this.aktiivinen.setVisible(false);
        
        
    }
    
    public JFrame getFrame() {
        return frame;
    }



}
