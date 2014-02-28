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
public class TilastoValikkoKuuntelija implements ActionListener{
    
    private final TilastoValikko valikko;
    private final JButton painike;

    public TilastoValikkoKuuntelija(TilastoValikko valikko, JButton takaisinPainike) {
        this.valikko=valikko;
        this.painike=takaisinPainike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==painike){
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSYMYS);
        }
        
    }
    
}
