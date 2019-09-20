/*
    Author: Maciej Bregisz
    Desc: Implements and uses the singly linked list to keep track of top 10 scores,

 */

public class TopTen {
    //Main function of the program, could also be called the Game
    public static void main(String[] args) {
        //Utility arrays
        String[] names = {"Jack", "Mac", "Pat", "Nick", "Seba", "Trev", "Deb", "Jeb", "Gav", "Slav", "Joe"};
        int[] scores = {31,64,72,85,90,34,55,66,79,99,100};
        //instanciate new list
        SLList list = new SLList();
        //Populating the scoreboard with scores and names dynamically, unsorted from the above arrays
        for(int i= 0; i < names.length;i++)
        {
            list.insert(new Node(names[i],scores[i]));
        }
        list.display(); //
    }
}
//Defines Node class and its constructor
class Node{
    private String name;
    private int score;
    private Node next;

    Node(String n, int s){
        score = s;
        name = n;
    }
    //Various Getters and Setters, some are unused in this scenario
    public void SetScore(int s){
        this.score = s;
    }
    public int GetScore(){
        return this.score;
    }
    public void SetNext(Node n){
        this.next = n;
    }
    public Node GetNext(){
        return this.next;
    }
    public void SetName(String n)
    {
        this.name = n;
    }
    public String GetName(){
        return this.name;
    }
}
//Defines the Singly linked list Class and its constructor, all variables public to save paper
class SLList {
    public Node head;
    public Node tail;
    public Node descending;
    public int size;

    public SLList(){
        head = null;
        tail = null;
        size = 0;
    }
    //Adds another node to the linked list, automatically inserts the node in a position that makes the list sorted.
    public void insert(Node n)
    {
        Node current;
        if(head == null || head.GetScore()>= n.GetScore())
        {
            n.SetNext(head);
            head = n;
        }else{
            current = head;
            while(current.GetNext() != null && current.GetNext().GetScore() < n.GetScore())
            {
                current = current.GetNext();
            }
            n.SetNext(current.GetNext());
            current.SetNext(n);
        }

    }

    public void insertLast(Node n) {
        if (head == null) {
            insert(n);
        } else {
            tail.SetNext(n);
            tail = n;
            size++;
        }

    }
    public Node reverse(Node n)
    {
        Node prev = null;
        Node current = n;
        Node next;
        while(current != null)
        {
            next = current.GetNext();
            current.SetNext(prev);
            prev = current;
            current = next;
        }
        return prev;

    }

    public void delete(Node n) {
        if (n == head) {
            head = n.GetNext();
        } else {
            Node current = head;
            while (current.GetNext() != n) {
                current = current.GetNext();
                current.SetNext(current.GetNext().GetNext());
            }
        }
    }

    public void display() {
        Node n = this.reverse(this.head);
        int i = 0;
        System.out.println("Top Ten Scores! (Sorted, Descending)");
        while(n != null && i < 10)
        {
            System.out.print(n.GetName() + " : " +n.GetScore() + ", ");
            n = n.GetNext();
            i++;

        }
    }
}
