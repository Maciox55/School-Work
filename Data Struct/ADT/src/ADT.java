import java.util.Scanner;
import java.util.Stack;

public class ADT {

    // stacks declared
    Stack<Integer> red;
    Stack<Integer> blue;

    //constructor
    public ADT(Stack<Integer> red, Stack<Integer> blue) {
        this.red = red;
        this.blue = blue;
    }

    //inserting new
    public void redPush(int data) {
        insert(data);
    }
    //inserting
    public void bluePush(int data) {
        insert(data);
    }
    //removes from stack
    public int pop() {
        if (red.size() == 0){
            System.out.print("There are no more elements to be removed");
        }
        return red.pop();
    }

    public void insert(int data) {
        //Check if red is empty
        if (red.size() == 0) {
            red.push(data);
        } else {
            //Add from red to blue
            int l = red.size();
            for (int i = 0; i < l; i++) {
                blue.push(red.pop());       //
            }
            //Pushes new element to red
            red.push(data);
            for (int i = 0; i < l; i++) {
                red.push(blue.pop());
            }
        }
    }


    //checking for stack empty
    public boolean isEmpty() {
        return red.size() == 0;
    }

    //size of stack
    public int getSize() {
        return red.size();
    }

    //printing stack
    public void display() {
        System.out.print("\nStack: ");
        int l = getSize();
        if (l == 0) {
            System.out.print("Stack Empty\n");
        } else {
            for (int i = l - 1; i >= 0; i--) {
                System.out.print(red.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Stack<Integer> red = new Stack<Integer>();
        Stack<Integer> blue = new Stack<Integer>();
        ADT stack = new ADT(red,blue);
        Scanner sc = new Scanner(System.in);
        //Manu loop
        while(true){
            System.out.println("1. Push on Blue Stack 2.Red stack push 3. pop 4.Size 5.Check if Empty 6.Display 7.Exit");
            int choice = sc.nextInt();
            //Blue stack push
            if(choice == 1){
                System.out.println("Enter number to insert: ");
                int num = sc.nextInt();
                stack.bluePush(num);
            }
            //Red stack push
            else if(choice == 2){
                System.out.println("Enter number to insert: ");
                int num = sc.nextInt();
                stack.redPush(num);
            }
            //Pop data option
            else if(choice == 3){
                System.out.println("Pop: "+stack.pop());
            }
            //getting size of stack
            else if(choice == 4){
                System.out.println("Size: "+stack.getSize());
            }
            //checking empty stack or not
            else if(choice == 5){
                System.out.println(stack.isEmpty());
            }
            //displaying stack data
            else if(choice == 6) {
                stack.display();
            }
            else{

                break;
            }
        }
    }
}