/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author nimirum
 */
public class EnnatyksetIkkuna implements Runnable {

    private JFrame frame;
    private JPanel controlPanel;
    private final Miinaharavainen miinaharavainen;

    public EnnatyksetIkkuna(Miinaharavainen miinaharavainen) {
        this.miinaharavainen = miinaharavainen;
    }

    private void prepareGUI() {
        frame = new JFrame("Ennatykset");
        frame.setSize(200, 160);
        frame.setLayout(new GridLayout(1, 1));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                frame.setVisible(false);
                frame.dispose();
            }
        });

        centreWindow();
        setIconImage();
        controlPanel = new JPanel();
        controlPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        controlPanel.setLayout(new FlowLayout());

        frame.add(controlPanel);
        frame.setVisible(true);
    }

    private void setIconImage() {
        BufferedImage miinaRuutu = null;
        try {
            miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
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
        ArrayList<Ennatys> list = miinaharavainen.getKasittelija().ennatyksetArrayListiin();

        JLabel tulos = new JLabel(list.get(0).toString());
        controlPanel.add(tulos);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        prepareGUI();
        showText();
    }

}
