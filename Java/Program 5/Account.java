/**
 * Write a description of class Account here.
 * 
 * @author Maciej Bregisz 
 * 
 * This Class is pretty straight forward, it has a constuctor, getters and setter, as well as a basic toString override.
 */
public class Account
{
    private String userName, phoneNumber;
    
    public Account(String userN, String phoneN) //Constuctor
    {
        userName = userN;
        phoneNumber = phoneN;
    }
    
    public String getName()
    {
        return userName;
    }
    
    public String getNumber()
    {
        return phoneNumber;
    }
    
    public String setNumber(String newNumber)
    {
        phoneNumber = newNumber;
        return newNumber;
    }
    
    public String toString()
    {
        return ("Username: " + getName() + "\n" + "Phone Number: " + getNumber());
    }
}
