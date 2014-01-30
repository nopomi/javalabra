package henkilostokysely.sna;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.domain.Vastaustyyppi;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaavioTest {

    Kaavio kaavio;

    public KaavioTest() {
    }

    @Before
    public void setUp() {
        kaavio = new Kaavio();
    }

    @Test
    public void kaavionKonstruktoriToimii() {
        DirectedSparseMultigraph<Noodi, Linkki> uusiKaavio =
                (DirectedSparseMultigraph<Noodi, Linkki>) kaavio.getKaavio();

        assertEquals(0, uusiKaavio.getEdgeCount());
        assertEquals(0, uusiKaavio.getVertexCount());
        assertEquals("Vertices\n"
                + "Edges:", uusiKaavio.toString());
    }

    @Test
    public void lisaaNoodiToimii() {

        Noodi noodi = new Noodi(1);
        Noodi noodi2 = new Noodi(2);

        kaavio.lisaaNoodi(noodi);
        kaavio.lisaaNoodi(noodi2);


        DirectedSparseMultigraph<Noodi, Linkki> uusiKaavio =
                (DirectedSparseMultigraph<Noodi, Linkki>) kaavio.getKaavio();

        assertEquals(2, uusiKaavio.getVertexCount());

    }

    @Test
    public void lisaaNoodiToimiiDuplikaateilla() {
        Noodi noodi = new Noodi(2);
        Noodi noodi2 = new Noodi(2);

        kaavio.lisaaNoodi(noodi);
        kaavio.lisaaNoodi(noodi2);

        DirectedSparseMultigraph<Noodi, Linkki> uusiKaavio =
                (DirectedSparseMultigraph<Noodi, Linkki>) kaavio.getKaavio();

        assertEquals(1, uusiKaavio.getVertexCount());

    }
    
    @Test 
    public void lisaaLinkkiToimii(){
        Noodi noodi = new Noodi(1);
        Noodi noodi2 = new Noodi(2);
        Noodi noodi3 = new Noodi(3);
        
        kaavio.lisaaLinkki(noodi, noodi2);
        kaavio.lisaaLinkki(noodi2, noodi3);
        kaavio.lisaaLinkki(noodi3, noodi);
        
        DirectedSparseMultigraph<Noodi, Linkki> uusiKaavio =
                (DirectedSparseMultigraph<Noodi, Linkki>) kaavio.getKaavio();
        
        assertEquals(3, uusiKaavio.getEdgeCount());
    }
}
