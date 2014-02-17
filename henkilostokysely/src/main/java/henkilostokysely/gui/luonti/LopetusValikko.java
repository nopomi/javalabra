/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.luonti;

import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Valikko-luokka jossa vahvistetaan kyselyn luominen
 * @author Miska
 */
public class LopetusValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    
    public LopetusValikko(Kayttoliittyma kayttis){
        super(new GridLayout(3,3,10,10));
        this.kayttis=kayttis;
        luoKomponentit();
        
        
    }
    
    private void luoKomponentit(){
        
        JLabel tyhja = new JLabel("");
        JLabel kiitosTeksti = new JLabel("Kiitos! \n Kysely on nyt luotu ja "
                + "tallennettu järjestelmään. Palaa päävalikkoon jos haluat jatkaa:");
        JLabel tyhja2 = new JLabel();
        JLabel tyhja3 = new JLabel();
        JButton palaaValikkoon = new JButton("Palaa päävalikkoon");
        JLabel tyhja4 = new JLabel();
        
        LopetusValikkoKuuntelija kuuntelija = new LopetusValikkoKuuntelija(this,
        palaaValikkoon);
        
        palaaValikkoon.addActionListener(kuuntelija);
        
        add(tyhja);
        add(kiitosTeksti);
        add(tyhja2);
        add(tyhja3);
        add(palaaValikkoon);
        add(tyhja4);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        
        
        
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        
        kayttis.vaihdaValikko(vaihdettava);
        
    }
    
}
