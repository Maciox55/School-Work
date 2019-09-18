

public class TopTen {

    private Node head,tail;
    private int size;

    public static void main(String[] args) {
        System.out.println("TEST");
        Node testNode = new Node(10);
    }

    public void insertFirst(Node n){
        Node newnode = n;
        if(head == null){
            head = newnode;
            tail = newnode;
        }else{
            newnode.next = head;
            head = newnode;
            size++;
        }
    }
    public void insertLast(Node n){
        Node newnode = n;
        if(head == null){
            insertFirst(n);
        }else{
           tail.next = newnode;
           tail = newnode;
        }

    }


    static class Node{
        private int score;
        private Node next;

        public Node(int s){
            this.SetScore(s);
        }

        public void SetScore(int s){
            score = s;
        }
        public int GetScore(){
            return score;
        }
        public void SetNext(Node n){
            next = n;
        }
        public Node GetNext(){
            return next;
        }
    }



}

