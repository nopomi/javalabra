package henkilostokysely.tallennus;

import java.io.FileWriter;

public class VastaustenTallentaja {
    
    private int indeksi;
    
    public VastaustenTallentaja(int indeksi){
        this.indeksi=indeksi;
    }
    
    public void setIndeksi(int indeksi){
        this.indeksi=indeksi;
    }
    
    public int getIndeksi(){
        return this.indeksi;
    }
    
    public void talletaVastaus(int vastaaja, String vastaus) {
        try{
            FileWriter kirjoittaja = new FileWriter(this.indeksi+"_vastaukset.csv", true);
            kirjoittaja.append(vastaaja+","+vastaus+"\n");
            kirjoittaja.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    
    public void talletavastaus(int vastaaja, int vastaus1, int vastaus2, int vastaus3){
        try{
            FileWriter kirjoittaja = new FileWriter(this.indeksi+"_vastaukset.csv", true);
            kirjoittaja.append(vastaaja+","+vastaus1+","+vastaus2+","+vastaus3+"\n");
            kirjoittaja.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
