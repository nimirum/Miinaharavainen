/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nimirum
 */
public class NappuloidenKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;

    public NappuloidenKuuntelija(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Uusi peli")) {
            Miinaharavainen miinaharava = new Miinaharavainen(15, 15);
            kayttoliittyma.uusiPeli(miinaharava);
        }
    }

}
