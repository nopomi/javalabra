package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Valikko-luokka, jossa vastaaja täyttää vastaukset
 *
 * @author Miska
 */
public class KyselyValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private Kysely kysely;
    private HashMap kysymykset;

    public KyselyValikko(Kayttoliittyma kayttis, Kysely kysely) {
        super(new GridLayout(kysely.getKoko()+3, 2, 10,10));
        this.kayttis = kayttis;
        this.kysely = kysely;
        this.kysymykset=kysely.getKysymykset();
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel vastausKehotus = new JLabel("Vastaa:");
        add(vastausKehotus);
        add(new JLabel(""));

        for (Object k : kysely.getKysymykset().values()) {
            Kysymys kysymys = (Kysymys) k;
            add(new JLabel(kysymys.getKysymys()));
            
            if(kysymys.getTyyppi()==Vastaustyyppi.ASTEIKKO){
                add(new AsteikkoVastausKentta(kysymys));
            } else if(kysymys.getTyyppi()==Vastaustyyppi.AVOIN){
                add(new AvoinVastausKentta(kysymys));
            } else if(kysymys.getTyyppi()==Vastaustyyppi.KOLMIKENTTA){
                add(new KolmiKentta(kysymys));
            } else if (kysymys.getTyyppi()==Vastaustyyppi.LIKERT){
                add(new LikertVastausKentta(kysymys));
            }
        }
        
        
        
        
        JButton painike = new JButton("Tallenna");

        

    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        kayttis.vaihdaValikko(vaihdettava);
    }

}
