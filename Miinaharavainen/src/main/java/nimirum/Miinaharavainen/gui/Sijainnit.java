package nimirum.Miinaharavainen.gui;

import java.util.ArrayList;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Luo Tapahtumalueet ja niiden koordinaatit
 * @author nimirum
 */
public class Sijainnit {

    private final Miinaharavainen harava;
    private final int ruudunLeveys;
    private final int ruudunKorkeus;

    /**
     * Konstruktori
     * @param miinaharava
     */
    public Sijainnit(Miinaharavainen miinaharava) {
        this.harava = miinaharava;
        ruudunLeveys = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
    }

    /**
     *
     * @return Lista tapahtuma-alueista
     */
    public ArrayList tapahtumaAlueet() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < harava.getPelilauta().getX() * ruudunLeveys; i = i + ruudunLeveys) {
            for (int j = 0; j < harava.getPelilauta().getY() * ruudunKorkeus; j = j + ruudunKorkeus) {
                TapahtumaAlue alue = new TapahtumaAlue(i, j, harava.getPelilauta().getRuutu(i / ruudunLeveys, j / ruudunKorkeus), harava);
                list.add(alue);
            }
        }
        return list;
    }

}
