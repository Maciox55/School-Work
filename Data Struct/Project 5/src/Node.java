import java.util.ArrayList;
import java.util.*;

//Stack class
class Stack<T> {
    //Root of Tree
    ArrayList<T> treeRoot;

    //constructor
    public Stack() {
        treeRoot = new ArrayList<>();
    }
    //method to add newItem to the stack.
    public void add(T value) {
        treeRoot.add(value);
    }
    //method to return the top element of the stack.
    public T top() {
        if (!isEmpty())
            return treeRoot.get(treeRoot.size() - 1);
        else
            return null;
    }
    //method to remove the top element of the stack.
    public T pop() {
        if (!isEmpty()) {
            T value = treeRoot.get(treeRoot.size() - 1);
            treeRoot.remove(treeRoot.size() - 1);
            return value;
        } else
            return null;
    }
    //method to determine whether the stack is empty.
    public boolean isEmpty() {
        if (treeRoot.isEmpty())
            return true;
        return false;
    }

}

//InfixToPostfix
class InfixToPostfix {
    //method to return priority of a operator, PEMDAS
    public int getPriority(String c) {
        switch (c) {
            case "^":
                return 5;
            case "/":
                return 4;
            case "*":
                return 3;
            case "+":
                return 2;
            case "-":
                return 1;
            case "(":
                return 0;
            default:
                return 999;
        }
    }

    //check if operator
    boolean isOperator(String s) {
        switch (s) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
                return true;
        }
        return false;
    }

    //main method
    public String infixToPostfix(String e) {
        Stack<String> stack = new Stack();
        String output = "";
        stack.add("(");
        String exp = e + " )";

        String arr[] = exp.split(" ", 20);

        //convert from infix to postfix
        for (int i = 0; i < arr.length; i++) {
            String ch = arr[i];

            //check for left parenthesis
            if (ch.equals("(")) {
                stack.add(ch);
            }
            //check for righr parenthesis
            else if (ch.equals(")")) {
                while (!stack.top().equals("(")) {
                    output = output + stack.pop() + " ";

                }
                stack.pop();
            }
            //operator
            else if (isOperator(ch)) {
                int p1 = getPriority(ch);

                int p2 = getPriority(stack.top());

                while (p1 <= p2) {
                    output = output + stack.pop() + " ";
                    p2 = getPriority(stack.top());
                }
                stack.add(ch);
            }
            //operand
            else {
                output = output + ch + " ";
            }
        }
        if (!stack.isEmpty())
            return "None";
        else
            return output;
    }
}

//Node class
class Node {
    String info;
    Node lchild;
    Node rchild;

    //constructor
    Node(String val) {
        info = val;
        lchild = null;
        rchild = null;
    }
}

//ExpTree class
class ExpTree {
   //inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.lchild);
            System.out.print(root.info + " ");
            inorder(root.rchild);
        }
    }
    //check for operator
    boolean isOperator(String s) {
        switch (s) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
                return true;
        }
        return false;
    }

    //expression tree construction
    Node buildTree(String postfix) {
        Stack<Node> stack = new Stack();
        String arr[] = postfix.split(" ", 20);
        Node t = null;
        for (int i = 0; i < arr.length - 1; i++) {
            t = new Node(arr[i]);
            if (!isOperator(arr[i])) {
                stack.add(t);
            } else {
                Node r = stack.pop();
                Node l = stack.pop();
                t.lchild = l;
                t.rchild = r;
                stack.add(t);
            }
        }
        return stack.pop();
    }

    //main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the expression: ");
        String infix = sc.nextLine();

        InfixToPostfix ip = new InfixToPostfix();
        String postfix = ip.infixToPostfix(infix);

        System.out.println("Postfix Expression: " + postfix);

        if (postfix.equals("None")) {
            System.out.println("Invalid expession");
            return;
        }

        ExpTree expression = new ExpTree();
        Node root = expression.buildTree(postfix);

        System.out.println("Inorder traversal of the tree: ");
        expression.inorder(root);
    }
}

// OUTPUT

    Enter the expression:
        ( 3 * 2 ) / ( 2 * ( 1 + 2 ) )
        Postfix Expression: 3 2 * 2 1 2 + * /
        Inorder traversal of the tree:
        3 * 2 / 2 * 1 + 2