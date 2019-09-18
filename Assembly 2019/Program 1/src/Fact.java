/* CS 254 Program 1
| Author: Maciej Bregisz
| Date: 08/28/2019
|
| Compute N factorial for N=1 to 50.
|
*/
public class Fact {
    private static int maxFactorial = 50;  //Defines maximum factorials to be calculated

    public static void main(String[] args) {
        int fact = 1;   //Starting factorial
        for(int i = 1; i <= maxFactorial;i++) //Iterates over all desired factorials
        {
            fact = fact * (i);     //Takes previous ( and starting) factorial and multiplies by current increment
            System.out.println("Factorial of " + i + " is " +fact);      //Prints output of each factorial
         }
    }
}
