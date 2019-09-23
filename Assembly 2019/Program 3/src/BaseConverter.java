import java.util.Scanner;
/*
    Autor: Maciej Bregisz
    Desc: Takes user input integer and converts into base 5
 */

public class BaseConverter {
    public static void main(String[] args) {
        int number;     //Stores the user input.
        int base = 5;     //Desired base stored inside a variable for extensibility.

        Scanner scanner = new Scanner(System.in);     //Instanciate the scanner for user input.
        System.out.print("Please enter an Integer (in Base 10) you want to convert: ");
        number = scanner.nextInt();     //Stores user input to a variable.
        String str="";     //String for concat.
        while(number>0){
            str=str+ number % 5;     //Adds the modulo result to a string using concatination.
            number=number/base;     //Changes the number value.
        }
        String reverse="";     //String that contains the reversed string.

        //Reversing the string after concatination.
        for(int i=str.length()-1;i>=0;i--){
            reverse=reverse+str.charAt(i);  //Adds the last character from the converted string to the top of the reversed string.
        }

        int base5=Integer.valueOf(reverse); //Holds the integer representation of the converted from the reversed string.
        System.out.println("In Base 5: "+base5); //Prints the result
    }
}
