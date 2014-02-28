/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.vastausanalyysi;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mnoponen@cs
 */
public class NumeerinenAineistoTest {

    private NumeerinenAineisto aineisto;
    private ArrayList<Integer> data;

    @Before
    public void setUp() {
        data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(5);
        data.add(7);
        data.add(10);
    }

    @Test
    public void keskiarvonLaskeminenToimii() {
        aineisto = new NumeerinenAineisto(data);
        Double keskiarvo = aineisto.laskeKeskiarvo();

        assertEquals((1 + 2 + 5 + 7 + 10) * 1.0 / 5, keskiarvo, 0.01);
    }

    @Test
    public void varianssinLaskeminenToimii() {
        aineisto = new NumeerinenAineisto(data);
        Double varianssi = aineisto.laskeVarianssi();

        assertEquals(10.8, varianssi, 0.01);
        
    }
    
    @Test
    public void varianssinLaskeminenToimiiTarkasti(){
        data.clear();
        data.add(1);
        data.add(1);
        data.add(2);
        data.add(2);
        data.add(3);
        data.add(3);
        data.add(4);
        data.add(5);
        
        aineisto = new NumeerinenAineisto(data);
        assertEquals(1.734375, aineisto.laskeVarianssi() , 0.0001);
    }

    @Test
    public void keskihajonnanLaskeminenToimii() {
        aineisto = new NumeerinenAineisto(data);
        Double keskihajonta = aineisto.laskeKeskihajonta();

        assertEquals(3.29, keskihajonta, 0.01);
    }

    @Test
    public void likertJakaumanLaskeminenToimii() {
        data.clear();
        data.add(3);
        data.add(2);
        data.add(4);
        data.add(5);
        data.add(1);
        data.add(1);
        data.add(5);
        data.add(2);
        data.add(5);
        data.add(1);

        aineisto = new NumeerinenAineisto(data);
        int[] jakaumat = aineisto.likertJakauma();

        assertEquals(30, jakaumat[0]);
        assertEquals(20, jakaumat[1]);
        assertEquals(10, jakaumat[2]);
        assertEquals(10, jakaumat[3]);
        assertEquals(30, jakaumat[4]);
    }
    
    @Test
    public void likertJakaumanLaskeminenToimiiTarkasti(){
        data.clear();
        data.add(1);
        data.add(1);
        data.add(2);
        data.add(2);
        data.add(3);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(1);
        
        NumeerinenAineisto laskettavaAineisto = new NumeerinenAineisto(data);
        int[] jakauma = laskettavaAineisto.likertJakauma();
        
        assertEquals(33,jakauma[0]);
        assertEquals(22,jakauma[1]);
        assertEquals(22,jakauma[2]);
        assertEquals(11,jakauma[3]);
        assertEquals(11,jakauma[4]);
    }
}
