/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.highscore;

/**
 *
 * @author nimirum
 */
public class Ennatys implements Comparable<Ennatys> {

    private final String pelaaja;
    private final int aika;

    public Ennatys(String pelaaja, int aika) {
        this.pelaaja = pelaaja;
        this.aika = aika;
    }

    public int getAika() {
        return aika;
    }

    public String getPelaaja() {
        return pelaaja;
    }

    @Override
    public int compareTo(Ennatys ennatys) {
        return ennatys.getAika() - this.aika;
    }

    @Override
    public String toString() {
        return this.pelaaja + " - " + this.aika;
    }

}
