package henkilostokysely.gui.luonti;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.*;
import javax.swing.*;

/**
 * Valikko-luokka jossa luodaan uuden kyselyn kysymykset
 *
 * @author Miska
 */
public class KysymysValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private Kysely kysely;

    /**
     *
     * @param kayttis
     */
    public KysymysValikko(Kayttoliittyma kayttis, Kysely kysely) {
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis = kayttis;
        this.kysely = kysely;
        luoKomponentit();
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    private void luoKomponentit() {

        JLabel otsikko = new JLabel("Syötä kysymys:");
        JLabel tyhja = new JLabel("");
        JLabel lisaysTieto = new JLabel();
        JTextField kysymyskentta = new JTextField();
        String[] vastaustyypit = {"Avoin", "Likert", "1-5", "Kolmikenttä"};
        JComboBox vastaustyyppi = new JComboBox(vastaustyypit);
        JLabel tyhja2 = new JLabel("");
        JButton seuraavaPainike = new JButton("Lisää");
        JButton tallennuspainike = new JButton("Valmis");
        JLabel tyhja3 = new JLabel("");

        KysymysValikkoKuuntelija kuuntelija = new KysymysValikkoKuuntelija(
                this, kysymyskentta, vastaustyyppi,
                seuraavaPainike, tallennuspainike, lisaysTieto);

        kysymyskentta.addActionListener(kuuntelija);
        vastaustyyppi.addActionListener(kuuntelija);
        seuraavaPainike.addActionListener(kuuntelija);
        tallennuspainike.addActionListener(kuuntelija);
        

        add(otsikko);
        add(tyhja);
        add(lisaysTieto);
        add(kysymyskentta);
        add(vastaustyyppi);
        add(tyhja2);
        add(tallennuspainike);
        add(tyhja3);
        add(seuraavaPainike);

    }

    public void lisaaKysymys(String kysymys, Vastaustyyppi tyyppi) {
        this.kysely.lisaaKysymys(kysymys, tyyppi);
    }

    public void vaihdaValikko(Valikko vaihdettava) {
        kayttis.vaihdaValikko(vaihdettava);

    }

    public int annaKyselynKoko() {
        return this.kysely.getKoko();
    }

}
