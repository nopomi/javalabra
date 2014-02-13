/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kyselysailio;
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
    private Kyselysailio sailio;
    
    public NimiValikkoKuuntelija(NimiValikko valikko, JTextField tekstikentta, 
            JButton tallennuspainike, Kyselysailio sailio){
        this.tallennuspainike=tallennuspainike;
        this.tekstikentta=tekstikentta;
        this.valikko=valikko;
        this.sailio=sailio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String kyselynNimi = this.tekstikentta.getText();
        Kysely uusiKysely = sailio.luoKysely(kyselynNimi);
        
    }
    
}
