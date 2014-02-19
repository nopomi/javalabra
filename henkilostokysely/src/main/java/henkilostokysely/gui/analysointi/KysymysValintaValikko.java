/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.gui.Kayttoliittyma;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
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
public class KysymysValintaValikko extends JPanel{
    
    private Kayttoliittyma kayttis;
    private HashMap kysymykset;
    private String[] kysymystekstit;

    KysymysValintaValikko(Kayttoliittyma kayttis, Kysely valittuKysely) {
        super(new GridLayout(3,3,10,10));
        this.kayttis=kayttis;
        this.kysymykset=valittuKysely.getKysymykset();
        this.kysymystekstit=new String[20];
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel tyhja = new JLabel("");
        JLabel valintaKehotus = new JLabel("Valitse kysymys:");
        JLabel tyhja2 = new JLabel("");

        int i = 0;
        for (Object o : kysymykset.values()) {
            Kysymys kysymys = (Kysymys) o;
            kysymystekstit[i] = kysymys.getKysymys()+" ("+kysymys.getTyyppi().toString()+")";
            i++;
        }

        JList kysymysLista = new JList(kysymystekstit);
        kysymysLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        kysymysLista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        kysymysLista.setVisibleRowCount(-1);
        JScrollPane listanScrollaaja = new JScrollPane(kysymysLista);
        listanScrollaaja.setPreferredSize(new Dimension(250, 80));

        JLabel tyhja3 = new JLabel("");
        JButton valintaPainike = new JButton("Valitse");
        JLabel tyhja4 = new JLabel("");

        KysymysValintaKuuntelija kuuntelija = new KysymysValintaKuuntelija(
                this, kysymysLista, valintaPainike, kysymykset);

        valintaPainike.addActionListener(kuuntelija);


        add(tyhja);
        add(valintaKehotus);
        add(tyhja2);
        add(listanScrollaaja);
        add(tyhja3);
        add(valintaPainike);
        add(tyhja4);
    }
    
}
