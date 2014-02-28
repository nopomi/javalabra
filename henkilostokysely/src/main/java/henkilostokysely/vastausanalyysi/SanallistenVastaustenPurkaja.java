package henkilostokysely.vastausanalyysi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SanallistenVastaustenPurkaja {
    
    /**
     * Metodi purkaa annetusta tiedostosta sanallista dataa ArrayList-aineistoksi
     * Ei tarkista annettuja vastauksia millään tavalla.
     * @param tiedostonNimi
     * @return 
     */
    public ArrayList puraVastauksetAineistoksi(String tiedostonNimi) {

        ArrayList<String> aineisto = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String valiMerkki = ",";

        try {

            br = new BufferedReader(new FileReader(tiedostonNimi));
            while ((line = br.readLine()) != null) {
                String[] vastaus = line.split(valiMerkki);

                try {
                    aineisto.add(vastaus[1]);
                } catch (Exception e) {
                    System.out.println("Vastauksen siirto ei onnistunut.");
                }

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Tiedostoa ei ole olemassa!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }

        return aineisto;
    }
}
