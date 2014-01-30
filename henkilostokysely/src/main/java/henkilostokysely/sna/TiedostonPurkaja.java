
package henkilostokysely.sna;

import java.io.BufferedReader;
import java.io.FileReader;


public class TiedostonPurkaja {
    
    
    public static void puraVastauksetKaavioksi(String tiedostoNimi){
        
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
                
                for (int i = 1; i <= vastaukset.length; i++) {
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
        
    }
    
}
