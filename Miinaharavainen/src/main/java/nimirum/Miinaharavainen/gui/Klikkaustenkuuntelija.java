
package nimirum.Miinaharavainen.gui;

import java.awt.List;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.MouseInputAdapter;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Kuuntelee käyttäjän hiirenklikkauksia
 * @author nimirum
 */
public class Klikkaustenkuuntelija extends MouseInputAdapter {
    
  // private Miinaharavainen miinaharavainen;
    private Piirtaja piirtaja;
    private ArrayList<TapahtumaAlue> tapahtumaalueet;

    /**
     *Konstruktori
     */
  
    public Klikkaustenkuuntelija(Piirtaja piirtaja, ArrayList alueet) {
    //    this.miinaharavainen = miinaharavainen;
        this.piirtaja = piirtaja;
        tapahtumaalueet = alueet;
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        for(TapahtumaAlue alue:tapahtumaalueet){
            alue.alueeseenKlikattu(e.getX(), e.getY());
            
        }
        piirtaja.repaint();
    }

  
}