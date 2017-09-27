import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class UpDownCounter here.
 * 
 * @author (your name) Maciej Bregisz
 * @version (a version number or a date)
 */
public class UpDownCounter implements ActionListener
{
    private JButton upB, downB, clearB; 
    private JLabel textl;
    private int count;
    public UpDownCounter(JButton up,JButton down,JButton clear,JLabel text){    //Listener object constructor
        textl = text;
        upB = up;
        downB = down;
        clearB = clear;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == upB)    //checks if event source is the same as the reference this object holds
        {
            count++;    //adds one to the counter everytime the count up button is pressed
            textl.setText("Count: " + count);   //sets the text insite the counter label to current counter value
        }
        
        if(event.getSource() == downB)
        {
            count--;    //subtracts one to the counter everytime the count down button is pressed
            textl.setText("Count: " + count);   //sets the text insite the counter label to current counter value
        }
        if(event.getSource() == clearB)
        {
            count = 0;  //clears the counter everytime the clear button is pressed
            textl.setText("Count: " + count);   //sets the text insite the counter label to current counter value
        }
        
        
    }
}
