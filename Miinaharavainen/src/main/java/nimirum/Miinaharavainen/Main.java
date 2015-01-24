/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen;

import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nexu770
 */
public class Main {
    
    public static void main(String[] args) {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        miinaharava.miinoitaLauta();
        miinaharava.tulostaLauta();
    }
}
