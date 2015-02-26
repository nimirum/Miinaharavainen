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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import nimirum.Miinaharavainen.logiikka.Miinaharavainen;

/**
 *
 * @author nimirum
 */
public class EnnatyksenTallentaminen implements Runnable {

    private JFrame frame;
    private JPanel controlPanel;
    private final int x;
    private final int y;
  //  private final Kayttoliittyma kayttoliittyma;
    private Miinaharavainen miinaharavainen;

    /**
     * Konstruktori
     *
     * @param x
     * @param y
     * @param miinaharavainen
     */
    public EnnatyksenTallentaminen(int x, int y, Miinaharavainen miinaharavainen) {
        this.x = x;
        this.y = y;
        this.miinaharavainen = miinaharavainen;
        //  this.kayttoliittyma = kayttoliittyma;
    }

    private void prepareGUI() {
        frame = new JFrame("Ennatys");
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

        JLabel ohje = new JLabel("Tallenna ennätys: ");
        //  JLabel nimilaatikko = new JLabel("Nimi: ", JLabel.RIGHT);
        final JTextField nimitext = new JTextField("Nimi", 8);
        JLabel tulos = new JLabel("Tulos: " + miinaharavainen.getKello().toString() + " - " + miinaharavainen.getPelilauta().toString());

        JButton saveButton = new JButton("Tallenna");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                //kayttoliittyma.getMiinaharava().getKasittelija().lisaaEnnatys(nimitext.getText() + " - " + kayttoliittyma.getMiinaharava().getKello().toString()+" - " + kayttoliittyma.getMiinaharava().getPelilauta().toString());
            }
        });
        controlPanel.add(ohje);
        //  controlPanel.add(nimilaatikko);
        controlPanel.add(nimitext);
        controlPanel.add(tulos);
        controlPanel.add(saveButton);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        prepareGUI();
        showText();
    }
}
