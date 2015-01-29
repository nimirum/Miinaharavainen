
package nimirum.Miinaharavainen;

import nimirum.Miinaharavainen.gui.Menu;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nexu770
 */
public class Main {
    
    public static void main(String[] args) {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        miinaharava.miinoitaLauta();
        miinaharava.tulostaLauta();
        
        Menu ex = new Menu();
                ex.setVisible(true);
  }
}
