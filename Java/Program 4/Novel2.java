//  Author: Maciej Bregisz
//  Date: 02-24-2017
//  Purpose: Demonstrate the concept of Inheritance between classes and Objects. YAnovel is the top of the hierarchy and extends/inherits from it's parent (Novel2),
//           which inturn inherits from it's parent (Book2)
//
public class Novel2 extends Book2
{
    private String title, author;
    private int chapters;
    //Object Contructor
    public Novel2(String novelT, String novelA, int novelC, int numPages)
    {
        super(numPages);    //Invokes parents consturctor
        title = novelT;
        author = novelA;
        chapters = novelC;
    }
    
    //Title accessor
    public String getTitle()
    {
        return title;
    }
    
    //Author accessor
    public String getAuthor()
    {
        return author;
    }
    
    //Chapter accessor
    public int getChapters()
    {
        return chapters;
    }
    
    //Chapter Mututor
    public int setChapters(int chap)
    {
        chapters = chap;
        return chapters;
    }
    
    //Object toString() Override for the object Novel, this gets ovrriden by YAnovel toString, which is higher on the hierarchy and contains more information on top of this
    public String toString()
    {
        return ("Title: " + getTitle() + "\n"+ "Author: " + getAuthor() + "\n"+ "Chapters: " + getChapters());
    }
}
