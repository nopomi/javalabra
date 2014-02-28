/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.domain;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author mnoponen@cs
 */
public class KyselysailioTest {
    
    private Kyselysailio sailio;
    
    @Before
    public void setUp(){
        sailio=new Kyselysailio();
    }
    
    @Test
    public void KyselynLuominenToimii(){
        Kysely kysely = sailio.luoKysely("testikysely");
        assertEquals("testikysely", kysely.getNimi());
    }
    
    @Test
    public void KyselynLuominenLisaaSenSailioon(){
        Kysely kysely1 = sailio.luoKysely("testi1");
        Kysely kysely2 = sailio.luoKysely("testi2");
        
        assertEquals(2, sailio.getKyselyt().size());
    }
    
    @Test
    public void LuotujenKyselyjenLisaaminenToimii(){
        Kysely kysely = new Kysely("testi1");
        Kysely kysely2 = new Kysely("testi2");
        Kysely kysely3 = new Kysely("testi3");
        
        sailio.lisaaKysely(kysely);
        sailio.lisaaKysely(kysely2);
        sailio.lisaaKysely(kysely3);
        
        assertEquals(3, sailio.getKyselyt().size());
        assertEquals("testi1", sailio.getKysely("testi1").getNimi());
    }
    
    
}
