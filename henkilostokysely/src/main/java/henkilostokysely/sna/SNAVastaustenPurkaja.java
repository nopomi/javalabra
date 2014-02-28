
package henkilostokysely.sna;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Luokka lukee csv-tiedostoja ja purkaa ne verkostokaavioiksi.
 * @author Miska
 */
public class SNAVastaustenPurkaja {
    
    
    /**
     * Metodi purkaa annetun tiedostonimen perusteella annettua tietoa
     * verkostokaavioksi. Se tarkistaa sisällön oikeellisuuden ennen
     * sen siirtämistä eteenpäin.
     * @param tiedostoNimi
     * @return 
     */
    public Kaavio puraVastauksetKaavioksi(String tiedostoNimi){
        
        Kaavio kaavio = new Kaavio();
        BufferedReader br = null;
        String line = "";
        String valiMerkki = ",";
        
        try{
            
            br = new BufferedReader(new FileReader(tiedostoNimi));
            while((line = br.readLine()) !=null){
                //pilkkoo vastauksesta vastaajahenkilön noodin
                String[] vastaukset = line.split(valiMerkki);
                Noodi testiNoodi = new Noodi(Integer.parseInt(vastaukset[0]));
                Noodi lahde = kaavio.lisaaNoodi(testiNoodi);
                //pilkkoo vastauksesta muut osat ja tekee niiden välille linkit
                for (int i = 1; i < vastaukset.length; i++) {
                    try{
                    Noodi testiKohde = new Noodi(Integer.parseInt(vastaukset[i]));
                    Noodi kohde = kaavio.lisaaNoodi(testiKohde);
                    kaavio.lisaaLinkki(lahde, kohde);
                    
                    } catch(NumberFormatException e){
                        System.out.println("Vastaus väärässä muodossa!");
                    }
                }
                
            }
            }catch (Exception e){
                e.printStackTrace(System.out);
                System.out.println("Tiedostoa ei ole olemassa!");
        } finally {
            if (br!=null){
                try{
                    br.close();
                } catch (Exception e){
                    e.printStackTrace(System.out);
                }
            }
        }
        
        return kaavio;
        
    }
    
}
