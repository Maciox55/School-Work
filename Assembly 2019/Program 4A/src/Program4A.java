import java.util.Scanner;
/*
    Author: Maciej Bregisz
    Desc: Performs left shift operation 23 times on user specified input.
 */
public class Program4A {
    public static void main(String[] args) {
        int input;     //Holds user input
        Scanner sc = new Scanner(System.in);     //Instanciates a new scanner
        System.out.print("Enter Integer from 0 to N: ");     //User query
        input = sc.nextInt();     //Parses user input

        //Prints the result of 23 left shift operations on user defined input
        //Because left shift operation multiplies the previous result of shift by two, the multiplier is represented as x*2^4 + x*2^2 + x*2^1 + x instead of 16*x + 4*x + 2*x + x.
        System.out.println("23*" + input + "= " +((input << 4) + (input<< 2) + (input << 1) + input));
    }
}