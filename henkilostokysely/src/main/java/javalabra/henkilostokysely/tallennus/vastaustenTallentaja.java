package javalabra.henkilostokysely.tallennus;

import java.io.FileWriter;

public class vastaustenTallentaja {
    
    //talletusrakenne vielä pahasti kesken, jäi vaan aikaa yli niin
    //rupesin koodaamaan tätä. Toimii alustavasti ja luo csv-tiedoston.
    
    private FileWriter kirjoittaja;
    private int indeksi;
    
    public vastaustenTallentaja(){
        this.indeksi=0;
    }
    
    public void setIndeksi(int indeksi){
        this.indeksi=indeksi;
    }
    
    public int getIndeksi(){
        return this.indeksi;
    }
    
    public void talletaVastaus(int vastaaja, String vastaus) {
        try{
            kirjoittaja = new FileWriter(indeksi+"_vastaukset.csv");
            kirjoittaja.append(vastaaja+", "+vastaus);
            kirjoittaja.append("\n");
            
            kirjoittaja.close();
            
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        
    }
}
