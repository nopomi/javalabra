
package javalabra.henkilostokysely.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KyselyTest {

    Kysely kysely;

    public KyselyTest(){
    }

    public static void setUpClass() {
    }

    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kysely = new Kysely("testikysely");

    }

    @Test
    public void luokyselynOikein() {
        assertEquals("testikysely", kysely.getNimi());
        assertEquals(0, kysely.getKysymykset().size());
    }

    @Test
    public void lisaaYhdenKysymyksenOikein() {
        kysely.lisaaKysymys("Sano jotain:", Vastaustyyppi.AVOIN);
        assertEquals(1, kysely.getKysymykset().size());
    }

    @Test
    public void lisaaKaksiKysymystaOikeinAvoin() {
        kysely.lisaaKysymys("trololo", Vastaustyyppi.LIKERT);
        kysely.lisaaKysymys("Kerro vähän", Vastaustyyppi.MONIVALINTA);
        assertEquals(2, kysely.getKysymykset().size());
    }

    @Test
    public void eiLisaaSamaaKysymystaKahdesti() {
        kysely.lisaaKysymys("trolo", Vastaustyyppi.AVOIN);
        kysely.lisaaKysymys("trolo", Vastaustyyppi.AVOIN);
        kysely.lisaaKysymys("trolo", Vastaustyyppi.LIKERT);

        assertEquals(2, kysely.getKysymykset().size());
        assertFalse(kysely.lisaaKysymys("trolo", Vastaustyyppi.LIKERT));
    }
}
