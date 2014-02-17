
package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.*;
import javax.swing.*;

/**
 * Valikko-luokka jossa luodaan uuden kyselyn kysymykset
 * @author Miska
 */
public class KysymysValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    private Kysely kysely;
    
    /**
     * 
     * @param kayttis
     */
    public KysymysValikko(Kayttoliittyma kayttis, Kysely kysely){
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis=kayttis;
        this.kysely=kysely;
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        JLabel otsikko = new JLabel("Syötä kysymys:");
        JLabel tyhja = new JLabel("");
        JTextField kysymyskentta = new JTextField();
        String[] vastaustyypit = {"Avoin", "Likert", "1-5", "Kolmikenttä"};
        JComboBox vastaustyyppi = new JComboBox(vastaustyypit);
        JButton seuraavaPainike = new JButton("Lisää");
        JButton tallennuspainike = new JButton("Valmis");
        
        //tähän vielä NimiValikkoKuuntelija
        
        
        add(otsikko);
        add(tyhja);
        add(tyhja);
        add(kysymyskentta);
        add(vastaustyyppi);
        add(tyhja);
        add(seuraavaPainike);
        add(tyhja);
        add(tallennuspainike);
        
        this.setVisible(true);
        
    }
    
    public void lisaaKysymys(String kysymys, Vastaustyyppi tyyppi){
        this.kysely.lisaaKysymys(kysymys, tyyppi);
    }
    
    public void tallennaKysely(){
        kayttis.getSailio().lisaaKysely(kysely);
        
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        
    }
    
}
