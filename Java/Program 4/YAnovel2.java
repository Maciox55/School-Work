public class YAnovel2 extends Novel2
{
    private int minAge; //minAge reference
    
    //YAnovel object constructor, passes parameters to the Parent's constructor
    public YAnovel2(String novelT, String novelA, int novelC, int numPages, int novelMinAge)
    {
        super(novelT, novelA, novelC, numPages); //Invokes parents consturctor
        minAge = novelMinAge;
    }
    
    //Minimum Age accessor
    public int getMinAge() 
    {
        return minAge;  //returns minAge
    }
    
    //Overriden toString(), this overrides the parents toString() method, sets up a simple way of printing all the information the object contains and inherits into one simple string
    public String toString()
    {
        return ("Title: " + getTitle() + "\n" +
        "Author: " + getAuthor() + "\n" +
        "Chapters: " + getChapters() + "\n" +
        "Pages: " + getPages() + "\n" + 
        "Minimum Age: " + getMinAge());
    }
}
