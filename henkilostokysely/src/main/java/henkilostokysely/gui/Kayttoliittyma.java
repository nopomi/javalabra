package henkilostokysely.gui;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
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
    private HashMap<String, JPanel> valikot;
    private JPanel aktiivinen;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("KIFinder");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoAloitusvalikko(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoAloitusvalikko(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(Box.createRigidArea(new Dimension(0, 100)));
        container.add(new AloitusValikko(this));
        container.add(Box.createRigidArea(new Dimension(0, 100)));

    }
    
    
    public void luoVastausvalikko(Container container){
    }
    
    public void luoAnalysointivalikko(Container container){
        
    }
    
    public void luoLuontivalikko(Container container){
        
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
