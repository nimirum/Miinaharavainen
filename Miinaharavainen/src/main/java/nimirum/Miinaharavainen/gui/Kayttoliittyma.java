package nimirum.Miinaharavainen.gui;

import nimirum.Miinaharavainen.kuuntelijat.NappuloidenKuuntelija;
import nimirum.Miinaharavainen.kuuntelijat.KlikkaustenKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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
    private final int ruudunLeveys;
    private final int ruudunKorkeus;

    /**
     * Kayttoliittyma luo pelin Miinaharavan
     *
     */
    public Kayttoliittyma() {
        this.miinaharava = new Miinaharavainen(15, 15);
        ruudunLeveys = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharavainen");

        int leveys = ((miinaharava.getPelilauta().getX()) * ruudunLeveys);
        int korkeus = ((miinaharava.getPelilauta().getY()) * ruudunKorkeus + 60);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(leveys + frame.getInsets().left + frame.getInsets().right, korkeus + frame.getInsets().top + frame.getInsets().bottom));
        setIconImage();
        luoValikko();
        luoKomponentit(frame.getContentPane());

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
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(piirtaja, luoTapahtumaAlueet());
        piirtaja.addMouseListener(kuuntelija);
    }

    private ArrayList luoTapahtumaAlueet() {
        Sijainnit sijainnit = new Sijainnit(miinaharava);
        ArrayList list = sijainnit.TapahtumaAlueet();
        return list;
    }

    private void luoValikko() {
        JMenuBar valikko = new JMenuBar();
        frame.setJMenuBar(valikko);
        JMenuItem uusiPeli = new JMenuItem("Uusi peli");
        JMenuItem ennatykset = new JMenuItem("Ennätykset");
        JMenuItem vaihdaKokoa = new JMenuItem("Asetukset");
        valikko.add(uusiPeli);
        valikko.add(vaihdaKokoa);
        valikko.add(ennatykset);

        NappuloidenKuuntelija kuuntelija = new NappuloidenKuuntelija(this,miinaharava);
        uusiPeli.addActionListener(kuuntelija);

        // UusiPeliNappulanKuuntelija kuuntelija = new UusiPeliNappulanKuuntelija(this);
        //uusiPeli.addActionListener(kuuntelija);
    }

    /**
     * Palauttaa ikkunan
     *
     * @return JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    public void uusiPeli(Miinaharavainen miinaharavainen) {
        this.miinaharava = miinaharavainen;
        Container c = frame.getContentPane();
        c.removeAll();
        luoKomponentit(c);
        frame.setVisible(true);
    }

    private void setIconImage() {
        BufferedImage miinaRuutu = null;
        try {
            miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvien lataus epäonnistui");
        }
        frame.setIconImage(miinaRuutu);
    }
}
