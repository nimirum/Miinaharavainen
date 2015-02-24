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
 *
 * @author nexu770
 */
public class KoonAsettaminen implements Runnable {

    private JFrame mainFrame;
    private JPanel controlPanel;
    private int x;
    private int y;
    private Kayttoliittyma kayttoliittyma;

    public KoonAsettaminen() {
    }

    public KoonAsettaminen(int x, int y, Kayttoliittyma kayttoliittyma) {
        this.x = x;
        this.y = y;
        this.kayttoliittyma = kayttoliittyma;
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Miinaharvainen");
        mainFrame.setSize(200, 160);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        centreWindow();
        setIconImage();
        controlPanel = new JPanel();
        controlPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void setIconImage() {
        BufferedImage miinaRuutu = null;
        try {
            miinaRuutu = ImageIO.read(new File("graphics/mine24x24.png"));
        } catch (IOException ex) {
            System.out.println("Kuvan lataus epäonnistui");
        }
        mainFrame.setIconImage(miinaRuutu);
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 3);
        int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 3);
        mainFrame.setLocation(x, y);
    }

    private void showText() {

        JLabel ohje = new JLabel("Aseta uuden pelin koko:");
        JLabel leveyslaatikko = new JLabel("Leveys: ", JLabel.RIGHT);
        JLabel korkeuslaatikko = new JLabel("Korkeus: ", JLabel.CENTER);
        final JTextField leveysText = new JTextField("" + x, 6);//new JTextField(6);
        final JTextField korkeusText = new JTextField("" + y, 6);

        JButton loginButton = new JButton("Aseta");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //leveysText.getText()
                //korkeusText.getText()
                // statusLabel.setText(data);   
                mainFrame.setVisible(false);
                mainFrame.dispose();
                kayttoliittyma.sulje();
                SwingUtilities.invokeLater(new Kayttoliittyma(10, 10));
            }
        });
        controlPanel.add(ohje);
        controlPanel.add(leveyslaatikko);
        controlPanel.add(leveysText);
        controlPanel.add(korkeuslaatikko);
        controlPanel.add(korkeusText);
        controlPanel.add(loginButton);
        mainFrame.setVisible(true);
    }

    @Override
    public void run() {
        prepareGUI();
        showText();
       // mainFrame.toFront();
        // mainFrame.repaint();
    }
}
