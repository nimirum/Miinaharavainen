/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;


/**
 *
 * @author nexu770
 */
public class Kayttoliittyma implements Runnable{
    
     private JFrame frame;
     private Miinaharavainen miinaharava;

    public Kayttoliittyma(Miinaharavainen miinaharava) {
        this.miinaharava = miinaharava;
    }
     
     @Override
    public void run() {
        frame = new JFrame("Matopeli");
        int leveys = (miinaharava.getPelilauta().getX() +1) +10;
        int korkeus = (miinaharava.getPelilauta().getY() +2 )+10;
 
        frame.setPreferredSize(new Dimension(leveys, korkeus));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
      //  luoKomponentit(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }
 
//    public void luoKomponentit(Container container) {
//        piirtoalusta = new Piirtoalusta(matopeli, sivunPituus);
//        container.add(piirtoalusta);
//        frame.addKeyListener(new Nappaimistonkuuntelija( matopeli.getMato()));
//    }
//    public Paivitettava getPaivitettava(){       
//        return piirtoalusta;
//    }
     
    
       public JFrame getFrame() {
        return frame;
    }
}
