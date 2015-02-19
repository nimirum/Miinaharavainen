package nimirum.Miinaharavainen.logiikka;

import java.util.ArrayList;

/**
 * Pelilaudan ruutu, mikä voi olla miina, tyhjä tai numero, joka kertoo vieressä
 * olevien miinojen määrän
 *
 * @author nimirum
 */
public class Ruutu {

    private boolean onkoMiina = false;
    private int viereistenMiinojenMaara = 0; //8 lähintä ruutua
    private int x;
    private int y;
    private boolean onkoRuutuNakyva = false;
    private final int ruudunLeveys = 24;
    private final int ruudunKorkeus = 24;
    private boolean onkoLiputettu = false;
    private Pelilauta pelilauta;
    private ArrayList viereisetRuudut;

    /**
     *
     * Parametrit x ja y ovat ruudun koordinaatit
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     */
    public Ruutu(int x, int y, Pelilauta pelilauta) {
        this.x = x;
        this.y = y;
        this.pelilauta = pelilauta;

    }

    public void setViereisetRuudut(ArrayList<Ruutu> list) {
        this.viereisetRuudut = list;
    }

    public ArrayList<Ruutu> getViereisetRuudut() {
        return viereisetRuudut;
    }

    /**
     * Ruudulle voi asettaa tai poistaa miinan
     *
     * @param onkoMiina
     */
    public void setOnkoMiina(boolean onkoMiina) {
        this.onkoMiina = onkoMiina;
    }

    /**
     *
     * @return onko ruutu näkyvä, eli onko sen päällä klikattava ruutu
     */
    public boolean getOnkoRuutuNakyva() {
        return onkoRuutuNakyva;
    }

    /**
     * Asettaa ruudnu näkyvyysarvon Piirtäjää varten
     *
     * @param onkoRuutuNakyva
     */
    public void setOnkoRuutuNakyva(boolean onkoRuutuNakyva) {
        this.onkoRuutuNakyva = onkoRuutuNakyva;
    }

    /**
     *
     * @return Ruudun sijainti x suunnassa
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Ruudun sijainti y suunnassa
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return onkoMiina
     */
    public boolean getOnkoMiina() {
        return onkoMiina;
    }

    public void laskeNumerot() {
        for (Ruutu viereinen : getViereisetRuudut()) {
            if (viereinen.onkoMiina) {
                addViereistenMiinojenMaaraa();
            }
        }
    }

    /**
     * Ruudulle asetetan viereisten miinojen määrä, arvo voi olla väliltä 0-8
     *
     * @param viereistenMiinojenMaara
     */
    public void setViereistenMiinojenMaara(int viereistenMiinojenMaara) {
        if (0 <= viereistenMiinojenMaara && viereistenMiinojenMaara <= 8) {
            this.viereistenMiinojenMaara = viereistenMiinojenMaara;
        }
    }

    /**
     * Lisää viereisten miinojen määrää yhdellä
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

    public int getRuudunKorkeus() {
        return ruudunKorkeus;
    }

    public int getRuudunLeveys() {
        return ruudunLeveys;
    }

    public boolean isOnkoLiputettu() {
        return onkoLiputettu;
    }

    public void setOnkoLiputettu(boolean onkoLiputettu) {
        if (onkoLiputettu = true && !getOnkoRuutuNakyva()) {
            this.onkoLiputettu = onkoLiputettu;
        }
    }

}
