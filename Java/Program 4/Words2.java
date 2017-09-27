public class Words2
{
    public static void main(String[] args)
    {
        YAnovel2 novel = new YAnovel2("Java is Great", "Maciej Bregisz", 25, 1080, 12);    //Creates a new YAnovel object with the parameters, (Title, Author, Chapters, Number of Pages, Minimum Age)
      
        System.out.println(novel);  //Tests the toString() method that is being overriden at the top of hierarchy (YAnovel). Instead of individually accessing the getter methods of the object that is being done in the toString() method
                                    //for simplicity. For example, if one wanted to get only the pages, novel.getPages() would return the proper page number. 
        
                                    
                                    
        //Original content from Dictionary2 unaltered, uncomment to see the 

        //Dictionary2 webster = new Dictionary2(1500, 52500);
        //System.out.println("Number of pages: " + webster.getPages());
        //System.out.println("Number of definitions: " +
        //webster.getDefinitions());
        //System.out.println("Definitions per page: " +
        //webster.computeRatio());
    }
}
