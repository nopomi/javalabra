package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysely;
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

    public ValintaValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3, 3, 10, 10));
        this.kayttis = kayttis;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel tyhja = new JLabel("");
        JLabel valintaKehotus = new JLabel("Valitse kysely:");
        JLabel tyhja2 = new JLabel("");

        int i = 0;
        for (Iterator it = kayttis.getSailio().getKyselyt().keySet().iterator(); it.hasNext();) {
            String nimi = (String)it.next();
            kyselyt[i]=nimi;
            i++;
        }
        
        JList<String> nimiLista = new JList<>(kyselyt);
        nimiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nimiLista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        nimiLista.setVisibleRowCount(-1);
        JScrollPane listanScrollaaja = new JScrollPane(nimiLista);
        listanScrollaaja.setPreferredSize(new Dimension(250,80));
        
        JLabel tyhja3 = new JLabel("");
        JButton valintaPainike = new JButton("Valitse");
        
        ValintaValikkoKuuntelija kuuntelija = new ValintaValikkoKuuntelija(
                this, nimiLista, valintaPainike, kyselyt);
        

        // tästä puuttuu vielä äddit!

    }
    
    
    public void vaihdaValikko(Valikko vaihdettava){
        kayttis.vaihdaValikko(vaihdettava);
    }
    
    public void vaihdaValikko(Valikko vaihettava, int kyselyIndeksi){
        Kysely valittuKysely = (Kysely)kayttis.getSailio().getKyselyt().get(kyselyt[kyselyIndeksi]);
        //lisää tähän tai kyselyvalikon puolelle käyttikseen valikon lisääminen,
        //ja valikon vaihto.
        KyselyValikko kyselyValikko = new KyselyValikko(kayttis, valittuKysely);
    }
}
