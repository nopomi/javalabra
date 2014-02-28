/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.vastausanalyysi;

import henkilostokysely.domain.Kysely;
import henkilostokysely.tallennus.VastaustenTallentaja;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mnoponen@cs
 */
public class SanallistenVastaustenPurkajaTest {
    
       @Before
    public void setUp(){
        
    }
    
    @Test
    public void SanallisenAineistonLukeminenToimii(){
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(111);
        Kysely kysely = new Kysely("sanatestikysely");
        tallentaja.talletaVastaus(kysely, 123, "seppo");
        tallentaja.talletaVastaus(kysely, 124, "hovi");
        
        SanallistenVastaustenPurkaja purkaja = new SanallistenVastaustenPurkaja();
        ArrayList<String> vastaukset = purkaja.puraVastauksetAineistoksi(
        "sanatestikysely_111_vastaukset.csv");
        
        assertEquals("seppo", vastaukset.get(0));
        assertEquals("hovi", vastaukset.get(1));
    }
    
    
    @Test
    public void TiedostoaEiOlemassa(){

        SanallistenVastaustenPurkaja purkaja = new SanallistenVastaustenPurkaja();
        ArrayList<String> vastaukset = purkaja.puraVastauksetAineistoksi(
        "testikysely_keksitty_vastaukset.csv");
        
        assertEquals(0, vastaukset.size());
    }
    
}
