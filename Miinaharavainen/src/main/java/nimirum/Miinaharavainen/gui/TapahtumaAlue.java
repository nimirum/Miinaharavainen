package nimirum.Miinaharavainen.gui;

import java.awt.Rectangle;
import nimirum.Miinaharavainen.logiikka.Ruutu;

/**
 *Toiminnallisia ruudun muotoisia tapahtumaalueita jotka yhdistetään klikkaustenkuuntelijaan
 * 
 * @author nimirum
 */
public class TapahtumaAlue extends Rectangle {

    private Ruutu[][] ruudut;
    private Ruutu ruutu;

    /**
     *Luo neliön muotoisen tapahtumaalueen, kooltaan 24x24
     * 
     * @param x
     * @param y
     * @param pelilauta
     * @param ruutu
     */
    public TapahtumaAlue(int x, int y, Ruutu[][] pelilauta, Ruutu ruutu) {
        super(x, y, 24, 24);
        this.ruudut = pelilauta;
        this.ruutu = ruutu;
    }
    
    /**
     *Tarkistaa onko alueeseen klikattu ja toimii sen mukaan
     * 
     * @param x
     * @param y
     */
    public void alueeseenKlikattu(int x, int y){
        if(ruutu==null){
            return;
        }
        if(!ruutu.getOnkoRuutuNakyva()){
            ruutu.setOnkoRuutuNakyva(true);
            //muuta kuva?
        }
    }

}
