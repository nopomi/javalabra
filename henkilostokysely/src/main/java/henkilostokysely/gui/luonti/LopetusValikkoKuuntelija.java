

package henkilostokysely.gui.luonti;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author mnoponen@cs
 */
public class LopetusValikkoKuuntelija implements ActionListener{
    
    private final LopetusValikko valikko;
    private final JButton takaisinValikkoonPainike;
    
    public LopetusValikkoKuuntelija(LopetusValikko valikko, JButton painike){
        
        this.takaisinValikkoonPainike=painike;
        this.valikko=valikko;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==takaisinValikkoonPainike){
            
            valikko.vaihdaValikko(Valikko.ALOITUS);
            
        }
        
    }
    
}
