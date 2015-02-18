package nimirum.Miinaharavainen.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;
import nimirum.Miinaharavainen.logiikka.Ruutu;

/**
 * Luokka piirtää pelikentän ja sen komponentit eli ruudut
 *
 * @author nimirun
 */
public class Piirtaja extends JPanel {

    private KuvienLataaja kuvat;
    private Miinaharavainen miinaharava;

    Piirtaja(Miinaharavainen miinaharava) {
        super.setBackground(Color.white);
        this.kuvat = new KuvienLataaja();
        this.miinaharava = miinaharava;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRuudut(g);
    }

    public void piirraRuudut(Graphics g) {

        for (int i = 0; i < miinaharava.getPelilauta().getX() * 24; i = i + 24) {
            for (int j = 0; j < miinaharava.getPelilauta().getY() * 24; j = j + 24) {
                Ruutu ruutu = miinaharava.getPelilauta().getRuutu(i / 24, j / 24);
                Image kuva = kuvat.GetImage("Tile");
                if (!ruutu.getOnkoRuutuNakyva()) { //eli kun ruutu on false niin ei piirretä
                    if (!ruutu.isOnkoLiputettu()) {
                        kuva = kuvat.GetImage("Tile");
                    } else {
                        kuva = kuvat.GetImage("Flag");
                    }
                } else { //ruutu true
                    if (ruutu.getOnkoMiina()) {
                        kuva = kuvat.GetImage("Mine");
                    }
                    if (!ruutu.getOnkoMiina() && ruutu.getViereistenMiinojenMaara() > 0) {
                        kuva = kuvat.GetImage(String.valueOf(ruutu.getViereistenMiinojenMaara()));
                    }
                    if (!ruutu.getOnkoMiina() && ruutu.getViereistenMiinojenMaara() == 0) {
                        kuva = kuvat.GetImage("Empty");
                    }
                }
                g.drawImage(kuva, i, j, null);
            }
        }
    }

}
