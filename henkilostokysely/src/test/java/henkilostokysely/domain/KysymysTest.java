
package henkilostokysely.domain;

import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.tallennus.VastaustenTallentaja;
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
        Kysymys kyssari = new Kysymys("Miksi?", Vastaustyyppi.ASTEIKKO, 0);
        assertEquals("Miksi?", kyssari.getKysymys());
        assertEquals(Vastaustyyppi.ASTEIKKO, kyssari.getTyyppi());
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
        
        VastaustenTallentaja tallentaja = kyssari.getTallentaja();
        assertEquals(122, tallentaja.getIndeksi());
    }
    
    @Test
    public void kysymyksenEqualsToimii(){
        Kysymys kyssari = new Kysymys("Oletko", Vastaustyyppi.LIKERT,0);
        Kysymys kyssari2 = new Kysymys("Oletko", Vastaustyyppi.ASTEIKKO, 0);
        String kysymys = "hehz";
        
        assertFalse(kyssari.equals(kysymys));
        assertFalse(kyssari.equals(kyssari2));
        assertFalse(kyssari.equals(null));
    }
    
    @Test
    public void kysymyksenHashCodeToimii(){
        Kysymys kyssari = new Kysymys("Oletko?", Vastaustyyppi.ASTEIKKO, 1);
        Kysymys vertailuKyssari = new Kysymys("Oletko?", Vastaustyyppi.ASTEIKKO, 3);
        assertEquals(kyssari.hashCode(),vertailuKyssari.hashCode());
    }
    
    @Test
    public void SetJaGetKyselyToimii(){
        Kysymys kyssari = new Kysymys("Oletko?", Vastaustyyppi.ASTEIKKO, 1);
        Kysely kysely = new Kysely("testi");
        kyssari.setKysely(kysely);
        
        assertEquals(kysely, kyssari.getKysely());
    }
}
