package nimirum.Miinaharavainen.gui;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

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
    //private KuvienLataaja kuvat;

    /**
     *Kayttoliittyma luo pelin Miinaharavan 
     * @param miinaharava
     */
  
   public Kayttoliittyma(Miinaharavainen miinaharava) {
        this.miinaharava = miinaharava;
    }
    
    

    @Override
    public void run() {
        
        frame = new JFrame("Miinaharavainen");
        int leveys = ((miinaharava.getPelilauta().getX())) * 24;
        int korkeus = ((miinaharava.getPelilauta().getY())) * 24 ;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
           Piirtaja piirtoalusta = new Piirtaja(miinaharava);
           
           container.add(piirtoalusta);
    }
    
      public JFrame getFrame() {
        return frame;
    }
}
