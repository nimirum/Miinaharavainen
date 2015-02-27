package nimirum.Miinaharavainen.logiikka;

import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.highscore.EnnatystenKasittelija;

/**
 * Miinharava peli luokka, joka luo pelilaudan
 *
 * @author nimirum
 */
public final class Miinaharavainen {

    private final Pelilauta pelilauta;
    private int miinojenMaara = 0;
    private boolean miinoitettu = false;
    private final Kello pelikello;
    private String gameOver = null;
    private final EnnatystenKasittelija kasittelija;

    /**
     * Miinaharavan konstruktori, missä luodaan pelilauta annetuista arvoista.
     * Pelilaudan mittojen pitää olla väliltä 8-40, muuten luo 10x10 pelilaudan.
     *
     * @param leveys Pelilaudan leveys
     * @param korkeus Pelilaudan korkeus
     */
    public Miinaharavainen(int leveys, int korkeus) {
        if (8 <= leveys && leveys <= 40 && 8 <= korkeus && korkeus <= 40) {
            pelilauta = new Pelilauta(leveys, korkeus);
        } else {
            pelilauta = new Pelilauta(10, 10);
        }
        pelikello = new Kello();
        kasittelija = new EnnatystenKasittelija();
    }

    /**
     * Miinoittaa pelilaudan random lukujen avulla ensimmäisen klikkauksen
     * jälkeen. Asetttaa miinojen määrän muistiin, jota tarvitsee pelin
     * voittamiseen. Ajanoton pitäisi alkaa tämän metodin käynnistämisen jälkeen
     *
     * @param klikkausX Ensimmäisen klikkauksen x koordinaatti
     * @param klikkausY Ensimmäisen klikkauksen y koordinaatti
     */
    public void miinoitaLauta(int klikkausX, int klikkausY) {
        if (!miinoitettu) {
            pelilauta.miinoita(klikkausX, klikkausY);
            miinojenMaara = pelilauta.getMiinojenMaara();
            miinoitettu = true;
            pelikello.run();
        }
    }

    public Kello getKello() {
        return pelikello;
    }

    public boolean isPelilautaMiinoitettu() {
        return miinoitettu;
    }

    public int getMiinojenMaara() {
        return miinojenMaara;
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    /**
     * Pelin päättyminen, kello pysähtyy, kentän koko ja aika tallennetaan
     * ennätyksiin jos kyseessä voittaminen
     *
     * @param tapaus Voitto tai häviö
     */
    public void gameOver(String tapaus) {
        gameOver = tapaus;
        pelikello.stop();
        getPelilauta().avaaKaikkiRuudut();
    }

    public EnnatystenKasittelija getKasittelija() {
        return kasittelija;
    }

    public String getGameOver() {
        return gameOver;
    }
}
