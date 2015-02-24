/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.highscore;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nimirum
 */
public class EnnatystenKasittelija {

    private final ArrayList<Ennatys> ennatykset;
    private final Tiedostonlukija lukija;

    public EnnatystenKasittelija() {
        lukija = new Tiedostonlukija();      
        ennatykset = lukija.ennatyksetArrayListiin();
    }
    
    public void lisaaEnnatys(Ennatys ennatys){
        ennatykset.add(ennatys);
        Collections.sort(ennatykset);
        lukija.uudelleenKirjoitaEnnatykset(ennatykset);
    }
    
    public void tulostaEnnatykset(){
        lukija.tulostaEnnatykset();
    }

}
