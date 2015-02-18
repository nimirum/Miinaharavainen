package nimirum.Miinaharavainen.gui;

import java.awt.Image;
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
     * @param x sijainti
     * @param y sijainti
     * @param pelilauta
     * @param ruutu
     */
    public TapahtumaAlue(int x, int y, Ruutu ruutu) {
        super(x, y, 24, 24);
        //this.ruudut = pelilauta;
        this.ruutu = ruutu;
    }
    
//    private int RuudunKorkeusKayttoliittymassa(){
//       kuvat.GetImage("Tile").getTileHeight();
//    }
    
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
            //muuta kuva? eli repaint?
        }
    }

}
