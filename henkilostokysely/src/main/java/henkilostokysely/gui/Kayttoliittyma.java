
package henkilostokysely.gui;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;


/**
 *
 * @author Miska
 */
public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    
    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("KIFinder");
        frame.setPreferredSize(new Dimension(500, 500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    

    private void luoKomponentit(Container container) {
    
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    
    
    
}
