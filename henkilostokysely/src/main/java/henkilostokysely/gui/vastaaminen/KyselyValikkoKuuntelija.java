/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Miska
 */
public class KyselyValikkoKuuntelija implements ActionListener{
    
    private KyselyValikko valikko;
    private JButton painike;
    
    public KyselyValikkoKuuntelija(KyselyValikko valikko, JButton painike){
        
        this.valikko=valikko;
        this.painike=painike;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==painike){
            valikko.talletaVastaukset();
            valikko.vaihdaValikko(Valikko.VASTAAJAKIITOS);
        }
        
    }
    
}
