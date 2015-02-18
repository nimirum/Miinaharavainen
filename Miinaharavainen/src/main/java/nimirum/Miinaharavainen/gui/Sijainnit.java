package nimirum.Miinaharavainen.gui;

import java.util.ArrayList;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nimirum
 */
public class Sijainnit {

    private Miinaharavainen harava;
    private int ruudunLeveys;
    private int ruudunKorkeus;

    public Sijainnit(Miinaharavainen harava) {
        this.harava = harava;
             ruudunLeveys = harava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = harava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
    }

    public ArrayList TapahtumaAlueet() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < harava.getPelilauta().getX() * ruudunLeveys; i = i + 24) {
            for (int j = 0; j < harava.getPelilauta().getY() * ruudunKorkeus; j = j + 24) {
                TapahtumaAlue alue = new TapahtumaAlue(i, j, harava.getPelilauta().getRuutu(i / ruudunLeveys, j / ruudunKorkeus),harava);
                list.add(alue);
            }
        }
        return list;
    }

}
