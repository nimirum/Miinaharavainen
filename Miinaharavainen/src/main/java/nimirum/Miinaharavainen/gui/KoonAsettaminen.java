
package nimirum.Miinaharavainen.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author nexu770
 */
public class KoonAsettaminen implements Runnable{
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public KoonAsettaminen(){
      }

//   public static void main(String[] args){
//      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
//      swingControlDemo.showTextFieldDemo();
//   }

   private void prepareGUI(){
      mainFrame = new JFrame("Miinaharvainen");
      mainFrame.setSize(200,250);
      mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(200, 350);
      centreWindow();
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 3);
        int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 3);
        mainFrame.setLocation(x, y);
    }
   private void showTextFieldDemo(){
      headerLabel.setText("Aseta uuden pelin koko:"); 

      JLabel leveyslaatikko= new JLabel("Leveys: ", JLabel.RIGHT);
      JLabel korkeuslaatikko = new JLabel("Korkeus: ", JLabel.CENTER);
      final JTextField leveysText = new JTextField(6);
      final JTextField korkeusText = new JTextField(6);      

      JButton loginButton = new JButton("Aseta");
      loginButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {     
            String data = "Username " + leveysText.getText();
            data += ", Password: " 
            + korkeusText.getText(); 
            statusLabel.setText(data);        
         }
      }); 

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
      showTextFieldDemo();
      mainFrame.toFront();
      mainFrame.repaint();
   }
}

