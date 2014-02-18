package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Vastaaja;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * Valikko-luokka jossa valitaan kysely johon vastataan, näkymässä listataan
 * kaikki kyselyt joita säiliöstä löytyy
 *
 * @author Miska
 * @see KyselyValikko
 */
public class ValintaValikko extends JPanel {

    private Kayttoliittyma kayttis;
    private String[] kyselyt;
    private Vastaaja vastaaja;

    public ValintaValikko(Kayttoliittyma kayttis, Vastaaja vastaaja) {
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis = kayttis;
        this.vastaaja = vastaaja;
        this.kyselyt = new String[10];
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel tyhja = new JLabel("");
        JLabel valintaKehotus = new JLabel("Valitse kysely:");
        JLabel tyhja2 = new JLabel("");

        int i = 0;
        for (Object o : kayttis.getSailio().getKyselyt().keySet()) {
            String nimi = (String) o;
            kyselyt[i] = nimi;
            i++;
        }

        JList nimiLista = new JList(kyselyt);
        nimiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nimiLista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        nimiLista.setVisibleRowCount(-1);
        JScrollPane listanScrollaaja = new JScrollPane(nimiLista);
        listanScrollaaja.setPreferredSize(new Dimension(250, 80));

        JLabel tyhja3 = new JLabel("");
        JButton valintaPainike = new JButton("Valitse");
        JLabel tyhja4 = new JLabel("");

        ValintaValikkoKuuntelija kuuntelija = new ValintaValikkoKuuntelija(
                this, nimiLista, valintaPainike, kyselyt);

        valintaPainike.addActionListener(kuuntelija);


        add(tyhja);
        add(valintaKehotus);
        add(tyhja2);
        add(listanScrollaaja);
        add(tyhja3);
        add(valintaPainike);
        add(tyhja4);


    }

    public void vaihdaValikko(Valikko vaihdettava) {
        kayttis.vaihdaValikko(vaihdettava);
    }

    public void vaihdaValikko(Valikko vaihettava, int kyselyIndeksi) {
        Kysely valittuKysely = (Kysely) kayttis.getSailio().getKyselyt().get(kyselyt[kyselyIndeksi]);
        KyselyValikko kyselyValikko = new KyselyValikko(kayttis, vastaaja, valittuKysely);
        kayttis.lisaaValikko(Valikko.VASTAAJAKYSELY, kyselyValikko);
        kayttis.vaihdaValikko(vaihettava);
    }

    public Kysely getKysely(String avain) {
        return kayttis.getSailio().getKysely(avain);
    }
}
