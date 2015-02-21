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

    private final KuvienLataaja kuvat;
    private final Miinaharavainen miinaharava;

    Piirtaja(Miinaharavainen miinaharava) {
        super.setBackground(Color.white);
        this.kuvat = new KuvienLataaja();
        this.miinaharava = miinaharava;
//        miinaharava.getKello().setPiirtaja(this);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRuudut(g);
        if (miinaharava.isPelilautaMiinoitettu()) {
            piirraKello(g);
        }
    }

    /**
     * Piirtää kaikki pelilaudan ruudut kuvina
     *
     * @param g Graphics
     */
    public void piirraRuudut(Graphics g) {

        int ruudunKoko = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();

        for (int i = 0; i < miinaharava.getPelilauta().getX() * ruudunKoko; i = i + ruudunKoko) {
            for (int j = 0; j < miinaharava.getPelilauta().getY() * ruudunKoko; j = j + ruudunKoko) {
                Ruutu ruutu = miinaharava.getPelilauta().getRuutu(i / ruudunKoko, j / ruudunKoko);
                Image kuva = kuvat.GetImage("Tile");
                if (!ruutu.getOnkoRuutuNakyva()) { //eli kun ruutu on false niin ei piirretä
                    if (!ruutu.isOnkoLiputettu()) {
                        kuva = kuvat.GetImage("Tile");
                    } else {
                        kuva = kuvat.GetImage("Flag");
                    }
                } else { //ruutu true
                    if (ruutu.getOnkoMiina() && ruutu.isKlikattuMiina()) {
                        kuva = kuvat.GetImage("BrokenMine");
                    }
                    if (ruutu.getOnkoMiina() && !ruutu.isKlikattuMiina()) {
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

    private void piirraKello(Graphics g) {
        g.drawString(miinaharava.getKello().toString(), 50, miinaharava.getPelilauta().getY() * 24 + 50);
    }

}
