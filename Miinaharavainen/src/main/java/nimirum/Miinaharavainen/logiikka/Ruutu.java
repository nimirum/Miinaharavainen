package nimirum.Miinaharavainen.logiikka;

import java.util.ArrayList;

/**
 * Pelilaudan ruutu, mikä voi olla miina, tyhjä tai numero, joka kertoo vieressä
 * olevien miinojen määrän
 *
 * @author nimirum
 */
public class Ruutu {

    private int viereistenMiinojenMaara = 0; //8 lähintä ruutua
    private int x;
    private int y;
    private final int ruudunLeveys = 24;
    private final int ruudunKorkeus = 24;
    private Pelilauta pelilauta;
    private ArrayList viereisetRuudut;
    private boolean onkoMiina = false;
    private boolean onkoRuutuNakyva = false;
    private boolean klikattuMiina = false;
    private boolean onkoLiputettu = false;

    /**
     *
     * Parametrit x ja y ovat ruudun koordinaatit
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     * @param pelilauta Pelilauta
     */
    public Ruutu(int x, int y, Pelilauta pelilauta) {
        this.x = x;
        this.y = y;
        this.pelilauta = pelilauta;

    }

    /**
     * Asettaa ruudun viereiset ruudut muistiin
     *
     * @param list ArrayList
     */
    public void setViereisetRuudut(ArrayList<Ruutu> list) {
        this.viereisetRuudut = list;
    }

    /**
     *
     * @return ArrayList viereisistä ruuduista
     */
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
     * @return Onko ruutu näkyvä, eli onko se klikattava
     */
    public boolean getOnkoRuutuNakyva() {
        return onkoRuutuNakyva;
    }

    /**
     * Asettaa ruudnu näkyvyysarvon Piirtäjää varten False arvolla piirtää
     * päällimmäisen ruudun True arvolla piirtää mitä ruutu on oikeasti
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

    /**
     * Käy ruudun viereiset ruudut läpi ja lisää viereisten miinojen määrää, jos
     * itse ruudussa on miina
     */
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
     * @return viereisten miinojen määrä
     */
    public int getViereistenMiinojenMaara() {
        return viereistenMiinojenMaara;
    }

    /**
     *
     * @return onko ruudussa miina ja onko sitä klikattu, piirtäjää varten
     */
    public boolean isKlikattuMiina() {
        return klikattuMiina;
    }

    /**
     * Piirtäjää varten mahdollista asettaa mikä on klikattu miina
     * @param klikattuMiina
     */
    public void setKlikattuMiina(boolean klikattuMiina) {
        if (getOnkoMiina()) {
            this.klikattuMiina = klikattuMiina;
        }
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

    /**
     *
     * @return Ruudun korkeus
     */
    public int getRuudunKorkeus() {
        return ruudunKorkeus;
    }

    /**
     *
     * @return Ruudun leveys
     */
    public int getRuudunLeveys() {
        return ruudunLeveys;
    }

    /**
     *
     * @return onko ruutu liputetu
     */
    public boolean isOnkoLiputettu() {
        return onkoLiputettu;
    }

    /**
     * Ruudun voi liputtaa vain jos sitä ei ole klikattu vielä
     * @param onkoLiputettu
     */
    public void setOnkoLiputettu(boolean onkoLiputettu) {
        if (!getOnkoRuutuNakyva()) {
            this.onkoLiputettu = onkoLiputettu;
        }
    }

    /**
     * Avaa kaikki tyhjän ruudun vieressä olevat tyhjät ruudut ja viereiset numeroruudut
     */
    public void avaaViereisetRuudut() {

        for (Ruutu viereinen : getViereisetRuudut()) {
            if (viereinen.onkoRuutuNakyva == false) {
                if (viereinen.getViereistenMiinojenMaara() == 0) {
                    viereinen.setOnkoRuutuNakyva(true);
                    viereinen.avaaViereisetRuudut();
                } else {
                    viereinen.setOnkoRuutuNakyva(true);
                }
            }
        }
    }
}
