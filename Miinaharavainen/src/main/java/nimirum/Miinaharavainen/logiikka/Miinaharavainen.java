package nimirum.Miinaharavainen.logiikka;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.EnnatyksenTallentaminen;
import nimirum.Miinaharavainen.highscore.TiedostonKasittelija;

/**
 * Miinharava peli luokka, joka luo pelilaudan
 *
 * @author nimirum
 */
public final class Miinaharavainen {

    private Pelilauta pelilauta;
    private int miinojenMaara = 0;
    private boolean miinoitettu = false;
    private final Kello pelikello;
    private String gameOver = null;
    private final TiedostonKasittelija kasittelija;

    /**
     * Miinaharavan konstruktori, missä luodaan pelilauta annetuista arvoista
     *
     * @param leveys Pelilaudan leveys
     * @param korkeus Pelilaudan korkeus
     */
    public Miinaharavainen(int leveys, int korkeus) {
        luoPelilauta(leveys, korkeus);
        pelikello = new Kello();
        kasittelija = new TiedostonKasittelija();
    }

    /**
     * Pelilaudan koko pitää olla väliltä 8-50 korkeus- ja leveyssuunnassa. Jos
     * koko on väärä, niin luodaan automaattisesti 10*10 pelilauta.
     *
     * @param x Pelilaudan leveys
     * @param y Pelilaudan korkeus
     */
    public void luoPelilauta(int x, int y) {
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
     * ennätyksiin jos voittaminen
     *
     * @param tapaus Voitto tai häviö
     */
    public void gameOver(String tapaus) {
        gameOver = tapaus;
        switch (tapaus) {
            case "Voitto":
                pelikello.stop();
                getPelilauta().avaaKaikkiRuudut();
                SwingUtilities.invokeLater((Runnable) new EnnatyksenTallentaminen(this));
            case "Havio":
                pelikello.stop();
              //  SwingUtilities.invokeLater((Runnable) new EnnatyksenTallentaminen(this));

        }
    }

    public TiedostonKasittelija getKasittelija() {
        return kasittelija;
    }

    public String getGameOver() {
        return gameOver;
    }
}
