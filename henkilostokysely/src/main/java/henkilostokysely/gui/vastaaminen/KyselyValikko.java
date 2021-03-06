package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.domain.Vastaaja;
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

    private final Kayttoliittyma kayttis;
    private final Kysely kysely;
    private final HashMap kysymykset;
    private final Vastaaja vastaaja;
    private final VastausKentta[] kysymysKomponentit;
    private JLabel syotePalaute;

    public KyselyValikko(Kayttoliittyma kayttis, Vastaaja vastaaja, Kysely kysely) {
        super(new GridLayout(kysely.getKoko() + 2, 2, 10, 10));
        this.kayttis = kayttis;
        this.vastaaja = vastaaja;
        this.kysely = kysely;
        this.kysymykset = kysely.getKysymykset();
        this.kysymysKomponentit = new VastausKentta[20];
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel vastausKehotus = new JLabel("Vastaa:");
        syotePalaute = new JLabel("");
        
        add(vastausKehotus);
        add(syotePalaute);

        int i = 0;

        for (Object k : kysymykset.values()) {
            Kysymys kysymys = (Kysymys) k;
            

            if (kysymys.getTyyppi() == Vastaustyyppi.ASTEIKKO) {
                AsteikkoVastausKentta asteikkoKentta = new AsteikkoVastausKentta(kysymys);
                kysymysKomponentit[i] = asteikkoKentta;
                add(asteikkoKentta);
            } else if (kysymys.getTyyppi() == Vastaustyyppi.AVOIN) {
                AvoinVastausKentta avoinKentta = new AvoinVastausKentta(kysymys);
                kysymysKomponentit[i] = avoinKentta;
                add(avoinKentta);
            } else if (kysymys.getTyyppi() == Vastaustyyppi.KOLMIKENTTA) {
                KolmiKentta kolmiKentta = new KolmiKentta(kysymys);
                kysymysKomponentit[i] = kolmiKentta;
                add(kolmiKentta);
            } else if (kysymys.getTyyppi() == Vastaustyyppi.LIKERT) {
                LikertVastausKentta likertKentta = new LikertVastausKentta(kysymys);
                kysymysKomponentit[i] = likertKentta;
                add(likertKentta);
            }
            i++;
        }

        JButton painike = new JButton("Tallenna");

        KyselyValikkoKuuntelija kuuntelija = new KyselyValikkoKuuntelija(this,
                painike);
        painike.addActionListener(kuuntelija);
        add(painike);

    }

    public void talletaVastaukset() {
        int i = 0;
        if(!tarkistaSyotteet()){
            syotePalaute.setText("Vastaa oikealla tavalla!");
            return;
        }
        for (Object o : kysymykset.values()) {
            Kysymys kysymys = (Kysymys) o;
            kysymys.lisaaVastaus(vastaaja.getNumero(), kysymysKomponentit[i].getVastaus());
            i++;
        }
        kayttis.vaihdaValikko(Valikko.VASTAAJAKIITOS);
    }
    
    /**
     * Metodi tarkistaa syötteet siten, että yksittäiset kentät palauttavat
     * null jos niissä on jotain pielessä. Palauttaa false jos jokin on 
     * väärin täytetty.
     * @return 
     */
    
    private boolean tarkistaSyotteet(){
        for (int i = 0; i < kysymykset.values().size(); i++) {
            if(kysymysKomponentit[i].getVastaus()==null){
                return false;
            }
        }
        return true;
    }
}
