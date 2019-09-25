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
        //Instanciates new list of scores
        SLList list = new SLList();
        //Populating the scoreboard with scores and names dynamically, unsorted from the above arrays
        for(int i= 0; i < names.length;i++)
        {
            list.insert(new Node(names[i],scores[i]));
        }
        list.display();
    }
}
//Defines Node class and its constructor
class Node{
    private String name;
    private int score;
    private Node next;
    //Node constructor
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

    //Single linked list constructor
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
    //Utility function, reverses the scores from ascending to descending order.
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
    //finds and removes a node from a single linked list
    public void remove(Node n) {
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
    //Utility method to display the results of the top 10 scores.
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

OUTPUT:
        Top Ten Scores! (Sorted, Descending)
        Joe : 100, Slav : 99, Seba : 90, Nick : 85, Gav : 79, Pat : 72, Jeb : 66, Deb : 55, Trev : 34, Jack : 31,


