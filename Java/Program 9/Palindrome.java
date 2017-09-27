import java.util.Scanner; //imports the Scanner for user input

public class Palindrome
{
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);  //initializes scanner
       System.out.print("Enter a string: ");    //Prints instructions for user
       String userInput = input.nextLine(); //sets tehe variable string with the users input
       if(palindrome(userInput)){   //calls the palindrome method, and check its return to determine whether the input is or isn't a palindrome. If palindrome() returns true then input is a palindrome, any other method result is 
           System.out.println("This is a Palindrome!");
        }
        else{
            System.out.println("This is NOT a Palindrome!");
        }

    }
    
   public static boolean palindrome(String input){   
        if(input.length() == 0 || input.length() == 1){ //checks if the overall length of the string is 0 or 1, as no input and a single character are always palindrome, 
            return true;
        }
        if(input.charAt(0) == input.charAt(input.length()-1)){  //checks if the letter at first index is the same than the last 
            return palindrome(input.substring(1,input.length()-1));   //calls the method itself again but this time the string substring is 1 letter less both ends of array     ex. string of "able was I ere I saw elba" becomes "ble was I ere I saw elb" after one itteration
        }
        return false; //returns false if input is not a palindrome
   }
}
