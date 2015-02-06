package nimirum.Miinaharavainen.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.*;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Luokka hallistee käyttöliittymän elementtejä ja käynnistää pelin
 *
 * @author nimirum
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Miinaharavainen miinaharava;
    private JButton taulukko[][];

    public Kayttoliittyma(Miinaharavainen miinaharava) {
        this.miinaharava = miinaharava;
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharavainen");
        int leveys = (miinaharava.getPelilauta().getX()) * 100;
        int korkeus = (miinaharava.getPelilauta().getY()) * 100;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        //--Ohjan perus kayttoliittyma

        //Ruutuja
        frame.setLayout(new GridLayout(2, 2));
        taulukko = new JButton[miinaharava.getPelilauta().getX()][miinaharava.getPelilauta().getY()];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton nappula = new JButton(i + ", " + j);
                frame.add(nappula);
            }
        }

        RuutujenPoistaja poistaja = new RuutujenPoistaja(taulukko);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
//                taulukko[i][j].addActionListener(poistaja);
            }
        }
//
//        frame.add(new JButton("Button 2"));
//        frame.add(new JButton("Button 3"));
//        frame.add(new JButton("Button 4"));
//        frame.add(new JButton("Button 5"));
//        frame.add(new JButton("Button 6"));
//        frame.add(new JButton("Button 7"));
//        frame.add(new JButton("Button 8"));
//        frame.add(new JButton("Button 9"));

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        /* Menun kanssa taistelua
        
         JMenuBar menubar = new JMenuBar();
         ImageIcon icon = new ImageIcon("exit.png");

         JMenu file = new JMenu("File");
         file.setMnemonic(KeyEvent.VK_F);

         JMenuItem newMenuItem = new JMenuItem("New Game", icon);
         newMenuItem.setMnemonic(KeyEvent.VK_E);
         newMenuItem.setToolTipText("New Game");
         // newMenuItem.addActionListener(new Klikkaustenkuuntelija() {
         // });
         file.add(newMenuItem);

         menubar.add(file);
         container.add(menubar, BorderLayout.NORTH);
         */

        //Klikkaustenkuuntelija ei toimi vielä
        //frame.addMouseListener(new Klikkaustenkuuntelija());
    }
}
