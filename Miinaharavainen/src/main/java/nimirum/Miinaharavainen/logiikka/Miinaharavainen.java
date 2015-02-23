package nimirum.Miinaharavainen.logiikka;

/**
 * Miinharava peli luokka, joka luo pelilaudan
 *
 * @author nimirum
 */
public final class Miinaharavainen {

    private Pelilauta pelilauta;
    private int miinojenMaara = 0;
    private boolean miinoitettu = false;
    private Kello pelikello;

    /**
     * Miinaharavan konstruktori, missä luodaan pelilauta annetuista arvoista
     *
     * @param leveys Pelilaudan leveys
     * @param korkeus Pelilaudan korkeus
     */
    public Miinaharavainen(int leveys, int korkeus) {
        setPelilaudanKoko(leveys, korkeus);
        pelikello = new Kello();
    }

    /**
     * Pelilaudan koko pitää olla väliltä 8-50 korkeus- ja leveyssuunnassa. Jos
     * koko on väärä, niin luodaan automaattisesti 10*10 pelilauta.
     *
     * @param x Pelilaudan leveys
     * @param y Pelilaudan korkeus
     */
    public void setPelilaudanKoko(int x, int y) {
        if (8 <= x && x <= 50 && 8 <= y && y <= 50) {
            pelilauta = new Pelilauta(x, y);
        } else {
            pelilauta = new Pelilauta(10, 10);
        }
    }

    /**
     * Miinoittaa pelilaudan random lukujen avulla ensimmäisen klikkauksen
     * jälkeen. Asetttaa miinojen määrän muistiin, jota tarvitsee pelin
     * voittamiseen. Ajanoton pitäisi alkaa tämän metodin käynnistämisen jälkeen
     *
     * @param x Ensimmäisen klikkauksen x koordinaatti
     * @param y Ensimmäisen klikkauksen y koordinaatti
     */
    public void miinoitaLauta(int x, int y) {
        if (!miinoitettu) {
            pelilauta.miinoita(x, y);
            miinojenMaara = pelilauta.getMiinojenMaara();
            miinoitettu = true;
            pelikello.run();
        }
    }

    public Kello getKello() {
        return pelikello;
    }

    /**
     *
     * @return Onko pelilauta miinoitettu
     */
    public boolean isPelilautaMiinoitettu() {
        return miinoitettu;
    }

    /**
     *
     * @return Pelilaudan miinojen määrä
     */
    public int getMiinojenMaara() {
        return miinojenMaara;
    }

    /**
     *
     * @return Pelilauta
     */
    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    /**
     * Pelin päättyminen, kello pysähtyy, kentän koko ja aika tallennetaan
     * ennätyksiin
     */
    public void gameOver() {
        //new Pelilauta?
    }
}
