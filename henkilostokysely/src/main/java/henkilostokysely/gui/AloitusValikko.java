/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mnoponen@cs
 */
public class AloitusValikko extends JPanel {

    private JLabel label;
    private JButton vastauspainike;
    private JButton analysointipainike;
    private JButton luontipainike;
    private Kayttoliittyma kayttoliittyma;

    public AloitusValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(2, 3));
        luoKomponentit();
        this.kayttoliittyma=kayttis;
    }

    private void luoKomponentit() {

        label = new JLabel("Valitse toiminto:");
        vastauspainike = new JButton("Vastaa");
        analysointipainike = new JButton("Analysoi");
        luontipainike = new JButton("Luo");
        AloitusvalikkoKuuntelija kuuntelija = new AloitusvalikkoKuuntelija(
                this, vastauspainike, analysointipainike, luontipainike);

        vastauspainike.addActionListener(kuuntelija);
        analysointipainike.addActionListener(kuuntelija);
        luontipainike.addActionListener(kuuntelija);

        add(Box.createRigidArea(new Dimension(50, 0)));
        add(label);
        add(Box.createRigidArea(new Dimension(50, 0)));
        add(vastauspainike);
        add(analysointipainike);
        add(luontipainike);
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        this.kayttoliittyma.vaihdaValikko(vaihdettava);
    }

}
