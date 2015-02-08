/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Lataa pelin kuvat
 *
 * @author nexu770
 */
public class KuvienLataaja {

    private BufferedImage ulkoRuutu;
    private BufferedImage liputettuRuutu;
    private BufferedImage miinaRuutu;
    private BufferedImage numeroRuutu;
    private BufferedImage tyhjaRuutu;

    public KuvienLataaja() throws IOException {
        ulkoRuutu = ImageIO.read(new File("graphics/tile24x24.png"));
        miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
        tyhjaRuutu = ImageIO.read(new File("graphics/empty24x24.png"));
        liputettuRuutu = ImageIO.read(new File("graphics/flagtile24x24.png"));
        numeroRuutu = ImageIO.read(new File("graphics/empty24x24.png")); //KESKEN
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
