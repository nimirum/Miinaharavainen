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
    private final String pelilauta;

    public Ennatys(String pelaaja, int aika, String pelilauta) {
        this.pelaaja = pelaaja;
        this.aika = aika;
        this.pelilauta = pelilauta;
    }

    public int getAika() {
        return aika;
    }

    public String getPelilauta() {
        return pelilauta;
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
        return getPelaaja() + " - " + getAika() + " - " + getPelilauta();
    }

}
