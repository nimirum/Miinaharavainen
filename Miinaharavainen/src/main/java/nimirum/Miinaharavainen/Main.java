
package nimirum.Miinaharavainen;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;

/**
 * Main
 * @author nimirum
 */
public class Main {
    
    /**
     * Käyttöliittymän käynnistys
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());
  }
}
