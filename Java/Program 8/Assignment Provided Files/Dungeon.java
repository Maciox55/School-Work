/**
 * Dungeon -- one of the dungeons of the Cave
 * 
 * @author  BPK 
 * @version March 15, 2017
 */
import java.util.*;

public abstract class Dungeon
{
   protected Monster monster;
   protected Scanner scan;
   protected Random rand;

   public Dungeon( )
   {
       scan = new Scanner( System.in );
       rand = new Random();
   }

    /**
     * pause for user input
     * 
     */
    protected void pause()
    {
        System.out.print("\t(hit enter)");
        scan.nextLine();
    }
    
    
    /**
     * check if the answer to a question starts with 'y' of 'Y'
     * 
     * Assume that any other answer means no.
     */
    protected boolean checkYes()
    {
        String ans = scan.next();
        return ( ans.charAt(0) == 'y' || ans.charAt(0) == 'Y' ) ;
    }

    /**
     *  The hero explores the dungeon
     */
   public abstract void explore( Hero hero );
}
