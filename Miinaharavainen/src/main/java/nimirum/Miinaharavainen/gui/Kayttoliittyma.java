package nimirum.Miinaharavainen.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Luokka hallitsee käyttöliittymän elementtejä ja käynnistää pelin
 *
 * @author nimirum
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Miinaharavainen miinaharava;
    private JButton taulukko[][];
    private int ruudunLeveys;
    private int ruudunKorkeus;

    /**
     * Kayttoliittyma luo pelin Miinaharavan
     *
     * @param miinaharava
     */
    public Kayttoliittyma(Miinaharavainen miinaharava) {
        this.miinaharava = miinaharava;
        ruudunLeveys = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
    }

    @Override
    public void run() {

        frame = new JFrame("Miinaharavainen");

        int leveys = ((miinaharava.getPelilauta().getX()) * ruudunLeveys) + 18;
        int korkeus = ((miinaharava.getPelilauta().getY()) * ruudunKorkeus) + 45;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo käyttöliittymään kuuluvat elementit, eli piirtoalustan
     *
     * @param container
     */
    public void luoKomponentit(Container container) {
        Piirtaja piirtoalusta = new Piirtaja(miinaharava);

        lisaaKuuntelija(piirtoalusta);

        container.add(piirtoalusta);
    }

    private void lisaaKuuntelija(Piirtaja piirtaja) {
        Klikkaustenkuuntelija kuuntelija = new Klikkaustenkuuntelija(piirtaja, luoTapahtumaAlueet());
        piirtaja.addMouseListener(kuuntelija);
    }

    private ArrayList luoTapahtumaAlueet() {
        Sijainnit sijainnit = new Sijainnit(miinaharava);
        ArrayList list = sijainnit.TapahtumaAlueet();
        return list;
    }

    /**
     * Palauttaa ikkunan
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}
