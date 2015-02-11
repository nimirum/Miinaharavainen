package nimirum.Miinaharavainen.logiikka;

/**
 *Pelilaudan ruutu, mikä voi olla miina, tyhjä tai numero, joka kertoo vieressä olevien miinojen määrän
 * 
 * @author nimirum
 */
public class Ruutu {

    private boolean onkoMiina = false;
    private int viereistenMiinojenMaara = 0; //8 lähintä ruutua
    private int x;
    private int y;
    private boolean onkoRuutuNakyva = true;

    /**
     *
     * Parametrit x ja y ovat ruudun koordinaatit
     * 
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     */
    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param onkoMiina
     */
    public void setOnkoMiina(boolean onkoMiina) {
        this.onkoMiina = onkoMiina;
    }

    public boolean getOnkoRuutuNakyva() {
        return onkoRuutuNakyva;
    }

    public void setOnkoRuutuNakyva(boolean onkoRuutuNakyva) {
        this.onkoRuutuNakyva = onkoRuutuNakyva;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

    /**
     *
     * @return
     */
    public boolean getOnkoMiina() {
        return onkoMiina;
    }

    /**
     *
     * @param viereistenMiinojenMaara
     */
    public void setViereistenMiinojenMaara(int viereistenMiinojenMaara) {
        //arvot väliltä 0-8
        if (0 <= viereistenMiinojenMaara && viereistenMiinojenMaara <= 8) {
            this.viereistenMiinojenMaara = viereistenMiinojenMaara;
        }
    }

    /**
     *
     */
    public void addViereistenMiinojenMaaraa() {
        viereistenMiinojenMaara++;
    }

    /**
     *
     * @return
     */
    public int getViereistenMiinojenMaara() {
        return viereistenMiinojenMaara;
    }

    @Override
    public String toString() {
        if (onkoMiina) {
            return " x";
        } //Jos on miina niin miinojenmäärä ei tulostu
        if (viereistenMiinojenMaara > 0) {
            return " " + viereistenMiinojenMaara;
        } //Tyhja ruutu
        else {
            return " .";
        }
    }

}
