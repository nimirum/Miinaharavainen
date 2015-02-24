package nimirum.Miinaharavainen.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Avaa ikkunan, jossa voi muokata pelin asetuksia, eli korkeutta ja leveyttä
 *
 * @author nimirum
 */
public class KoonAsettaminen implements Runnable {

    private JFrame frame;
    private JPanel controlPanel;
    private final int x;
    private final int y;
    private final Kayttoliittyma kayttoliittyma;

    /**
     * Konstruktori
     *
     * @param x
     * @param y
     * @param kayttoliittyma
     */
    public KoonAsettaminen(int x, int y, Kayttoliittyma kayttoliittyma) {
        this.x = x;
        this.y = y;
        this.kayttoliittyma = kayttoliittyma;
    }

    private void prepareGUI() {
        frame = new JFrame("Miinaharvainen");
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

        JLabel ohje = new JLabel("Aseta uuden pelin koko (8-50)");
        JLabel leveyslaatikko = new JLabel("Leveys: ", JLabel.RIGHT);
        JLabel korkeuslaatikko = new JLabel("Korkeus: ", JLabel.CENTER);
        final JTextField leveysText = new JTextField("" + x, 6);
        final JTextField korkeusText = new JTextField("" + y, 6);

        JButton loginButton = new JButton("Aseta");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int leveys = 0;
                int korkeus = 0;
                boolean arvotKelpaavat = false;
                try {
                    leveys = Integer.parseInt(leveysText.getText());
                    korkeus = Integer.parseInt(korkeusText.getText());
                    arvotKelpaavat = true;
                } catch (NumberFormatException ex) {
                    leveysText.setText("");
                    korkeusText.setText("");
                }
                if (arvotKelpaavat) {
                    frame.setVisible(false);
                    frame.dispose();
                    kayttoliittyma.sulje();
                    SwingUtilities.invokeLater(new Kayttoliittyma(leveys, korkeus));
                }
            }
        });
        controlPanel.add(ohje);
        controlPanel.add(leveyslaatikko);
        controlPanel.add(leveysText);
        controlPanel.add(korkeuslaatikko);
        controlPanel.add(korkeusText);
        controlPanel.add(loginButton);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        prepareGUI();
        showText();
    }
}
