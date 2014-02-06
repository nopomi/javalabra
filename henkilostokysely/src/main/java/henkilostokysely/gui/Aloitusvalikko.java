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
public class Aloitusvalikko extends JPanel {

    private Kayttoliittyma kayttoliittyma;

    public Aloitusvalikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3));
        luoKomponentit();
        this.kayttoliittyma=kayttis;
    }

    private void luoKomponentit() {

        JLabel label = new JLabel("Valitse toiminto:");
        JButton vastauspainike = new JButton("Vastaa");
        JButton analysointipainike = new JButton("Analysoi");
        JButton luontipainike = new JButton("Luo");
        AloitusvalikkoKuuntelija kuuntelija = new AloitusvalikkoKuuntelija(
                this, vastauspainike, analysointipainike, luontipainike);

        vastauspainike.addActionListener(kuuntelija);
        analysointipainike.addActionListener(kuuntelija);
        luontipainike.addActionListener(kuuntelija);
        
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(label);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(vastauspainike);
        add(analysointipainike);
        add(luontipainike);
        add(Box.createRigidArea(new Dimension(0,100)));
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        this.kayttoliittyma.vaihdaValikko(vaihdettava);
    }

}
