package nimirum.Miinaharavainen;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.highscore.*;

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
