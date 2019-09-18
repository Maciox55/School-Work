/*
    Author: Maciej Bregisz
    Description: Program that calculates upward and downward sum of harmonics using Float and Double floating point precisions.

 */
import java.util.Scanner;

public class Harmonics {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);     //Initializes the input scanner
        System.out.println("Please enter value of N: ");     //Asks user for input
        int n = scan.nextInt();     //Reads the user input as an INT type
        System.out.println("Upper Limit: " + n);     //Input Feedback
        System.out.println("Upward sum (float)    = " + upwardSum(n));     //Runs function upwardSum() with N number of harmonics
        System.out.println("Downward sum (float)  = " + downwardSum(n));     //Runs function downwardSum() with N number of harmonics
        System.out.println("Upward sum (double)    = " + upwardSumDouble(n));     //Runs function upwardSumDouble() with N number of harmonics
        System.out.println("Downward sum (double)  = " + downwardSumDouble(n));     //Runs function downwardSumDouble() with N number of harmonics
    }
    public static float upwardSum(int lim)
    {
        float upperSum = 0.0f;     //Initializes the sum variable
        for(int i= 1; i <= lim; i++)     //Simple for loop, starts at 1 to account for 1/1, 1/0 would result in a dividebyzero error
        {
            upperSum +=  (float)1/i;     //Increment upperSum by the result of division 1/n, result is cast into a float
        }
        return upperSum;     //Returns the upperSum for printing
    }
    public static float downwardSum(int lim)
    {
        float lowerSum = 0.0f;     //Initializes the sum variable
        for(int i= lim; i > 0; i--)     //Simple for loop incrementing down to 1
        {
            lowerSum +=  (float)1/i;     //Increment lowerSum by the result of division 1/n, result is cast into a float
        }
        return lowerSum;
    }
    public static double upwardSumDouble(int lim)   //Identical to above but returns a double Type
    {
        double upperSum = 0.0d;
        for(int i= 1; i <= lim; i++)
        {
            upperSum +=  (double)1/i;
        }
        return upperSum;    //Returns the upperSum for printing
    }
    public static double downwardSumDouble(int lim)     //Identical to above but returns a double Type
    {
        double lowerSum = 0.0d;
        for(int i= lim; i > 0; i--)
        {
            lowerSum +=  (double)1/i;
        }
        return lowerSum;     //Returns the upperSum for printing
    }
}
