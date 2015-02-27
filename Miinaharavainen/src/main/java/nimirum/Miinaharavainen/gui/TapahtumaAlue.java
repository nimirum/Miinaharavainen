package nimirum.Miinaharavainen.gui;

import java.awt.Rectangle;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;
import nimirum.Miinaharavainen.logiikka.Ruutu;

/**
 * Toiminnallisia ruudun muotoisia tapahtumaalueita jotka yhdistetään
 * klikkaustenkuuntelijaan
 *
 * @author nimirum
 */
public class TapahtumaAlue extends Rectangle {

    private Kayttoliittyma kayttoliittyma;
    private final Miinaharavainen miinaharavainen;
    private final Ruutu ruutu;
    private final int x;
    private final int y;

    /**
     * Luo neliön muotoisen tapahtumaalueen, kooltaan 24x24
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     * @param ruutu Ruutu
     * @param miinaharavainen Miinaharavainen
     */
    public TapahtumaAlue(int x, int y, Ruutu ruutu, Miinaharavainen miinaharavainen, Kayttoliittyma kayttoliittyma) {
        super(x, y, ruutu.getRuudunLeveys(), ruutu.getRuudunKorkeus());
        this.miinaharavainen = miinaharavainen;
        this.kayttoliittyma = kayttoliittyma;
        this.ruutu = ruutu;
        this.x = x;
        this.y = y;
    }

    /**
     * Tarkistaa onko alueeseen klikattu ja toimii sen mukaan Jos pelilautaa ei
     * ole miinoitettu, se miinoitetaan ensimmäisen klikkauksen mukaan Kun ruutu
     * ei ole näkyvä, se muuttuu näkyväksi klikkauksesta Ruutu joka ei ole
     * näkyvä voi liputtaa
     *
     * @param klikkausX Leveys koordinaatti
     * @param klikkausY Korkeus koordinaatti
     */
    public void alueeseenKlikattu(int klikkausX, int klikkausY) {

        if (onkoKlikkausAlueella(klikkausX, klikkausY)) {
            if (ruutu == null) {
                return;
            }

            miinaharavainen.getPelilauta().paivitaKlikatutRuudut();
            if (!miinaharavainen.isPelilautaMiinoitettu()) {
                miinaharavainen.miinoitaLauta(ruutu.getX(), ruutu.getY());
            }
            if (!ruutu.getOnkoRuutuAvattu() && !ruutu.isOnkoRuutuLiputettu()) {

                ruutu.setOnkoRuutuAvattu(true);
                miinaharavainen.getPelilauta().paivitaKlikatutRuudut();

                if (ruutu.getViereistenMiinojenMaara() == 0) {
                    ruutu.avaaViereisetRuudut();
                }
                if (miinaharavainen.getPelilauta().onkoPeliPaattynyt()) {
                    miinaharavainen.gameOver("Voitto");
                    kayttoliittyma.ennatyksenTallentaminen();
                }
            }
            if (ruutu.getOnkoRuudussaMiina()) {
                ruutu.setKlikattuMiina(true);
                miinaharavainen.gameOver("Havio");
            }

        }
    }

    private boolean onkoKlikkausAlueella(int x, int y) {
        return (this.x + ruutu.getRuudunLeveys() > x && this.x < x && this.y + ruutu.getRuudunLeveys() > y && this.y < y);
    }

    /**
     * Liputtaa halutun ruudun(jos sallittua), joka on parametreina saaduissa
     * koordinaateissa
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     */
    public void alueenLiputus(int x, int y) {
        if (onkoKlikkausAlueella(x, y)) {
            if (ruutu == null) {
                return;
            }
            if (!ruutu.getOnkoRuutuAvattu()) {
                if (!ruutu.isOnkoRuutuLiputettu()) {
                    ruutu.setOnkoRuutuLiputettu(true);
                } else {
                    ruutu.setOnkoRuutuLiputettu(false);
                }
            }
        }
    }
}
