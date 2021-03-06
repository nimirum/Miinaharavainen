package nimirum.Miinaharavainen.gui;

import nimirum.Miinaharavainen.kuuntelijat.NappuloidenKuuntelija;
import nimirum.Miinaharavainen.kuuntelijat.KlikkaustenKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.*;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Luokka hallitsee käyttöliittymän ikkunoita ja käynnistää pelin
 *
 * @author nimirum
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Miinaharavainen miinaharava;
    private final int ruudunLeveys;
    private final int ruudunKorkeus;

    /**
     * Kayttoliittyma luo ensimmäisellä käynnistys kerralla 15x10 kokoisen
     * Miinaharavan pelin
     *
     */
    public Kayttoliittyma() {
        this.miinaharava = new Miinaharavainen(15, 10);
        ruudunLeveys = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();
    }

    /**
     * Käyttöliittymä luo parametrien kokoisen Miinaharava pelin
     *
     * @param x Pelilaudan korkeus
     * @param y Pelilaudan leveys
     */
    public Kayttoliittyma(int x, int y) {
        this.miinaharava = new Miinaharavainen(x, y);
        ruudunLeveys = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunLeveys();
        ruudunKorkeus = miinaharava.getPelilauta().getRuutu(0, 0).getRuudunKorkeus();
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharavainen");

        int leveys = ((miinaharava.getPelilauta().getX()) * ruudunLeveys);
        int korkeus = ((miinaharava.getPelilauta().getY()) * ruudunKorkeus + 60);
        //60 pikseliä tilaa kellolle ja pelin päättymis tiedoille

        frame.setResizable(false);
        frame.setVisible(true);
        centreWindow();

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                miinaharava.getKasittelija().suljeKasittelija();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
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

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 3);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 3);
        frame.setLocation(x, y);
    }

    private ArrayList luoTapahtumaAlueet() {
        Sijainnit sijainnit = new Sijainnit(miinaharava, this);
        ArrayList list = sijainnit.tapahtumaAlueet();
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

        NappuloidenKuuntelija kuuntelija = new NappuloidenKuuntelija(this, miinaharava);
        uusiPeli.addActionListener(kuuntelija);
        vaihdaKokoa.addActionListener(kuuntelija);
        ennatykset.addActionListener(kuuntelija);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Miinaharavainen getMiinaharava() {
        return miinaharava;
    }

    /**
     * Luo uuden tyhjän Miinaharava pelin
     *
     * @param x
     * @param y
     */
    public void uusiPeli(int x, int y) {
        miinaharava.getKasittelija().suljeKasittelija();
        this.miinaharava = new Miinaharavainen(x, y);
        Container c = frame.getContentPane();
        c.removeAll();
        luoKomponentit(c);
        frame.setVisible(true);
    }

    private void setIconImage() {
        BufferedImage miinaRuutu = null;
        try {
            miinaRuutu = ImageIO.read(new File("graphics/icon24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvien lataus epäonnistui");
        }
        frame.setIconImage(miinaRuutu);
    }

    /**
     * Sulkee käyttöliittymän ikkunan
     */
    public void sulje() {
        miinaharava.getKasittelija().suljeKasittelija();
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * "Asetukset" nappulan komento joka avaa kokoa kysyvän ikkunan
     */
    public void kysyKokoa() {
        frame.setEnabled(false);
        SwingUtilities.invokeLater((Runnable) new KoonAsettaminen(miinaharava.getPelilauta().getX(), miinaharava.getPelilauta().getY(), this));
    }

    /**
     * "Enätykset" nappulan komento joka avaa ennätykset näyttävän ikkunan
     */
    public void avaaEnnatykset() {
        frame.setEnabled(false);
        SwingUtilities.invokeLater((Runnable) new EnnatyksetIkkuna(miinaharava, this));
    }

    /**
     * Pelin voittamisen jälkeen avautuu ikkuna, missä voi tallentaa tuloksensa
     */
    public void ennatyksenTallentaminen() {
        frame.setEnabled(false);
        SwingUtilities.invokeLater((Runnable) new EnnatyksenTallentaminen(miinaharava, this));
    }

}
