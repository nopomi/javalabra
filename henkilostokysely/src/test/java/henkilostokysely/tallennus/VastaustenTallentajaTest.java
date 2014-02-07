package henkilostokysely.tallennus;

import henkilostokysely.tallennus.VastaustenTallentaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VastaustenTallentajaTest {
    
    //ei tähänkään ole mitään järkevää testaustapaa,
    //kyselen vinkkejä asiaan ircistä.

    @Test
    public void VastaustenTallentajanKonstruktoriToimii() {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(1);
        assertEquals(1, tallentaja.getIndeksi());
        tallentaja.setIndeksi(5);
        assertEquals(5, tallentaja.getIndeksi());

    }

    @Test
    public void vastaustenTalletusEiKuse() throws FileNotFoundException {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(1);
        tallentaja.talletaVastaus(123, "hehehe");
        String[] osat = null;
        
        Scanner tiedostonLukija = new Scanner(new File("1_vastaukset.csv"));
        
        while(tiedostonLukija.hasNextLine()){
            String rivi = tiedostonLukija.nextLine();
            osat = rivi.split(",");
        }
        
        assertEquals("123", osat[0].toString());
        assertEquals("hehehe", osat[1].toString());
        

    }
    
    @Test
    public void vastaustenKolmitalnnennusEiKuse() throws FileNotFoundException {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(333);
        tallentaja.talletaVastaus(112, 1, 2, 3);
    
    String[] osat = null;
    
    Scanner tiedostonLukija = new Scanner(new File("333_vastaukset.csv"));
    while(tiedostonLukija.hasNextLine()){
        String rivi = tiedostonLukija.nextLine();
        osat = rivi.split(",");
    }
    
    assertEquals("112", osat[0].toString());
    assertEquals("1", osat[1].toString());
    assertEquals("2", osat[2].toString());
    assertEquals("3", osat[3].toString());
    
    }
    
    @Test
    public void vastaustenTalletusEiKuseIndeksinMuutoksellakaan() {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(1);
        tallentaja.setIndeksi(12312312);
        tallentaja.talletaVastaus(10007, "(//__ö) = emokid");
    }
}
