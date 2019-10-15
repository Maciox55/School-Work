import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ADT {

//two stacks declared
Stack<Integer> red;
Stack<Integer> blue;

//constructor declared
public ADT(Stack<Integer> red, Stack<Integer> blue) {
this.red = red;
this.blue = blue;
}

//inserting new data
public void redPush(int data) {
insert(data);
}

//inserting data
public void bluePush(int data) {
insert(data);
}

public void insert(int data) {

//checkging red stack empty or not
if (red.size() == 0) {
red.push(data);
} else {
//adding red stack data to blue stack.. so that they act like an continouus stacks
int l = red.size();
for (int i = 0; i < l; i++) {
blue.push(red.pop());
}
/* push the new element to stack red */
red.push(data);
for (int i = 0; i < l; i++) {
red.push(blue.pop());
}
}
}

//deleting element from stack
public int pop() {
if (red.size() == 0) {
throw new NoSuchElementException("Underflow Exception");
}
return red.pop();
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
System.out.print("Empty\n");
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
//menu displaying
while(true){
System.out.println("1. Blue stack push 2.Red stack push 3. pop 4.Get Size 5.Check Empty 6.Display 7.Exit");
int choice = sc.nextInt();
//blue stack push
if(choice == 1){
System.out.println("Enter number to insert: ");
int num = sc.nextInt();
stack.bluePush(num);
}
//red stack push
else if(choice == 2){
System.out.println("Enter number to insert: ");
int num = sc.nextInt();
stack.redPush(num);
}
  
//pop data
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
else if(choice == 6){
stack.display();
}
//exiting from app
else{
  
break;
}
}
}
}