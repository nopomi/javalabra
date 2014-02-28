package henkilostokysely;

import henkilostokysely.domain.Kyselysailio;
import henkilostokysely.gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author Miska
 */
public class App {

    /**
     * Pääluokka, joka luo kyselysäiliön ja käyttöliittymän, sekä käynnistää
     * näistä jälkimmäisen.
     * @param args
     */
    public static void main(String[] args) {
        
        Kyselysailio sailio = new Kyselysailio();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(sailio);
        SwingUtilities.invokeLater(kayttoliittyma);


    }
}
