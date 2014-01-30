
package henkilostokysely.sna;


public class Linkki {
    
    private double kapasiteetti;
    private double paino;
    private int id;
    
    public Linkki(double paino, double kapasiteetti){
        this.paino=paino;
        this.kapasiteetti=kapasiteetti;
        this.id = 0;
    }
    
    
    @Override
    public String toString(){
        return "Linkki"+this.id;
    }
    
}
