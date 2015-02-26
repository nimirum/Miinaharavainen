package nimirum.Miinaharavainen;

import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;

/**
 * Main
 *
 * @author nimirum
 */
public class Main {

    /**
     * Käyttöliittymän käynnistys
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());

        // EnnatystenKasittelija ks = new EnnatystenKasittelija();
//        Properties properties = System.getProperties();
//              for (String key : properties.stringPropertyNames()) {
//                    String value = properties.getProperty(key);
//                    System.out.println(key + " => " + value);
//                }
    }
}
