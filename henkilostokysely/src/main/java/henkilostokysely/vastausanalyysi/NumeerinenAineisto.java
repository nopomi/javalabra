package henkilostokysely.vastausanalyysi;

import java.util.ArrayList;

/**
 *
 * @author Miska
 */
public class NumeerinenAineisto {
    
    private ArrayList<Integer> aineisto;

    public NumeerinenAineisto(ArrayList<Integer> aineisto) {
        this.aineisto=aineisto;
    }

    public double laskeKeskiarvo() {

        int summa = 0;
        for (Integer arvo : this.aineisto) {
            summa += arvo;
        }
        return (1.0 * summa) / aineisto.size();
    }

    public double laskeKeskihajonta() {

        double varianssi = laskeVarianssi();
        return Math.sqrt(varianssi);

    }

    public double laskeVarianssi() {
        double keskiarvo = laskeKeskiarvo();
        double erotusneliosumma = 0;
        for (Integer arvo : this.aineisto) {
            erotusneliosumma += ((arvo - keskiarvo) * (arvo - keskiarvo));
        }
        return erotusneliosumma / aineisto.size();
    }
    
    public int[] likertJakauma(){
        int[] jakaumat = new int[5];
        int ykkoset = 0;
        int kakkoset = 0;
        int kolmoset = 0;
        int neloset = 0;
        int vitoset = 0;
        
        for (int arvo : this.aineisto) {
            if (arvo==1) {
                ykkoset++;
            } else if(arvo==2){
                kakkoset++;
            } else if(arvo==3){
                kolmoset++;
            } else if(arvo==4){
                neloset++;
            } else if(arvo==5){
                vitoset++;
            }
        }
        double summa = ykkoset+kakkoset+kolmoset+neloset+vitoset;
        
        jakaumat[0] = (int) (100*(1.0*ykkoset/summa));
        jakaumat[1] = (int) (100*(1.0*kakkoset/summa));
        jakaumat[2] = (int) (100*(1.0*kolmoset/summa));
        jakaumat[3] = (int) (100*(1.0*neloset/summa));
        jakaumat[4] = (int) (100*(1.0*vitoset/summa));
        
        return jakaumat;
        
    }
}
