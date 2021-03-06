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
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 *
 */
public class TietoValikkoKuuntelija implements ActionListener {

    private final TietoValikko valikko;
    private final JTextField nimiKentta;
    private final JTextField henkilostonumeroKentta;
    private final JLabel syotePalaute;
    private final JButton tallennuspainike;

    public TietoValikkoKuuntelija(TietoValikko valikko, JTextField nimiKentta,
            JTextField henkilostonumeroKentta, JLabel syotePalaute, JButton tallennuspainike) {
        this.valikko = valikko;
        this.nimiKentta = nimiKentta;
        this.henkilostonumeroKentta = henkilostonumeroKentta;
        this.syotePalaute = syotePalaute;
        this.tallennuspainike = tallennuspainike;
    }
    
    /**
     * Tarkistaa käyttäjän syötteen ja luo annettujen tietojen perusteella
     * Vastaaja-olion
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tallennuspainike) {
            if (nimiKentta.getText().matches(".*\\d.*")
                    || nimiKentta.getText().isEmpty()) {
                syotePalaute.setText("Syötä nimesi, ei numeroita!");
                return;
            }

            if (!henkilostonumeroKentta.getText().matches("[0-9]+")
                    || henkilostonumeroKentta.getText().isEmpty()) {
                syotePalaute.setText("Syötä numero, ei kirjaimia!");
                return;
            }
            String henkilonNimi = nimiKentta.getText();
            int henkilonNumero = Integer.parseInt(
                    henkilostonumeroKentta.getText());

            nimiKentta.setText("");
            henkilostonumeroKentta.setText("");
            Vastaaja vastaaja = new Vastaaja(henkilonNumero, henkilonNimi);
            valikko.vaihdaValikko(Valikko.VASTAAJAVALINTA, vastaaja);
        }
    }
}
