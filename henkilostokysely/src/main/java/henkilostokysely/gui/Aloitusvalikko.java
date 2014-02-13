
package henkilostokysely.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * Ensimmäinen päävalikko jossa valitaan mihin toimintoon siirrytään
 */
public class Aloitusvalikko extends JPanel {

    private Kayttoliittyma kayttoliittyma;

    /**
     *
     * @param kayttis
     */
    public Aloitusvalikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3));
        luoKomponentit();
        this.kayttoliittyma=kayttis;
    }
    

    private void luoKomponentit() {

        JLabel label = new JLabel("                      \nValitse toiminto:");
        JButton vastauspainike = new JButton("Vastaa");
        JButton analysointipainike = new JButton("Analysoi");
        JButton luontipainike = new JButton("Luo");
        AloitusvalikkoKuuntelija kuuntelija = new AloitusvalikkoKuuntelija(
                this, vastauspainike, analysointipainike, luontipainike);

        vastauspainike.addActionListener(kuuntelija);
        analysointipainike.addActionListener(kuuntelija);
        luontipainike.addActionListener(kuuntelija);
        
        add(new JLabel(""));
        add(label);
        add(new JLabel(""));
        add(vastauspainike);
        add(analysointipainike);
        add(luontipainike);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
       
    }
    
    /**
     * Metodi viestii käyttöliittymälle valikon vaihdosta
     * @param vaihdettava on valikko, johon vaihdetaan
     */
    public void vaihdaValikko(Valikko vaihdettava){
        this.kayttoliittyma.vaihdaValikko(vaihdettava);
    }

}
