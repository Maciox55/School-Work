
/**
 * Write a description of class Dungeon02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Dungeon02 extends Dungeon
{

    /**
     * Constructor for objects of class Dungeon02
     */
    public Dungeon02()
    {
        super();
    }


   /**
     *  The hero explores this dungeon
     * 
     * @param  hero   the hero of the game
     */
    public void explore( Hero hero )
    {       
       
        System.out.println("You follow a dark tunnel, into a dank cellar.");
        System.out.println("In front of you appears a shadowy projection of Baal and says 'You Will never succeed Nephalem, now you will die!' The projection disappears.");
        System.out.println("In the corner of the dank cellar a pile of bones assemble into a skeleton archer.\n");
        
        // The hero encounters a monster with hitpoits 3 and strength 4
        Monster skeleton = new Monster( "Baal's Skeleton Archer", 3, 2 );        
        System.out.println( "\n" + hero.toString() + "\t" + skeleton.toString() );       
        pause();
        
        // The hero and the wombat fight to the death
        while ( hero.getHitpoints()>0 && skeleton.getHitpoints()>0 )
        {
            hero.strike( skeleton );
            pause();

            if ( hero.getHitpoints()>0 && skeleton.getHitpoints()>0 )
            {
              skeleton.strike( hero );
            }
            
            System.out.println( "\n" + hero.toString() + "\t" + skeleton.toString() );
            pause();
        }

        // If the hero is still alive, the adventure continues
        if ( hero.getHitpoints()>0 )
        {
            System.out.println("The Evil magic that held the skeleton together weakens sending its bones across the dank cellar.");
            System.out.println("Upon closer inspection of the remains you find ");
            System.out.println("a Legendary Bow, You cannot use it, but it can be sold for some coin.  Do you pick it up? (y n)");
            if ( checkYes() )
            {
                System.out.println("The Legendary Bow is worth 100 gold, great!");
                hero.incGold( 100 );
            }
            else
            {
                System.out.println("You ignore the heavy Legendary Bow, the weight would just delay your regeneration, you gain 2 HP");
                hero.increaseHitPoints( 2 );
            }

            System.out.println("Just in front of the door you find a locked chest");
            System.out.println("Do you smash it? (y n)");
            
            if ( checkYes() )
            {
                int result =  rand.nextInt( 3 ) ;
                int randGold = rand.nextInt(); //Random number of picked up gold
                
                System.out.println("As you swing your sword the chest starts bouncing your way, but it is too slow for it to do you harm, you deal a powerful blow to the mimic chest killing it in one strike.");
                if ( result == 0 )
                {
                    System.out.println("The smashed chest reveals a strength potion! ");
                    System.out.println("You gain one two strength points!");
                    hero.increaseStrength( 2 );
                }
                else if ( result == 1 )
                {
                    System.out.println("As you smash the chest gold flies all over the room");
                    System.out.println("Now you have to find all of those gold coins scattered accross the room");
                    System.out.println("After individually picking up all the gold coins, you count the total : " + randGold + " gold coins, that's probably all of them");
                    hero.incGold(randGold);
                }
                else 
                {
                    System.out.println("You smashed the chest too hard and its content was destroyed");
                    System.out.println("You let out a sigh and think to yourself 'Really? again?'");
                }
 
            }
            else
            {
                
                System.out.println("You choose to ignore the chest, unfortunately its a mimic chest! The chest opens up and reveals the needle sharp teeth, it starts to bounce your way!");
                Monster mimic = new Monster( "Mimic Chest", 1, 2 );        
                System.out.println( "\n" + hero.toString() + "\t" + mimic.toString() );       
                pause();
                
                // The hero and the mimic chest fight to the death
                while ( hero.getHitpoints()>0 && mimic.getHitpoints()>0 )
                {
                    hero.strike( mimic );
                    pause();
        
                    if ( hero.getHitpoints()>0 && mimic.getHitpoints()>0 )
                    {
                      mimic.strike( hero );
                    }
                    
                    System.out.println( "\n" + hero.toString() + "\t" + mimic.toString() );
                    pause();
                }
            }
            
        } 
        System.out.println("You find the keys to the door and enter another tunnel.");
    }
         
}
