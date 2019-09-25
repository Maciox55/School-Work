/*
    Author: Maciej Bregisz
    Desc: Implements and uses the double linked list to keep track of top 10 scores,
     scores are automatically sorted on insertion, remove method removes entry at the sorted position.
 */
public class TopTenDouble{
    //Main function of the program, could also be called the Game
    public static void main(String[] args) {
        //Utility arrays holding palceholder data for creating random nodes, could be used with user input instead
        String[] names = {"Jack", "Mac", "Pat", "Nick", "Seba", "Trev", "Deb", "Jeb", "Gav", "Slav", "Joe"};
        int[] scores = {31,64,72,85,90,34,55,66,79,99,100};
        //instanciate new list object
        DLList list = new DLList();
        //Populating the scoreboard with scores and names dynamically, unsorted from the above arrays
        for(int i= 0; i < names.length;i++)
        {
            list.insert(new Node(names[i],scores[i]));  //Dynamically creates and inserts nodes to the list.
        }
        list.remove(3);     //Removes the score at pointer 1
        list.display();     //Utility method that prints out the display
    }
}
//Defines Node class and its constructor
class Node{
    private String name;
    private int score;
    private Node next;
    private Node prev;
    //Constructor
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
    public void SetPrev(Node p){
        this.prev = p;
    }
    public Node GetPrev(){
        return this.prev;
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
class DLList {
    public Node head;
    public Node tail;
    public int size;
    //Constructor
    public DLList(){
        head = null;
        tail = null;
        size = 0;
    }
    //Adds another node to the linked list, automatically inserts the node in a position that makes the list sorted.
    public void insert(Node n)
    {
        Node current;
        //Base Case, if no head and tail exists, new node is head and tail
        if(head == null)
        {
            head = n;
            tail = n;
            size++;
        }else if (head.GetScore() >= n.GetScore())     //Compares head score to the score being inserted
        {
            n.SetNext(head);    //set new node next ref to head
            n.GetNext().SetPrev(n);     //set the next node's prev. ref. as node
            head = n;     //node becomes head
        }
        else
        {
            current = head;
            // Locate the node after which the new node is to be inserted
            while (current.GetNext() != null && current.GetNext().GetScore() < n.GetScore()) {
                current = current.GetNext();
            }
            //Set value of current node's next ref. as inserted node's next ref.
            n.SetNext(current.GetNext());

            // If the new node is not inserted
            // At the end of the list
            if (current.GetNext() != null)
            {
                n.GetNext().SetPrev(n);     //Get next node of new node being insterted, set prev. ref. to new node
            }
            current.SetNext(n);     //Set current selected node next value to new node being instered
            n.SetPrev(current);     //Set new node previous node ref to current selected node
            tail=n;     //Set new node as tail
            size++;     // Increment list size
        }
    }

    //Finds and removes a node at given index position
    public void remove(int index) {
        // If linked list is empty
        if (head == null)
            return;
        // Store head node
        Node temp = head;
        // If head needs to be removed
        if (index == 0)
        {
            head = temp.GetNext();   // Change head
            return;
        }
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<index-1; i++)
        {
            temp = temp.GetNext();
        }
        // If position is more than number of ndoes
        if (temp == null || temp.GetNext() == null)
        {
            return;
        }
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.GetNext().GetNext();
        temp.SetNext(next);  // Unlink the deleted node from list
        size--;

    }
    //Because nodes are inserted in ascending order, this utility method reverses the node list to be descending order
    public Node reverse(Node n)
    {
        Node prev = null;
        Node current = n;
        Node next;
        while(current != null)
        {
            next = current.GetNext();
            current.SetNext(prev);     //Preserves the link between nodes, previous of current becomes next
            current.SetPrev((next));     //Next of current becomes previous node
            prev = current;
            current = next;
        }
        return prev;
    }
    //Utility method,
    public void display() {
        Node n = reverse(head);     //temp Node object holding a ref. to the head node but after reversal.
        int i = 0;
        System.out.println("Top Ten Scores! (Sorted, Descending)");
        while(n != null && i < 10)     //Prints only the first 10 scores, even if there are more than 10 available
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





