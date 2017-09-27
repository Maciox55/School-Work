
/**
 *  class Hero: the heroic monster-slayer
 * 
 * @author   BPK
 * @version  March 15, 2017
 */
public class Hero extends Actor
{
    int gold;  // the amount of gold collected during the game
    
    public Hero( String name, int hitPoints, int strength )
    {
        super( name, hitPoints, strength );
        gold = 0;
    }
    
    // Heros can increase their strength
    public void increaseStrength( int increase )
    {
        strength += increase;
    }
       
    // Heros can increase their hitPoints
    public void increaseHitPoints( int increase )
    {
        hitPoints += increase;
    }
    
    // Manage the hero's gold
    public int  getGold() { return gold; }
    public void incGold( int increment ) { gold+= increment; }
}
