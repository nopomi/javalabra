package javalabra.henkilostokysely.tallennus;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VastaustenTallentajaTest {

    @Test
    public void VastaustenTallentajanKonstruktoriToimii() {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja();
        assertEquals(0, tallentaja.getIndeksi());
        tallentaja.setIndeksi(5);
        assertEquals(5, tallentaja.getIndeksi());

    }

    @Test
    public void vastaustenTalletusEiKuse() {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja();
        tallentaja.talletaVastaus(123, "hehehe");
        tallentaja.talletaVastaus(666, "Hello csv!");

        //csv-tallennus toimii siten että se luo tiedoston koneelleni ja kirjoittaa siihen. 
        //en vaan osannut testata sen paremmin, tulen ensi viikolla pajaan
        //anelemaan apua asian kanssa. Kirjoittaa nyt saman rivin päälle.
    }

    @Test
    public void vastaustenTalletusEiKuseIndeksinMuutoksellakaan() {
        VastaustenTallentaja tallentaja = new VastaustenTallentaja();
        tallentaja.setIndeksi(12312312);
        tallentaja.talletaVastaus(10007, "(//__ö) = emokid");
    }
}
