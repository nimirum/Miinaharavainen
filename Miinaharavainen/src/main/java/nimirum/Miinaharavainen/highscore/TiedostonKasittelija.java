/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.highscore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nimirum
 */
public class TiedostonKasittelija {

    private File tiedosto;
    private Properties properties;
    private InputStream input;
    private OutputStream output;
    private ArrayList<Ennatys> ennatykset;

    public TiedostonKasittelija() {
        tiedosto = new File("ennatykset/ennatykset.txt");
        try {
            if (tiedosto.createNewFile()) {
                // System.out.println("File is created!");
            } else {
                // System.out.println("File already exists.");
            }
        } catch (IOException ex) {
            Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }

        properties = new Properties();
        try {
            input = new FileInputStream(tiedosto);
            // input.close();
        } catch (Exception ex) {
            Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (input != null) {
            try {
                properties.load(input);

                output = new FileOutputStream(tiedosto);
            } catch (IOException ex) {
                Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ennatykset = ennatyksetArrayListiin();

    }

    public void lisaaEnnatys(String nimi, int aika, String pelilauta) {
        ArrayList<Ennatys> list = ennatyksetArrayListiin();
        list.add(new Ennatys(nimi, aika, pelilauta));
        Collections.sort(list);
        ennatykset = list;
        lisaaEnnatyksetMuistiin();
    }

    public ArrayList<Ennatys> ennatyksetArrayListiin() {
        ArrayList<Ennatys> list = new ArrayList<>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            String[] osat = value.split(" - ");
            list.add(new Ennatys(osat[0], Integer.parseInt(osat[1]), osat[2]));
        }
        Collections.sort(list);
        ennatykset = list;
        return list;
    }

    public void lisaaEnnatyksetMuistiin() {
        int loopsize;
        if (ennatykset.size() < 10) {
            loopsize = ennatykset.size();
        } else {
            loopsize = 10;
        }
        for (int i = 0; i < loopsize; i++) {
            properties.put("" + i, ennatykset.get(i).toString());
        }
        try {
            properties.store(output, "Pelin ennatykset");

        } catch (IOException ex) {
            Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void suljeKasittelija() {
        try {
            input.close();
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
