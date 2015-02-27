package nimirum.Miinaharavainen.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Kuuntelee käyttöliittymän menu nappuloiden (Uusipeli, Asetukset, Ennätykset)
 * klikkauksia ja toimii sen mukaan
 *
 * @author nimirum
 */
public class NappuloidenKuuntelija implements ActionListener {

    private final Kayttoliittyma kayttoliittyma;
    private final Miinaharavainen miinaharava;

    /**
     * Konstruktori
     *
     * @param kayttoliittyma
     * @param miinaharava
     */
    public NappuloidenKuuntelija(Kayttoliittyma kayttoliittyma, Miinaharavainen miinaharava) {
        this.kayttoliittyma = kayttoliittyma;
        this.miinaharava = miinaharava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Uusi peli")) {
            kayttoliittyma.uusiPeli(this.miinaharava.getPelilauta().getX(), this.miinaharava.getPelilauta().getY());
        }
        if (e.getActionCommand().equals("Asetukset")) {
            kayttoliittyma.kysyKokoa();
        }
        if (e.getActionCommand().equals("Ennätykset")) {
            kayttoliittyma.avaaEnnatykset();
        }
    }

}
