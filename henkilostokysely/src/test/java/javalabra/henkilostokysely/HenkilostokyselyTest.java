package javalabra.henkilostokysely;

import javalabra.henkilostokysely.domain.Kysely;
import javalabra.henkilostokysely.domain.Kysymys;
import javalabra.henkilostokysely.domain.Vastaaja;
import javalabra.henkilostokysely.domain.Vastaustyyppi;
import javalabra.henkilostokysely.tallennus.vastaustenTallentaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HenkilostokyselyTest {
    
    Kysely kysely;

    public HenkilostokyselyTest() {
    }
   
    
    public static void setUpClass(){
        
    }
    
    public static void tearDownClass(){
    }
    
    @Before
    public void setUp(){
        kysely = new Kysely("testikysely");
        
    }
    
    @Test
    public void luokyselynOikein(){
        assertEquals("testikysely", kysely.getNimi());
        assertEquals(0,kysely.getKysymykset().size());
    }
    
    @Test
    public void lisaaYhdenKysymyksenOikein(){
        kysely.lisaaKysymys("Sano jotain:", Vastaustyyppi.AVOIN);
        assertEquals(1,kysely.getKysymykset().size());
    }
    
    @Test
    public void lisaaKaksiKysymystaOikeinAvoin(){
        kysely.lisaaKysymys("trololo", Vastaustyyppi.LIKERT);
        kysely.lisaaKysymys("Kerro vähän", Vastaustyyppi.MONIVALINTA);
        assertEquals(2,kysely.getKysymykset().size());
    }
    
    @Test
    public void eiLisaaSamaaKysymystaKahdesti(){
        kysely.lisaaKysymys("trolo", Vastaustyyppi.AVOIN);
        kysely.lisaaKysymys("trolo", Vastaustyyppi.AVOIN);
        kysely.lisaaKysymys("trolo", Vastaustyyppi.LIKERT);
        
        assertEquals(2,kysely.getKysymykset().size());
        assertFalse(kysely.lisaaKysymys("trolo", Vastaustyyppi.LIKERT));
    }
    
    @Test
    public void kysymyksenKonstruktoriToimii(){
        Kysymys kyssari = new Kysymys ("Miksi?",Vastaustyyppi.MONIVALINTA);
        assertEquals("Miksi?",kyssari.getKysymys());
        assertEquals(Vastaustyyppi.MONIVALINTA,kyssari.getTyyppi());
        assertTrue(kyssari.getTallentaja()!=null);
    }
    
    @Test
    public void vastaajanLuontiToimii(){
     Vastaaja kalle = new Vastaaja(213,"Kalle Korvasieni");
     assertEquals("Kalle Korvasieni",kalle.getNimi());
     assertEquals(213,kalle.getNumero());
    }
    
    @Test
    public void kysymyksenIndeksinSetteriToimii(){
        Kysymys kyssari = new Kysymys("Oletko?",Vastaustyyppi.LIKERT);
        
        assertEquals(0,kyssari.getIndeksi());
        kyssari.setIndeksi(-1);
        assertEquals(-1,kyssari.getIndeksi());
        kyssari.setIndeksi(122);
        assertEquals(122,kyssari.getIndeksi());
    }
    
    @Test
    public void VastaustenTallentajanKonstruktoriToimii(){
      vastaustenTallentaja tallentaja = new vastaustenTallentaja();
      assertEquals(0,tallentaja.getIndeksi());
      tallentaja.setIndeksi(5);
      assertEquals(5, tallentaja.getIndeksi());
        
    }
    
    @Test
    public void vastaustenTalletusEiKuse(){
        vastaustenTallentaja tallentaja = new vastaustenTallentaja();
        tallentaja.talletaVastaus(123, "hehehe");
        tallentaja.talletaVastaus(666, "Hello csv!");
        
        //csv-tallennus toimii siten että se luo tiedoston koneelleni ja kirjoittaa siihen. 
        //en vaan osannut testata sen paremmin, tulen ensi viikolla pajaan
        //anelemaan apua asian kanssa. Kirjoittaa nyt saman rivin päälle.
    }
    
    @Test
    public void vastaustenTalletusEiKuseIndeksinMuutoksellakaan(){
        vastaustenTallentaja tallentaja = new vastaustenTallentaja();
        tallentaja.setIndeksi(12312312);
        tallentaja.talletaVastaus(10007, "(//__ö) = emokid");
    }
            
    public void tearDown(){
        
    }
}
