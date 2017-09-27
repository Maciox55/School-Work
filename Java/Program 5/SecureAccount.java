
/**
 * Write a description of class SecureAccount here.
 * 
 * @author Maciej Bregisz
 * This class extends from the ComputerAccount class, it determines whether or not the password contains atleast one Upper, Lower, Digit characters, if it does the password/account is secure. 
 */
public class SecureAccount extends ComputerAccount
{
   private boolean strongPass; 
   public SecureAccount(String log, String pass, String userN, String phoneN)
   {
       super(log, pass, userN, phoneN); //Passes the parameters to parent constuctor
   }    
   
   public boolean goodPassword(String pass) //checks is the passed password is strong or not, returns a boolean
   {
       boolean goodPass = false;    //initialises the variables used in this method
       int numL = 0;                //Used to keep track of how many upper, lower, digits are present in the password
       int numU = 0;
       int numN = 0;
       if(pass.length() >= 8)       //Checks if the password is atleast 8 characters long
       {
           for(int i = 0; i<pass.length(); i++) //itterates through each character of the passed string, i is the index of the character of the string
           {
               char c = pass.charAt(i); //gets the character at index i
               if(Character.isUpperCase(c)) //checks if Character is uppercase
               {
                  numU++;   //if so adds to the uppercase counter 
               }
               else if(Character.isLowerCase(c))    //checks if Character is lowercase
               {
                   numL++;  //if so adds to the lowercase counter 
               }
               else if(Character.isDigit(c))    //checks if Character is a digit
               {
                   numN++;  //if so adds to the digit counter 
               }    
           }
           if((numL >= 1) && ( numU >= 1) && (numN >=1))    //Checks if password has atleast one of each requirements
           {
               goodPass = true; //sets goodPass to true, indicating that password is strong
           }
           else{    //If password does not have one of each requirements the console will prompt user to reenter a good password or check it for errors
               System.out.println("Check your password and make sure it contains at least One Uppercase, Lowercase, Digit characters! Also make sure its atleast 8 digits long!");
               goodPass = false;
           }
       }
       else //if password is less than 8 characters long, prints a warning 
       {
           System.out.println("Password is less than 8 characters: ");
           goodPass = false;
       }
       return goodPass; //returns the strength of password, true means password is strong, false means weak pass
   }
}
