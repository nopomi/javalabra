
package henkilostokysely.gui.vastaaminen;

import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import henkilostokysely.gui.luonti.LopetusValikkoKuuntelija;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Valikko-luokka, jossa kiitetään vastaajaa
 * @author Miska
 */
public class KiitosValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    
    public KiitosValikko(Kayttoliittyma kayttis){
        super(new GridLayout(3,3));
        this.kayttis=kayttis;
        luoKomponentit();
    }
    
    private void luoKomponentit(){
        JLabel tyhja = new JLabel("");
        JLabel kiitosTeksti = new JLabel("Kiitos vastauksistasi!");
        JLabel tyhja2 = new JLabel();
        JLabel tyhja3 = new JLabel();
        JButton palaaValikkoon = new JButton("Palaa päävalikkoon");
        JLabel tyhja4 = new JLabel();
        
        KiitosValikkoKuuntelija kuuntelija = new KiitosValikkoKuuntelija(this,
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
        this.kayttis.vaihdaValikko(vaihdettava);
    }
}
