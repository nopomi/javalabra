/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Vastaaja;
import henkilostokysely.gui.Valikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author mnoponen@cs
 */
public class TietoValikkoKuuntelija implements ActionListener {

    private TietoValikko valikko;
    private JTextField nimiKentta;
    private JTextField henkilostonumeroKentta;
    private JButton tallennuspainike;

    public TietoValikkoKuuntelija(TietoValikko valikko, JTextField nimiKentta,
            JTextField henkilostonumeroKentta, JButton tallennuspainike) {
        this.valikko = valikko;
        this.nimiKentta = nimiKentta;
        this.henkilostonumeroKentta = henkilostonumeroKentta;
        this.tallennuspainike = tallennuspainike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tallennuspainike) {
            String henkilonNimi = nimiKentta.getText();
            int henkilonNumero;
            henkilonNumero = Integer.parseInt(henkilostonumeroKentta.getText());
            nimiKentta.setText("");
            henkilostonumeroKentta.setText("");
            Vastaaja vastaaja = new Vastaaja(henkilonNumero, henkilonNimi);
            valikko.vaihdaValikko(Valikko.VASTAAJAVALINTA, vastaaja);

        }
    }
}
