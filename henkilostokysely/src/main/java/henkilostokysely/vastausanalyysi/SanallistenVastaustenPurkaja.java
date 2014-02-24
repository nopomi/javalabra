package henkilostokysely.vastausanalyysi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SanallistenVastaustenPurkaja {
        

    public ArrayList puraVastauksetAineistoksi(String tiedostoNimi) {

        ArrayList<String> aineisto = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String valiMerkki = ",";

        try {

            br = new BufferedReader(new FileReader(tiedostoNimi));
            while ((line = br.readLine()) != null) {
                String[] vastaus = line.split(valiMerkki);

                try {
                    aineisto.add(vastaus[1]);
                } catch (Exception e) {
                    System.out.println("Vastaus väärässä muodossa");
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
