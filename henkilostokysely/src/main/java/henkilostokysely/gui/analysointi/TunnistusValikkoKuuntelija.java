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

    private final TunnistusValikko valikko;
    private final JTextField nimiKentta;
    private final JPasswordField tunnuslukuKentta;
    private final JButton tallennuspainike;

    public TunnistusValikkoKuuntelija(TunnistusValikko valikko, JTextField nimiKentta,
            JPasswordField tunnuslukuKentta, JButton tallennuspainike) {
        this.valikko = valikko;
        this.nimiKentta = nimiKentta;
        this.tunnuslukuKentta = tunnuslukuKentta;
        this.tallennuspainike = tallennuspainike;
    }
    
    /**
     * Metodi tallentaa analysoijan syöttämät tiedot, mutta ei toistaiseksi
     * tee niillä mitään. Tähän voidaan myöhemmin kehittää jokin huikea
     * ja kryptattu tunnistustoiminto.
     * @param e 
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tallennuspainike) {
            String henkilonNimi = nimiKentta.getText();
            char[] tunnusluku = new char[10];
            tunnusluku = tunnuslukuKentta.getPassword();
            nimiKentta.setText("");
            tunnuslukuKentta.setText("");
            
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSELY);
        }
    }
    
}
