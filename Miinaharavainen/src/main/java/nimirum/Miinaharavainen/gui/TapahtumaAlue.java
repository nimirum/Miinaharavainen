package nimirum.Miinaharavainen.gui;

import java.awt.Rectangle;
import nimirum.Miinaharavainen.logiikka.Ruutu;

/**
 *
 * @author nimirum
 */
public class TapahtumaAlue extends Rectangle {

    private Ruutu[][] ruudut;
    private Ruutu ruutu;

    public TapahtumaAlue(int x, int y, Ruutu[][] pelilauta, Ruutu ruutu) {
        super(x, y, 24, 24);
        this.ruudut = pelilauta;
        this.ruutu = ruutu;
    }
    
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
