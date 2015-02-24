package nimirum.Miinaharavainen.kuuntelijat;

import java.awt.List;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import nimirum.Miinaharavainen.gui.Piirtaja;
import nimirum.Miinaharavainen.gui.TapahtumaAlue;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Kuuntelee käyttäjän hiirenklikkauksia
 *
 * @author nimirum
 */
public class KlikkaustenKuuntelija extends MouseInputAdapter {

    private Piirtaja piirtaja;
    private ArrayList<TapahtumaAlue> tapahtumaalueet;

    /**
     * Konstruktori
     * @param piirtaja
     * @param tapahtumaAlueet
     */
    public KlikkaustenKuuntelija(Piirtaja piirtaja, ArrayList tapahtumaAlueet) {
        //    this.miinaharavainen = miinaharavainen;
        this.piirtaja = piirtaja;
        tapahtumaalueet = tapahtumaAlueet;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            for (TapahtumaAlue alue : tapahtumaalueet) {
                alue.alueeseenKlikattu(e.getX(), e.getY());
            }
        } if (SwingUtilities.isRightMouseButton(e)){
            for (TapahtumaAlue alue : tapahtumaalueet) {
                alue.alueenLiputus(e.getX(), e.getY());
            }
        }
        piirtaja.repaint();
    }

}
