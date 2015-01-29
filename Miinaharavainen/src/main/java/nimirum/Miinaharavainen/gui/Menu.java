
package nimirum.Miinaharavainen.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author nexu770
 */
public class Menu extends JFrame {

    public Menu() {

        initUI();
    }

    private void initUI() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit", icon);
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");

        JMenuItem newMenuItem = new JMenuItem("New Game", icon);
        newMenuItem.setMnemonic(KeyEvent.VK_E);
        newMenuItem.setToolTipText("New Game");
        exitMenuItem.addActionListener(new Klikkaustenkuuntelija() {
        });
        file.add(newMenuItem);
        file.add(exitMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);

        setTitle("Miinaharavainen");
        setSize(500, 500);
        setLocationRelativeTo(null);

    }
}
