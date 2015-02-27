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
 * Käsittelee ennatysten lukemisen ja lisäämisen
 *
 * @author nimirum
 */
public class EnnatystenKasittelija {

    private File tiedosto;
    private Properties properties;
    private InputStream input;
    private OutputStream output;
    private ArrayList<Ennatys> ennatykset;

    public EnnatystenKasittelija() {
        tiedosto = new File("ennatykset/ennatykset.txt");
        properties = new Properties();
        try {
            if (!tiedosto.isFile() && !tiedosto.canRead()) {
                tiedosto.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(EnnatystenKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            input = new FileInputStream(tiedosto);
            properties.load(input);
            output = new FileOutputStream(tiedosto);
            input.close();
        } catch (Exception ex) {
            Logger.getLogger(EnnatystenKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }

        ennatykset = ennatyksetArrayListiin();
    }

    public void lisaaEnnatys(String nimi, int aika, String pelilauta) {
        ennatykset.add(new Ennatys(nimi, aika, pelilauta));
        Collections.sort(ennatykset);
        if (ennatykset.size() > 10) {
            for (int i = 10; ennatykset.size() > i; i++) {
                ennatykset.remove(i);
            }
        }
        lisaaEnnatyksetMuistiin();
    }

    private ArrayList<Ennatys> ennatyksetArrayListiin() {
        ArrayList<Ennatys> list = new ArrayList<>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            String[] osat = value.split(" - ");
            list.add(new Ennatys(osat[0], Integer.parseInt(osat[1]), osat[2]));
        }

        ennatykset = list;
        return list;
    }

    public ArrayList<Ennatys> getEnnatykset() {
        return ennatykset;
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
            //  System.out.println(ennatykset.get(i).toString());
        }
        try {
            properties.store(output, null);
            //   properties.store(output, "Pelin ennatykset");
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(EnnatystenKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void suljeKasittelija() {
        lisaaEnnatyksetMuistiin();
        try {
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(EnnatystenKasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
