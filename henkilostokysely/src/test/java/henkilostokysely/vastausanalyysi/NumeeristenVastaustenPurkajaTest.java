/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.vastausanalyysi;

import henkilostokysely.domain.Kysely;
import henkilostokysely.tallennus.VastaustenTallentaja;
import java.util.ArrayList;
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
public class NumeeristenVastaustenPurkajaTest {
    
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void NumeerisenAineistonLukeminenToimii(){
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(666);
        Kysely kysely = new Kysely("testikysely");
        tallentaja.talletaVastaus(kysely, 123, "2");
        tallentaja.talletaVastaus(kysely, 124, "4");
        
        NumeeristenVastaustenPurkaja purkaja = new NumeeristenVastaustenPurkaja();
        ArrayList<Integer> vastaukset = purkaja.puraVastauksetAineistoksi(
        "testikysely_666_vastaukset.csv");
        
        assertEquals(2, vastaukset.get(0).intValue());
        assertEquals(4, vastaukset.get(1).intValue());
    }
    
    @Test
    public void EiHuomioiVaarassaMuodossaOlevia(){
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(333);
        Kysely kysely = new Kysely("testikysely2");
        tallentaja.talletaVastaus(kysely, 123, "1");
        tallentaja.talletaVastaus(kysely, 124, "2");
        tallentaja.talletaVastaus(kysely, 125, "pfft");
        
        NumeeristenVastaustenPurkaja purkaja = new NumeeristenVastaustenPurkaja();
        ArrayList<Integer> vastaukset = purkaja.puraVastauksetAineistoksi(
        "testikysely2_333_vastaukset.csv");
        
        assertEquals(2, vastaukset.size());
    }
    
    @Test
    public void TiedostoaEiOlemassa(){

        NumeeristenVastaustenPurkaja purkaja = new NumeeristenVastaustenPurkaja();
        ArrayList<Integer> vastaukset = purkaja.puraVastauksetAineistoksi(
        "testikysely_keksitty_vastaukset.csv");
        
        assertEquals(0, vastaukset.size());
    }
    
}
