
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
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        miinaharava.miinoitaLauta();
        //miinoittaminen pitäisi siirtää käyttöliittymään jossain vaiheessa
         
        Kayttoliittyma katis = new Kayttoliittyma(miinaharava);
        SwingUtilities.invokeLater(katis);
  }
}
