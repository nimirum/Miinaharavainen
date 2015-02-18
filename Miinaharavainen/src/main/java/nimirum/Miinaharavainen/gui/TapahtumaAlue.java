package nimirum.Miinaharavainen.gui;

import java.awt.Image;
import java.awt.Rectangle;
import nimirum.Miinaharavainen.logiikka.Ruutu;

/**
 * Toiminnallisia ruudun muotoisia tapahtumaalueita jotka yhdistetään
 * klikkaustenkuuntelijaan
 *
 * @author nimirum
 */
public class TapahtumaAlue extends Rectangle {

    private Ruutu[][] ruudut;
    private Ruutu ruutu;
    private int x;
    private int y;

    /**
     * Luo neliön muotoisen tapahtumaalueen, kooltaan 24x24
     *
     * @param x sijainti
     * @param y sijainti
     * @param ruutu
     */
    public TapahtumaAlue(int x, int y, Ruutu ruutu) {
        super(x, y, ruutu.getRuudunLeveys(), ruutu.getRuudunKorkeus());
        this.ruutu = ruutu;
        this.x = x;
        this.y = y;
    }

    /**
     * Tarkistaa onko alueeseen klikattu ja toimii sen mukaan
     *
     * @param x
     * @param y
     */
    public void alueeseenKlikattu(int x, int y) {
        if (onkoKlikkausAlueella(x, y)) {
            if (ruutu == null) {
                return;
            }
            if (!ruutu.getOnkoRuutuNakyva()) {
                ruutu.setOnkoRuutuNakyva(true);
                //muuta kuva? eli repaint?
            }
            if (ruutu.getOnkoMiina()) {
                //GAMEOVER
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
}
