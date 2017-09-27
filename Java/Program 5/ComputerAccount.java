/**
 * Write a description of class ComputerAccount here.
 * 
 * @author Maciej Bregisz
 * 
 */
public class ComputerAccount extends Account
{
   private String login;
   private String password;
   
   public ComputerAccount(String log, String pass, String userN, String phoneN) //Constucts Parent, and then self
   {
       super(userN, phoneN);
       login = log;
       password = pass;
   }
   
   public String getLogin() //Getter for login property
   {
       return login;
   }
   
   public String setLogin(String newLogin)  //setter for login property
   {
       login = newLogin;
       return login;
   }
   
   public String getPass()  //getter for password
   {
       return password;
   }
   
   public String setPass(String newPass)    //setter for password
   {
       password = newPass;
       return password;
   }
   
   public boolean goodPassword(String pass) //checks the password for atleast one uppercase and one lowercase letter, as well as total password length
   {
       boolean goodPass = false;    //initialises the variables used in this method
       int numL = 0;                //Used to keep track of how many upper, lower are present in the password
       int numU = 0;
       if(pass.length() >= 8)       //Checks if the password is atleast 8 characters long
       {
           for(int i = 0; i<pass.length(); i++)
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
           }
            if((numL >= 1) && ( numU >= 1))//Checks if password has atleast one of each requirements
           {
               goodPass = true;
           }
           else{    //If password does not have one of each requirements the console will prompt user to reenter a good password or check it for errors
               System.out.println("Check your password and make sure it contains at least One Uppercase and Lowercase characters! Also make sure its atleast 8 digits long!");
               goodPass = false;
           }
       }
       else //if password is less than 8 characters long, prints a warning 
       {
           System.out.println("Password is less than 8 characters: ");
           goodPass = false;
       }
       return goodPass;
   }

   public String toString() //Override for toString, this build ontop of the Accoutn toString, provides more 
   {
       return ("Username: " + getName() + "\n" + "Phone Number: " + getNumber() + "\n"
       + "Login: " + getLogin() + "\n" + "Password: " + getPass() + "\n" + "Strong Password: " + goodPassword(getPass()));  //The return String will only return the password requirements of ComputerAccount, ignoring the digit requirement
   }
   
}
