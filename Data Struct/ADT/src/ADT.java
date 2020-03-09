//Maciej Bregisz
//Project 2
public class ADT {
        private int sizeMax;
        private int[] stack;
        private int redSize;
        private int blueSize;
        private int baseIndex;

        public ADT(int red, int blue){
            sizeMax = red + blue + 1;
            stack = new int[sizeMax];
            baseIndex = blue;
            redSize = baseIndex+1;
            blueSize = baseIndex-1;

        }
        public void redPush(int a){
            if (redSize == sizeMax){
                System.out.println("Red stack is full");
            }
            else {
                stack[redSize] = a;
                redSize++;
            }
        }
        public void bluePush(int a){
            if (blueSize == -1){
                System.out.println("Blue stack is full");
            }
            else {
                stack[blueSize] = a;
                blueSize--;
            }
        }
        public int bluePop(){
            if (blueSize == baseIndex-1){
                System.out.println("Blue stack is empty");
                return -1;
            }
            else {
                blueSize++;
                return stack[blueSize];

            }
        }
        public int redPop(){
            if (redSize == baseIndex+1){
                System.out.println("Red stack is empty");
                return -1;
            }
            else {
                redSize--;
                return stack[redSize];

            }
        }
        public boolean isRedEmpty(){
            return (redSize == baseIndex+1);
        }
        public boolean isBlueEmpty(){
            return (blueSize == baseIndex-1);
        }
        public boolean isRedFull(){
            return (redSize == sizeMax);
        }
        public boolean isBlueFull(){
            return (blueSize == -1);
        }
        public int peekRed(){
            return stack[redSize-1];
        }
        public int peekBlue(){
            return stack[blueSize+1];
        }

    public static void main(String args[]) {
        ADT stack = new ADT(10,10);
        stack.redPush(14);
        stack.redPush(15);
        stack.redPush(11);
        stack.redPush(91);

        System.out.println(stack.redPop());
        System.out.println(stack.redPop());
        System.out.println(stack.redPop());

        stack.bluePush(132);
        stack.bluePush(145);
        stack.bluePush(152);
        stack.bluePush(169);

        System.out.println(stack.bluePop());
        System.out.println(stack.bluePop());
        System.out.println(stack.bluePop());

    }
}
============ OUTPUT ================
        91
        11
        15
        169
        152
        145