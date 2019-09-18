

public class TopTen {

    public Node head;
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

    public static void main(String[] args) {
        System.out.println("TEST");
        Node testNode = new Node(10);
    }

}

