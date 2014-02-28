package henkilostokysely.tallennus;

import henkilostokysely.domain.Kysely;
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
        Kysely kysely1 = new Kysely("testi");
        tallentaja.talletaVastaus(kysely1, 123, "hehehe");
        String[] osat = null;

        Scanner tiedostonLukija = new Scanner(new File("testi_1_vastaukset.csv"));

        while (tiedostonLukija.hasNextLine()) {
            String rivi = tiedostonLukija.nextLine();
            osat = rivi.split(",");
        }

        assertEquals("123", osat[0].toString());
        assertEquals("hehehe", osat[1].toString());

    }
}
