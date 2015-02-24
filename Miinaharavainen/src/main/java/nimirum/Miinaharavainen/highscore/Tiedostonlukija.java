/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nimirum
 */
public class Tiedostonlukija {

    File tiedosto;
    Scanner lukija;
    PrintWriter writer;

    public Tiedostonlukija() {
        tiedosto = new File("src/main/java/nimirum/Miinaharavainen/highscore/ennatykset.txt");
        try {
            lukija = new Scanner(tiedosto);
            writer = new PrintWriter(tiedosto);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedoston haku epäonnistui");
        }
    }

    public ArrayList<Ennatys> ennatyksetArrayListiin() {
        ArrayList<Ennatys> list = new ArrayList<>();

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" - ");
            list.add(new Ennatys(osat[0], Integer.parseInt(osat[1])));
        }
        return list;
    }

    public void uudelleenKirjoitaEnnatykset(ArrayList<Ennatys> ennatykset) {
        int forArvo = ennatykset.size();
        if (forArvo > 10) {
            forArvo = 10;
        }
        for (int i = 0; i < forArvo; i++) {
            writer.print(ennatykset.get(i).toString());
        }
    }

    public void tulostaEnnatykset() {
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println(rivi);
        }
    }

    public void suljeKasittelija() {
        writer.close();
        lukija.close();
    }
}
