package nimirum.Miinaharavainen.gui;

import java.util.ArrayList;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nimirum
 */
public class Sijainnit {

    private Miinaharavainen harava;
    private int x = 24;
    private int y = 24;

    public Sijainnit(Miinaharavainen harava) {
        this.harava = harava;
    }
    
    public ArrayList TapahtumaAlueet(){
        ArrayList list=new ArrayList();
        for (int i = 0; i < harava.getPelilauta().getX(); i++) {
            for (int j = 0; j < harava.getPelilauta().getY(); j++) {
                TapahtumaAlue alue = new TapahtumaAlue(i+x, j+y,harava.getPelilauta().getRuutu(i, j));
                list.add(alue);
            }
            
        }
        return list;
    }

}
