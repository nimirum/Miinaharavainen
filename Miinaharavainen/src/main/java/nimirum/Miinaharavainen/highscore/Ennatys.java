package nimirum.Miinaharavainen.highscore;

/**
 * Ennätyksessa on tallessa pelaajan antama nimi, aika jolloin peli päättyi ja
 * pelilaudan koko
 *
 * @author nimirum
 */
public class Ennatys implements Comparable<Ennatys> {

    private final String pelaaja;
    private final int aika;
    private final String pelilauta;

    /**
     *
     * @param pelaaja
     * @param aika
     * @param pelilauta
     */
    public Ennatys(String pelaaja, int aika, String pelilauta) {
        this.pelaaja = pelaaja;
        this.aika = aika;
        this.pelilauta = pelilauta;
    }

    public int getAika() {
        return aika;
    }

    public String getPelilauta() {
        return pelilauta;
    }

    public String getPelaaja() {
        return pelaaja;
    }

    @Override
    public int compareTo(Ennatys ennatys) {
        return this.aika - ennatys.getAika();
    }

    @Override
    public String toString() {
        return getPelaaja() + " - " + getAika() + " - " + getPelilauta();
    }

    /**
     *
     * @return Ennätys toString muodossa EnnatyksetIkkuna luokkaa varten
     */
    public String tulostaEnnatys() {
        return getPelaaja() + " - " + kellonAika() + " - " + getPelilauta();
    }

    /**
     *
     * @return Muotoilee kellon ajan kolmen numeron muotoon
     */
    public String kellonAika() {
        if (getAika() < 10) {
            return "00" + getAika();
        }
        if (getAika() < 100) {
            return "0" + getAika();
        }
        return "" + getAika();
    }

}
