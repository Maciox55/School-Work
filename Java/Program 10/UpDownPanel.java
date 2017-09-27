import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class UpDownPanel here.
 * 
 * @author (your name) Maciej Bregisz
 * @version (a version number or a date) 
 */
public  class UpDownPanel extends JPanel 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("UP DOWN COUNTER");  //creates a java frame
        JButton upB = new JButton("Count Up");  //creates a new button object  with the text specified insisde
        JButton downB = new JButton("Count Down");   //creates a new button object  with the text specified insisde
        JButton clearB = new JButton("Clear");   //creates a new button object  with the text specified insisde
        JLabel text = new JLabel("Count:");    //creates a new label for the total count of presses
        UpDownCounter counter = new UpDownCounter(upB, downB, clearB, text);    //creates the object that containes the counting methods and event listener
        upB.addActionListener(counter); //adds overriden event listener to the button.
        downB.addActionListener(counter);   //adds overriden event listener to the button. 
        clearB.addActionListener(counter);  //adds overriden event listener to the button. 
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //sets the function of the close button of the window
        
        JPanel panel = new JPanel();    //creates a new instance of panel in which all elements will live
        panel.setBackground(Color.gray);    //sets the panel background to gray
        panel.setPreferredSize(new Dimension(400, 200));    //sets the window size
       
        panel.add(upB); //adds the up button to the panel
        panel.add(downB);   //adds the down button to the panel
        panel.add(clearB);  //adds the clear button to the panel
        panel.add(text);    //adds the text label to the panel 
        frame.getContentPane().add(panel);  //'places' the panel inside the frame
        frame.pack();   //packs the frame
        
        frame.setVisible(true); //sets the frame visible so that its content is visible
        
    }
}
