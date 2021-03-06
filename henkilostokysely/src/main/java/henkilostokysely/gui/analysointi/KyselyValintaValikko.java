/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kyselysailio;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * @see Valikko
 * @author Miska
 */
public class KyselyValintaValikko extends JPanel {
    
    private final Kayttoliittyma kayttis;
    private final String[] kyselyt;

    public KyselyValintaValikko(Kayttoliittyma kayttis) {
        super(new GridLayout(3,3,10,10));
        this.kayttis=kayttis;
        this.kyselyt=new String[10];
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel tyhja = new JLabel("");
        JLabel valintaKehotus = new JLabel("Valitse kysely:");
        JLabel syotePalaute = new JLabel("");

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

        KyselyValintaKuuntelija kuuntelija = new KyselyValintaKuuntelija(
                this, nimiLista, syotePalaute, valintaPainike);

        valintaPainike.addActionListener(kuuntelija);

        add(tyhja);
        add(valintaKehotus);
        add(syotePalaute);
        add(listanScrollaaja);
        add(tyhja3);
        add(valintaPainike);
        add(tyhja4);
    }
    
    /**
     * Metodi sueraavan valikon kuuntelijan ilmoittaman indeksin perusteella,
     * ja lisää sen käyttöliittymään
     * @param vaihettava
     * @param kyselyIndeksi 
     */
    
        public void vaihdaValikko(Valikko vaihettava, int kyselyIndeksi) {
        Kysely valittuKysely = (Kysely) kayttis.getSailio().getKyselyt().get(kyselyt[kyselyIndeksi]);
        KysymysValintaValikko kysymysValikko = new KysymysValintaValikko(kayttis, valittuKysely);
        kayttis.lisaaValikko(Valikko.ANALYSOINTIKYSYMYS, kysymysValikko);
        kayttis.vaihdaValikko(vaihettava);
    }
        
        
        public Kyselysailio getSailio(){
            return kayttis.getSailio();
        }
    
}
