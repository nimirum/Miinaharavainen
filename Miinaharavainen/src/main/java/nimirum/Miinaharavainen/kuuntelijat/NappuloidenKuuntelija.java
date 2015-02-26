/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Kuuntelee käyttöliittymän menu nappuloiden toimintaa
 * 
 * @author nimirum
 */
public class NappuloidenKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;
    private Miinaharavainen miinaharava;

    /**
     * Konstruktori
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
            Miinaharavainen miinaharava = new Miinaharavainen(this.miinaharava.getPelilauta().getX(), this.miinaharava.getPelilauta().getY());
            kayttoliittyma.uusiPeli(miinaharava);
           // miinaharava.uusiPeli();
        }
        if (e.getActionCommand().equals("Asetukset")) {
            kayttoliittyma.kysyKokoa();
        }
        if (e.getActionCommand().equals("Ennätykset")) {
            System.out.println("toimii");
            kayttoliittyma.avaaEnnatykset();
        }
    }

}
