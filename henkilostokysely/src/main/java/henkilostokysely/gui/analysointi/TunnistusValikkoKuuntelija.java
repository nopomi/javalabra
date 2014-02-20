/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Miska
 */
public class TunnistusValikkoKuuntelija implements ActionListener{

    private TunnistusValikko valikko;
    private JTextField nimiKentta;
    private JPasswordField tunnuslukuKentta;
    private JButton tallennuspainike;

    public TunnistusValikkoKuuntelija(TunnistusValikko valikko, JTextField nimiKentta,
            JPasswordField tunnuslukuKentta, JButton tallennuspainike) {
        this.valikko = valikko;
        this.nimiKentta = nimiKentta;
        this.tunnuslukuKentta = tunnuslukuKentta;
        this.tallennuspainike = tallennuspainike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tallennuspainike) {
            String henkilonNimi = nimiKentta.getText();
            char[] tunnusluku = new char[10];
            tunnusluku = tunnuslukuKentta.getPassword();
            
            //tähän tulee joku huikea tunnusluvuntunnistustoiminto jos jää
            //aikaa sen tekemiseen
            
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSELY);

        }
    }
    
}
