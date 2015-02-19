
package nimirum.Miinaharavainen;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nimirum
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Kayttoliittyma katis = new Kayttoliittyma(new Miinaharavainen(20, 10));
        SwingUtilities.invokeLater(katis);
  }
}
