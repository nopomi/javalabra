

package henkilostokysely.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mnoponen@cs
 */
public class AloitusvalikkoKuuntelija implements ActionListener{
    
    private AloitusValikko valikko;
    private JButton vastaa;
    private JButton analysoi;
    private JButton luo;
    
    public AloitusvalikkoKuuntelija(AloitusValikko aloitusvalikko, JButton vastaa, JButton analysoi,
            JButton luo){
        this.vastaa=vastaa;
        this.analysoi=analysoi;
        this.luo=luo;
        this.valikko=aloitusvalikko;
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==vastaa){
            
        } else if(e.getSource()==analysoi){

        } else if(e.getSource()==luo){
            
        } else {
        }
    }
    
    
}
