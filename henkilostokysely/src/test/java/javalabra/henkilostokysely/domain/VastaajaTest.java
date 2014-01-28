
package javalabra.henkilostokysely.domain;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VastaajaTest {
    
    public VastaajaTest(){
    }

    @Test
    public void vastaajanLuontiToimii() {
        Vastaaja kalle = new Vastaaja(213, "Kalle Korvasieni");
        assertEquals("Kalle Korvasieni", kalle.getNimi());
        assertEquals(213, kalle.getNumero());
    }
}
