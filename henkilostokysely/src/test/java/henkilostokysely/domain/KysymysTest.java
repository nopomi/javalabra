
package henkilostokysely.domain;

import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.domain.Kysymys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KysymysTest {
    
    public KysymysTest(){
    }

    @Test
    public void kysymyksenKonstruktoriToimii() {
        Kysymys kyssari = new Kysymys("Miksi?", Vastaustyyppi.MONIVALINTA, 0);
        assertEquals("Miksi?", kyssari.getKysymys());
        assertEquals(Vastaustyyppi.MONIVALINTA, kyssari.getTyyppi());
        assertTrue(kyssari.getTallentaja() != null);
    }


    @Test
    public void kysymyksenIndeksinSetteriToimii() {
        Kysymys kyssari = new Kysymys("Oletko?", Vastaustyyppi.LIKERT,0);

        assertEquals(0, kyssari.getIndeksi());
        kyssari.setIndeksi(-1);
        assertEquals(-1, kyssari.getIndeksi());
        kyssari.setIndeksi(122);
        assertEquals(122, kyssari.getIndeksi());
    }
}
