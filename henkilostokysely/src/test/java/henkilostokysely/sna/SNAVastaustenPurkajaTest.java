package henkilostokysely.sna;

import henkilostokysely.domain.Kysely;
import henkilostokysely.tallennus.VastaustenTallentaja;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SNAVastaustenPurkajaTest {
    
    @Test
    public void SNAPurkajaToimii(){
        VastaustenTallentaja tallentaja = new VastaustenTallentaja(55);
        Kysely kysely = new Kysely("SNAtestikysely");
        tallentaja.talletaVastaus(kysely, 3, "2,1,4");
        tallentaja.talletaVastaus(kysely, 1, "4,2,3");
        
        SNAVastaustenPurkaja purkaja = new SNAVastaustenPurkaja();
        Kaavio kaavio = purkaja.puraVastauksetKaavioksi("SNAtestikysely_55_vastaukset.csv");
        
        assertEquals(4, kaavio.getKaavio().getVertexCount());
        assertEquals(6, kaavio.getKaavio().getEdgeCount());
    }
    
    
    @Test
    public void ToimiiJosTiedostoaEiOle(){
        SNAVastaustenPurkaja purkaja = new SNAVastaustenPurkaja();
        Kaavio kaavio = purkaja.puraVastauksetKaavioksi("SNAKysely_olematon_vastaukset.csv");
        
        assertEquals(0, kaavio.getKaavio().getVertexCount());
        assertEquals(0, kaavio.getKaavio().getEdgeCount());
    }
}
