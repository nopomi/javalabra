package henkilostokysely.sna;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkkiTest {
    
    Linkki linkki;
    
    public LinkkiTest(){
    }
    
    @Before
    public void setUp(){
        linkki = new Linkki(2.0, 48);
    }
    
    @Test
    public void konstruktoriToimii(){
        assertEquals("Linkki0", linkki.toString());
    }
}
