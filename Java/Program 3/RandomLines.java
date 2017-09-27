import javax.swing.*;
import java.awt.*;
public class RandomLines
{
     public static void main(String[] args)
     {
         JFrame frame = new JFrame("Lines");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(new RandomLinesPanel());
         frame.pack();
         frame.setVisible(true);
     }
}