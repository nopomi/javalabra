/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.gui.analysointi;

import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.gui.Valikko;
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
        JButton takaisinPainike = new JButton("Päävalikkoon");

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

        KysymysValintaKuuntelija kuuntelija = new KysymysValintaKuuntelija(
                this, kysymysLista, valintaPainike, takaisinPainike);

        valintaPainike.addActionListener(kuuntelija);
        takaisinPainike.addActionListener(kuuntelija);


        add(tyhja);
        add(valintaKehotus);
        add(tyhja2);
        add(listanScrollaaja);
        add(tyhja3);
        add(valintaPainike);
        add(takaisinPainike);
    }
    
    public void vaihdaValikko(Valikko vaihdettava){
        kayttis.poistaValikko(Valikko.ANALYSOINTIKYSYMYS);
        kayttis.vaihdaValikko(vaihdettava);
    }
    
    public void vaihdaValikko(int valintaIndeksi){
        
        Kysymys valittuKysymys = (Kysymys) kysymykset.get(valintaIndeksi+1);
        
        if(valittuKysymys.getTyyppi()==Vastaustyyppi.ASTEIKKO){
            //luo TilastoValikko
        } else if(valittuKysymys.getTyyppi()==Vastaustyyppi.AVOIN){
            //luo AvoinValikko
        } else if(valittuKysymys.getTyyppi()==Vastaustyyppi.KOLMIKENTTA){
            SNAValikko snaValikko = new SNAValikko(kayttis, valittuKysymys);
            kayttis.lisaaValikko(Valikko.ANALYSOINTISNA, snaValikko);
            kayttis.vaihdaValikko(Valikko.ANALYSOINTISNA);
        } else if(valittuKysymys.getTyyppi()==Vastaustyyppi.LIKERT){
            //luo LikertValikko
        }
        
    }
    
}
