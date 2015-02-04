package nimirum.Miinaharavainen.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.*;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nexu770
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Miinaharavainen miinaharava;

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

        frame.pack();
        frame.setVisible(true);
        //--Ohjan perus kayttoliittyma

        //setTitle("Miinaharavainen");
        //   setSize(500, 500);
        //  setLocationRelativeTo(null);
    }

    public void luoKomponentit(Container container) {
         container.setLayout(new BorderLayout());
        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem newMenuItem = new JMenuItem("New Game", icon);
        newMenuItem.setMnemonic(KeyEvent.VK_E);
        newMenuItem.setToolTipText("New Game");
       // exitMenuItem.addActionListener(new Klikkaustenkuuntelija() {
        // });
        file.add(newMenuItem);
        //file.add(exitMenuItem);

        menubar.add(file);
        container.add(menubar, BorderLayout.NORTH);
        //setJMenuBar(menubar);
//        //piirtoalusta = new Piirtoalusta(matopeli, sivunPituus);
//       // container.add(piirtoalusta);
        // frame.addMouseListener(new Klikkaustenkuuntelija());
    }
}
