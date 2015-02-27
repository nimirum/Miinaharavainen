package nimirum.Miinaharavainen.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nimirum.Miinaharavainen.highscore.Ennatys;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 * Näyttää ikkunan, jossa 0-10 kpl tallennettuja ennätyksiä parhaus
 * järjestyksessä
 *
 * @author nimirum
 */
public class EnnatyksetIkkuna implements Runnable {

    private JFrame frame;
    private JPanel controlPanel;
    private final Miinaharavainen miinaharavainen;
    private final Kayttoliittyma kayttoliittyma;

    public EnnatyksetIkkuna(Miinaharavainen miinaharavainen, Kayttoliittyma kayttoliittyma) {
        this.miinaharavainen = miinaharavainen;
        this.kayttoliittyma = kayttoliittyma;
    }

    private void prepareGUI() {
        frame = new JFrame("");
        frame.setSize(200, 300);
        frame.setLayout(new GridLayout(1, 1));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                kayttoliittyma.getFrame().setEnabled(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        centreWindow();
        setIconImage();
        controlPanel = new JPanel();
        controlPanel.setAlignmentY(Component.LEFT_ALIGNMENT);
        controlPanel.setLayout(new FlowLayout());

        frame.add(controlPanel);
        frame.setVisible(true);
    }

    private void setIconImage() {
        BufferedImage miinaRuutu = null;
        try {
            miinaRuutu = ImageIO.read(new File("graphics/icon24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        frame.setIconImage(miinaRuutu);
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 3);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 3);
        frame.setLocation(x, y);
    }

    private void showText() {
        ArrayList<Ennatys> list = miinaharavainen.getKasittelija().getEnnatykset();
        if (list.size() > 0) {
            for (Ennatys ennatys : list) {
                controlPanel.add(new JLabel((list.indexOf(ennatys) + 1) + ": " + ennatys.tulostaEnnatys()));
                //indexit alkaa nollasta, joten +1
            }
        } else {
            controlPanel.add(new JLabel("Ei vielä ennätyksiä."));
        }
        frame.setVisible(true);
    }

    @Override
    public void run() {
        prepareGUI();
        showText();
    }
}
