
package nimirum.Miinaharavainen.gui;

import java.awt.List;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Kuuntelee käyttäjän hiirenklikkauksia
 * @author nimirum
 */
public class Klikkaustenkuuntelija extends MouseInputAdapter {
    
    private Miinaharavainen miinaharavainen;
    private Piirtaja piirtaja;
    //private List<TapahtumaAlue> tapahtumaalueet;

    /**
     *Konstruktori
     */
    public Klikkaustenkuuntelija() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); 
    }

  
}