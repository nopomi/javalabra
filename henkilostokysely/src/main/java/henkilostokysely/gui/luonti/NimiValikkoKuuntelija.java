/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Miska
 */
public class NimiValikkoKuuntelija implements ActionListener{
    
    private NimiValikko valikko;
    private JButton tallennuspainike;
    private JTextField tekstikentta;
    
    public NimiValikkoKuuntelija(NimiValikko valikko, JTextField tekstikentta, JButton tallennuspainike){
        this.tallennuspainike=tallennuspainike;
        this.tekstikentta=tekstikentta;
        this.valikko=valikko;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String kyselynNimi = this.tekstikentta.getText();
        //tähän tulee uuden kyselyn luonti
        valikko.vaihdaValikko(Valikko.LUONTIKYSYMYKSET);
        
        
        
    }
    
}
