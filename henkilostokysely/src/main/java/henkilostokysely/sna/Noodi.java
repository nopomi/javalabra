package henkilostokysely.sna;

/**
 *
 * @author Miska Noodi symboloi kaaviossa yhtä ihmistä, ja sen ID on sama kuin
 * ihmisen henkilöstönumero.
 */
public class Noodi {

    private final int id;

    /**
     * Metodi luo uuden Noodin annetulla id:llä.
     *
     * @param id
     */
    public Noodi(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Noodi" + id;
    }

    /**
     * Palauttaa noodin henkilöstönumeron eli id:n, tulee olemaan keskeinen asia
     * käyttöliittymässä.
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }
        if (this.getClass() != olio.getClass()) {
            return false;
        }
        Noodi verrattava = (Noodi) olio;

        if (verrattava.getId() != this.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }
}
