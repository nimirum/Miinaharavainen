
package nimirum.Miinaharavainen;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.gui.Menu;
import nimirum.Miinaharavainen.gui.NewJFrame;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nexu770
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        miinaharava.miinoitaLauta();
       // miinaharava.tulostaLauta();
         
        Kayttoliittyma katis = new Kayttoliittyma(miinaharava);
        SwingUtilities.invokeLater(katis);
      //  NewJFrame ex = new NewJFrame();
      //          ex.setVisible(true);
  }
}
