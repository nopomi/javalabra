
package henkilostokysely.sna;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Luokka lukee csv-tiedostoja ja purkaa ne kaavioiksi.
 * @author Miska
 */
public class TiedostonPurkaja {
    
    
    /**
     *
     * @param tiedostoNimi
     */
    public Kaavio puraVastauksetKaavioksi(String tiedostoNimi){
        
        Kaavio kaavio = new Kaavio();
        BufferedReader br = null;
        String line = "";
        String valiMerkki = ",";
        
        try{
            
            br = new BufferedReader(new FileReader(tiedostoNimi));
            while((line = br.readLine()) !=null){
                String[] vastaukset = line.split(valiMerkki);
                Noodi testiNoodi = new Noodi(Integer.parseInt(vastaukset[0]));
                Noodi lahde = kaavio.lisaaNoodi(testiNoodi);
                
                for (int i = 1; i < vastaukset.length; i++) {
                    Noodi testiKohde = new Noodi(Integer.parseInt(vastaukset[i]));
                    Noodi kohde = kaavio.lisaaNoodi(testiKohde);
                    kaavio.lisaaLinkki(lahde, kohde);
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
