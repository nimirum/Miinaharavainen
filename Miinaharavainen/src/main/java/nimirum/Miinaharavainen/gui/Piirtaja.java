package nimirum.Miinaharavainen.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
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
        int viive = 1000; //millisekunteja
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        new Timer(viive, taskPerformer).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRuudut(g);
        piirraKello(g);
        piirraGameOver(g);
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
        int leveys = (int) (0.15*miinaharava.getPelilauta().getX()*miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus());
        int korkeus = miinaharava.getPelilauta().getY() * miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();
        
        g.drawString(miinaharava.getKello().toString(),leveys , korkeus + 24);
    }

    private void piirraGameOver(Graphics g) {
        
        int leveys = (int) (0.3*miinaharava.getPelilauta().getX()*miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus());
        int korkeus = miinaharava.getPelilauta().getY() * miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();
        
        if (miinaharava.getGameOver() != null) {
            if (miinaharava.getGameOver().equals("Voitto")) {
                g.drawString("Voitit pelin!", leveys, korkeus + 24);
            }
            if (miinaharava.getGameOver().equals("Havio")) {
                g.drawString("Hävisit pelin.", leveys, korkeus + 24);
            }
        }
    }

}
