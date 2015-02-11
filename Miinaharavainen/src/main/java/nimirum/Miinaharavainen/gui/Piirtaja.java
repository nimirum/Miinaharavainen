/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Luokka piirtää pelikentän
 *
 * @author nimirun
 */
public class Piirtaja extends JPanel {

    private KuvienLataaja kuvat;
    private Miinaharavainen miinaharava;

    Piirtaja(Miinaharavainen miinaharava) {
        super.setBackground(Color.white);
        this.kuvat = new KuvienLataaja();
        this.miinaharava = miinaharava;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRuudut(g);
    }

    private void piirraRuudut(Graphics g) {
        
         for (int i = 0; i < miinaharava.getPelilauta().getX()*24; i=i+24) {
            for (int j = 0; j < miinaharava.getPelilauta().getY()*24; j=j+24) {
                Image kuva = kuvat.GetImage("Tile");
               g.drawImage(kuva, i, j, null);
            }
        }
    }

}