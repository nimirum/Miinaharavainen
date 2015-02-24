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

    private Miinaharavainen miinaharavainen;
    private Ruutu ruutu;
    private int x;
    private int y;

    /**
     * Luo neliön muotoisen tapahtumaalueen, kooltaan 24x24
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     * @param ruutu Ruutu
     * @param miinaharavainen Miinaharavainen
     */
    public TapahtumaAlue(int x, int y, Ruutu ruutu, Miinaharavainen miinaharavainen) {
        super(x, y, ruutu.getRuudunLeveys(), ruutu.getRuudunKorkeus());
        this.miinaharavainen = miinaharavainen;
        this.ruutu = ruutu;
        this.x = x;
        this.y = y;
    }

    /**
     * Tarkistaa onko alueeseen klikattu ja toimii sen mukaan
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     */
    public void alueeseenKlikattu(int x, int y) {

        if (onkoKlikkausAlueella(x, y)) {
            if (ruutu == null) {
                return;
            }

            miinaharavainen.getPelilauta().paivitaKlikatutRuudut();
            if (!miinaharavainen.isPelilautaMiinoitettu()) {
                miinaharavainen.miinoitaLauta(ruutu.getX(), ruutu.getY());
            }
            if (!ruutu.getOnkoRuutuNakyva() && !ruutu.isOnkoLiputettu()) {

                ruutu.setOnkoRuutuNakyva(true);
                miinaharavainen.getPelilauta().paivitaKlikatutRuudut();

                if (ruutu.getViereistenMiinojenMaara() == 0) {
                    ruutu.avaaViereisetRuudut();
                }
                if (miinaharavainen.getPelilauta().onkoPeliPaattynyt()) {
                    miinaharavainen.gameOver("Voitto");
                }
            }
            if (ruutu.getOnkoMiina()) {
                ruutu.setKlikattuMiina(true);
                miinaharavainen.gameOver("Havio");
            }

        }
    }

    private boolean onkoKlikkausAlueella(int x, int y) {
        if (this.x + ruutu.getRuudunLeveys() > x && this.x < x && this.y + ruutu.getRuudunLeveys() > y && this.y < y) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Liputtaa ruudun, joka on parametreina saaduissa koordinaateissa
     *
     * @param x Leveys koordinaatti
     * @param y Korkeus koordinaatti
     */
    public void alueenLiputus(int x, int y) {
        if (onkoKlikkausAlueella(x, y)) {
            if (ruutu == null) {
                return;
            }
            if (!ruutu.getOnkoRuutuNakyva()) {
                if (!ruutu.isOnkoLiputettu()) {
                    ruutu.setOnkoLiputettu(true);
                } else {
                    ruutu.setOnkoLiputettu(false);
                }
            }
        }
    }
}
