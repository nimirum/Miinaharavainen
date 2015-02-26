/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimirum.Miinaharavainen.highscore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nimirum
 */
public class TiedostonKasittelija {

    File tiedosto;
    Properties properties;
    InputStream input;
    OutputStream output;
    Scanner lukija;
    PrintWriter writer;

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
//                System.out.println("Size:" + properties.size());
//                for (String key : properties.stringPropertyNames()) {
//                    String value = properties.getProperty(key);
//                    System.out.println(key + " => " + value);
//                }
                output = new FileOutputStream(tiedosto);
            } catch (IOException ex) {
                Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void lisaaEnnatys(String ennatys) {

        properties.put("jotain2", "kivaa2");
        properties.put("jotain1", "kivaa1");
        try {
            properties.store(output, "Pelin ennatykset");

        } catch (IOException ex) {
            Logger.getLogger(TiedostonKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Ennatys> ennatyksetArrayListiin() {
        ArrayList<Ennatys> list = new ArrayList<>();

        // String[] osat = rivi.split("-");
        //list.add(new Ennatys(osat[0], Integer.parseInt(osat[1])));
        return list;
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
