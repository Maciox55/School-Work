import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {
   public static void main(String[] args) throws FileNotFoundException {
       Scanner input = new Scanner(System.in);      //Scanner for the text file input
       System.out.print("Enter filename: ");    //User prompt
       String fileName = input.next();  //Sets the filename for the next scanner


       Scanner sc = new Scanner(new File(fileName));    //Scanner for the file, creates a new instance of file in memory for scanning
       int countArr[] = new int[11];    //categories for ranges, will hold the final count of numbers wihin ranges
       int num; //variable for current number from text file
       while(sc.hasNextInt()){      //Will run untill all numbers were scanned
           num = sc.nextInt();  //reads the next number from the file
           
           if(num >=0 && num <=9)   //If number is within the range inceases the counter value within the ranges 
           {
               countArr[0]++;   //adds +1 to value if current number scanned falls within range
           }
           else if(num>=10 && num <=19)
           {
               countArr[1]++;
           }
           else if(num>=20 && num <=29)
           {
               countArr[2]++;
           }
           else if(num>=30 && num <=39)
           {
               countArr[3]++;
           }
           else if(num>=40 && num <=49)
           {
               countArr[4]++;
           }
           else if(num>=50 && num <=59)
           {
               countArr[5]++;
           }
           else if(num>=60 && num <=69)
           {
               countArr[6]++;
           }
           else if(num>=70 && num <=79)
           {
               countArr[7]++;
           }
           else if(num>=80 && num <=89)
           {
               countArr[8]++;
           }
           else if(num>=90 && num <=99)
           {
               countArr[9]++;
           }
           else // out of range if number falls out side the range 0-99
           {
               countArr[10]++;
           }
       }

       sc.close();  //stops the file scanner, and "closes" the file itself
       int low = 0, high = 9;   //First range values for printing 
       System.out.println("range\t\tcount");    //column lables
       int totalCount = 0;
       for(int i=0; i<10; i++){     //array index itterator

           System.out.print(low+"-"+high+"\t\t"+countArr[i]+" |");  //Prints range values, and total number of values within the range

           for(int j=1; j<=countArr[i]; j++)    //for every number in total range value print one star
           {
               System.out.print("*");   //Prints star
               if((j % 10) == 0) //prints a space every 10 stars to separate the stars into neat groups for easier visual counting
               {
                   System.out.print(" ");   //Prints the star spacer
               }
              totalCount++; //increments the total  numbers counted
           }
           
           System.out.println();    //prints empty line to separate the ranges into a list instead of a continous line of results

           low = low+10;    //sets the lowest range value for printing eg.(0-9 becomes 10-19 etc)

           high = high + 10;    //sets the highest range value for printing 

       }

       System.out.print("out of range\t"+countArr[10]+" |");    //prints the total count of values out of range 0-99, like -1

       for(int j=1; j<=countArr[10]; j++)   //itterates through the array of out of range category and prints a star for range total
       {
           System.out.print("*");   //prints star
           if((j % 10) == 0) //prints a space every 10 stars to separate the stars into neat groups for easier visual counting
           {
               System.out.print(" ");   //prints spacer
           }
           totalCount++;    //increments the total numbers counted
       }
       System.out.println();    //line break
       System.out.println("Total Count: " + totalCount);    //Prints the total number of numbers that were counted
   }
}