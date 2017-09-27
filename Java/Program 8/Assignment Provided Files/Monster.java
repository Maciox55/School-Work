
/**
 * class Monster, opponent of a Hero
 * 
 * @author   Example
 * @version  March 15, 2017
 */
public class Monster extends Actor
{
        
    public Monster( String name, int hitPoints, int strength )
    {
        super( name, hitPoints, strength );
    }
    
    public String speak()
    {
        return "Growl ";
    }
}
