package nimirum.Miinaharavainen.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private BufferedImage miinaRuutuRikki;
    private BufferedImage numeroRuutuYksi;
    private BufferedImage tyhjaRuutu;

    /**
     * Lataa kaikki ennalta määritellyt kuvat käytettäväksi
     */
    public KuvienLataaja() {
        try {
            ulkoRuutu = ImageIO.read(new File("graphics/tile24x24.png"));
            miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
            miinaRuutuRikki = ImageIO.read(new File("graphics/brokenMine24x24.png"));
            tyhjaRuutu = ImageIO.read(new File("graphics/empty24x24.png"));
            liputettuRuutu = ImageIO.read(new File("graphics/flagtile24x24.png"));
            numeroRuutuYksi = ImageIO.read(new File("graphics/one24x24.png")); //KESKEN
        } catch (IOException ex) {
            System.out.println("Kuvien lataus epäonnistui");
        }
    }

    /**
     * Kuvien kutsumismetodi, palauttaa halutun kuvan
     *
     * @param name Halutunlaisen ruudun nimi
     * @return
     */
    public BufferedImage GetImage(String name) {
        switch (name) {
            case "Tile":
                return ulkoRuutu;
            case "Mine":
                return miinaRuutu;
            case "BrokenMine":
                return miinaRuutuRikki;
            case "Flag":
                return liputettuRuutu;
            case "Empty":
                return tyhjaRuutu;
            case "1":
                return numeroRuutuYksi;
            default:
                return numeroRuutuYksi;
        }

    }
}
