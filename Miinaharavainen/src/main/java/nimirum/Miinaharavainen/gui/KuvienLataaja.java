
package nimirum.Miinaharavainen.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Lataa pelin kuvat, jotka ovat kokoa 24x24
 *
 * @author nimirum
 */
public class KuvienLataaja {

    private BufferedImage ulkoRuutu;
    private BufferedImage liputettuRuutu;
    private BufferedImage miinaRuutu;
    private BufferedImage numeroRuutu;
    private BufferedImage tyhjaRuutu;

    public KuvienLataaja() {
        try {
            ulkoRuutu = ImageIO.read(new File("graphics/tile24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        try {
            miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        try {
            tyhjaRuutu = ImageIO.read(new File("graphics/empty24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        try {
            liputettuRuutu = ImageIO.read(new File("graphics/flagtile24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        try {
            numeroRuutu = ImageIO.read(new File("graphics/empty24x24.png")); //KESKEN
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
    }

    public BufferedImage GetImage(String name) {
        switch (name) {
            case "Tile":
                return ulkoRuutu;
            case "Mine":
                return miinaRuutu;
            case "Flag":
                return liputettuRuutu;
            case "Empty":
                return tyhjaRuutu;
            default:
                return ulkoRuutu;
        }

    }
}
