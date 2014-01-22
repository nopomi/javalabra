package javalabra.henkilostokysely.tallennus;

import java.io.FileWriter;

public class vastaustenTallentaja {

    public void talletaVastaus(String tiedostoNimi, String teksti) throws Exception {
        try (FileWriter kirjoittaja = new FileWriter(tiedostoNimi)) {
            kirjoittaja.write(teksti);
        } catch (Exception e){
            System.out.println("Tiedostoa ei löytynyt :<<<<");
        }
    }
}
