/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilostokysely.vastausanalyysi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Miska
 * Toistaiseksi epäselvä, tulee jonkin sortin rakenne joka purkaa
 * numeerista vastausdataa tilastoiksi ja ilmoittaa ne käyttöliittymälle
 * 
 */
public class NumeeristenVastaustenPurkaja {
    
    
    public ArrayList puraVastauksetAineistoksi(String tiedostoNimi){
        
        ArrayList<Integer> aineisto = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String valiMerkki = ",";
        
        try{
            
            br = new BufferedReader(new FileReader(tiedostoNimi));
            while((line = br.readLine()) !=null){
                String[] vastaus = line.split(valiMerkki);
               
                try{
                    aineisto.add(Integer.parseInt(vastaus[1]));
                } catch (Exception e){
                    System.out.println("Vastaus väärässä muodossa");
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
        
        return aineisto;
        
    }
    
}
