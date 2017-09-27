
/**
 * Abstract class Actor - a hero or a monster
 * 
 * @author   BPK
 * @version  March 15, 2017
 */
import java.util.*;

public abstract class Actor
{
    protected int hitPoints;
    protected int strength;
    protected String name;
    private   Random die;
    
    public Actor( String name, int hitPoints, int strength )
    {
        this.name = name;
        this.hitPoints = hitPoints; // the health of the Actor
        this.strength = strength;   // this Actor throws a strength-sided die
        
        die = new Random();
    }
    
    public String toString()
    {
        return name + "  hit points: " + hitPoints + " strength: " + strength;
    }
    
    public void strike ( Actor opponent )
    {
        System.out.println( name + " strikes at " + opponent.getName() );
        
        // If this Actor's die throw exceeds the opponents die throw,
        // this Actor wins     
        int ourThrow = throwDie();
        int oppThrow = opponent.throwDie();
        
        if ( ourThrow > oppThrow )
        {
            System.out.println( "Good Hit!!");
            System.out.println( opponent.getName() + " loses a hit point" );
            opponent.takeHit(1);
        }
        else
        {
            System.out.println( opponent.getName() + " ducks and is not hurt." );
        }
        
    }
    
    public String getName() { return name; }   
    public void takeHit( int points ) { hitPoints -= points ; }
    public int getHitpoints() { return hitPoints ; }
    
    protected int throwDie()
    {
        return die.nextInt( strength ) + 1;
    }
}
