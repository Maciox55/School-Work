import java.awt.*;
import javax.swing.*;

public class NestedPanels
{
   //-----------------------------------------------------------------
   //  Presents two colored panels nested within a third.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Nested Panels");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Set up first subpanel
      JPanel subPanel1 = new JPanel();
      subPanel1.setPreferredSize(new Dimension(150, 100));
      subPanel1.setBackground(new Color(92,51,23));
      JLabel label1 = new JLabel("Bakers Chocolate");
      subPanel1.add(label1);
      // Set up second subpanel
      JPanel subPanel2 = new JPanel();
      subPanel2.setPreferredSize(new Dimension(150, 100));
      subPanel2.setBackground(new Color(189,183,107));
      JLabel label2 = new JLabel("Dark Khaki");
      subPanel2.add(label2);
      
      // Set up third subpanel
      JPanel subPanel3 = new JPanel();
      subPanel3.setPreferredSize(new Dimension(150, 100));
      subPanel3.setBackground(new Color(255,222,173));
      JLabel label3 = new JLabel("Navajo White");
      subPanel3.add(label3);
      // Set up fourth subpanel
      JPanel subPanel4 = new JPanel();
      subPanel4.setPreferredSize(new Dimension(150, 100));
      subPanel4.setBackground(new Color(238,180,34));
      JLabel label4 = new JLabel("Golden Rod");
      subPanel4.add(label4);

      // Set up primary panel
      JPanel primary = new JPanel();
      primary.setBackground(new Color(153,204,50));
      primary.add(subPanel1);   //Adds first sub panel
      primary.add(subPanel2);   //Adds second sub panel
      primary.add(subPanel3);   //Adds third sub panel
      primary.add(subPanel4);   //Adds fourth sub panel

      frame.getContentPane().add(primary);
      frame.pack();
      frame.setVisible(true);
   }
}

