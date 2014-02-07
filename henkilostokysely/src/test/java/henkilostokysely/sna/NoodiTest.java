
package henkilostokysely.sna;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NoodiTest {
    public Noodi noodi;
    
    public NoodiTest(){
    }
    
    @Before
    public void setUp(){
        noodi = new Noodi(123);
    }
    
    @Test
    public void konstruktoriToimii(){
        assertEquals("Noodi123", noodi.toString());
    }
    
    @Test
    public void getIdToimii(){
        assertEquals(123, noodi.getId());
    }
    
    @Test
    public void hashCodeToimii(){
        Noodi noodi2 = new Noodi(123);
        Noodi noodi3 = new Noodi(124);
        
        assertEquals(noodi.getId(), noodi2.getId());
        assertFalse(noodi.equals(noodi3));
    }
    
    @Test
    public void equalsToimii(){
        
        String lol = "noodi";
        Noodi noodi2 = new Noodi(124);
        assertFalse(noodi.equals(null));
        assertFalse(noodi.equals(lol));
        assertFalse(noodi.equals(noodi2));
                
    }
    
    
}
