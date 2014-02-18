package henkilostokysely.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Aloitusvalikon kuuntelijaluokka
 *
 * @author miska
 */
public class AloitusvalikkoKuuntelija implements ActionListener {

    private Aloitusvalikko valikko;
    private JButton vastaa;
    private JButton analysoi;
    private JButton luo;

    /**
     * Painikkeet parametrina ottava konstruktori, myös aloitusvalikko tulee
     * parametrina
     *
     * @param aloitusvalikko Aloitusvalikko johon tämä kuuluu
     * @param vastaa aktivoi vastaustoiminnon
     * @param analysoi aktivoi vastausten analysoinnin
     * @param luo aktivoi kyselyn luomistoiminnon
     */
    public AloitusvalikkoKuuntelija(Aloitusvalikko aloitusvalikko, JButton vastaa,
            JButton analysoi,
            JButton luo) {
        this.vastaa = vastaa;
        this.analysoi = analysoi;
        this.luo = luo;
        this.valikko = aloitusvalikko;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vastaa) {
            valikko.vaihdaValikko(Valikko.VASTAAJATIETO);
        } else if (e.getSource() == analysoi) {
            valikko.vaihdaValikko(Valikko.ANALYSOINTIKYSELY);
        } else if (e.getSource() == luo) {
            valikko.vaihdaValikko(Valikko.LUONTINIMI);
        }
    }
}
