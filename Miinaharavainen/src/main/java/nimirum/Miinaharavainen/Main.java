
package nimirum.Miinaharavainen;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.highscore.EnnatystenKasittelija;
import nimirum.Miinaharavainen.highscore.*;

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
        //SwingUtilities.invokeLater(new Kayttoliittyma());
        EnnatystenKasittelija ks = new EnnatystenKasittelija();
        ks.lisaaEnnatys(new Ennatys("pekka",034));
        ks.tulostaEnnatykset();
  }
}
