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
     * @param x sijainti
     * @param y sijainti
     * @param ruutu
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
                //tarkista onko tyhjä ruutu, ketjreaktio avaa kaikki muut tyhjät myös
                //muuta kuva? eli repaint?
            }
            if (ruutu.getOnkoMiina()) {
                //GAMEOVER
                //kaikki ruudut näkyviksi, klikattu rikkinäiseksi
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

    public void alueenLiputus(int x, int y) {
        if (onkoKlikkausAlueella(x, y)) {
            if (ruutu == null) {
                return;
            }
            if (!ruutu.getOnkoRuutuNakyva()) {
                if(!ruutu.isOnkoLiputettu()){
                    ruutu.setOnkoLiputettu(true);
                }else{
                    ruutu.setOnkoLiputettu(false);
                }
            }
        }
    }
}
