import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *  Maciej Bregisz
 *  I choose to use an additional class because I think it will make the code more scalable, expendable, and modular if changes need to be made in the future.
 *  Creates 200 lines.
 */
public class RandomLinesPanel extends JPanel
{
     public int mincolor, r, g, b, minColor = 40, size ,x1 ,x2, y1,y2, shrink = 1;
     public int nlines = 200;
     public Line[] lines;

     public RandomLinesPanel()
     {
         lines = new Line[nlines];
         Random rand = new Random();

         for(int i = 0; i < nlines; i++)
         {  
             r = rand.nextInt(255 - minColor) + minColor;   //Will produce color value from 40, to 250
             g = rand.nextInt(255 - minColor) + minColor;
             b = rand.nextInt(255 - minColor) + minColor;
             x1 = rand.nextInt(500 - shrink*2) + shrink; //500 is the max direction on each axis, 500 pixels are abailable, and shrink gets smaller everytime the iterator runs, brinking the lines towards the middle;
             y1 = rand.nextInt(500 - shrink*2) + shrink;
             x2 = rand.nextInt(500 - shrink*2) + shrink;
             y2 = rand.nextInt(500 - shrink*2) + shrink;
             shrink = i;    // shrink is the 
             lines[i] = new Line(x1,x2,y1,y2,r,g,b);    // Creates a new Line in specified index of the array of objects of type Line
         }
         setPreferredSize(new Dimension(500, 500));
         //setBackground(Color.White);
     }
     public void paintComponent(Graphics page)
     {
         super.paintComponent(page);
         for(int i = 0; i <lines.length; i++)   //Iterates through the array of objects 
            {
                lines[i].draw(page);    //Calls the method draw that is located in the object.
            }
         }
  
     }
     
class Line //Line class, defines the Line class that stores and contains all neccessary properties to create a line.
{
    private int x1, x2, y1, y2, r, g, b;

     public Line(int tx1, int tx2,int ty1, int ty2, int tr, int tg, int tb) //constuctor
     {
         x1 = tx1;  //setter for objects, assigned on construction
         x2 = tx2; 
         y1 = ty1; 
         y2 = ty2;
         r = tr;
         g = tg; 
         b = tb;
     }
     public void draw(Graphics page)
     {
         page.setColor(new Color(r,b,g));   //sets the color that was determined by the Randomly generated number
         page.drawLine(x1,x2,y1,y2);    //calls the drawLine mathod of the Graphics 
     }
}

