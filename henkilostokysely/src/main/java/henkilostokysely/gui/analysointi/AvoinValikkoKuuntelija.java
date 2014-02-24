/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Miska
 */
public class AvoinValikkoKuuntelija implements ActionListener{
    
    private AvoinValikko valikko;
    private JButton takaisinPainike;

    public AvoinValikkoKuuntelija(AvoinValikko valikko, JButton takaisinPainike) {
        this.valikko=valikko;
        this.takaisinPainike=takaisinPainike;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.takaisinPainike){
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSYMYS);
        }
    }
    
    
    
    
}
