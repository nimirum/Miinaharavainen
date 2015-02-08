/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Poistaa miinaharavapelin ruutuja
 *
 * @author nimirum
 */
public class RuutujenPoistaja implements ActionListener{
 
    private JButton taulukko[][];
    private JButton nappi;

    public RuutujenPoistaja(JButton[][] taulukko) {
        this.taulukko = taulukko;
    }
    
    public RuutujenPoistaja(JButton nappi) {
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //poista nappi
    }
    
    
}
