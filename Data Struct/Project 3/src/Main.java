import java.util.*;
public class Main {
    public static void addFirst(int n) {
        ArrayList<Integer> array = new ArrayList<Integer>(n);
        long startingTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            array.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startingTime);
        System.out.println("Total time taken to add n elements at the beginning = " + timeElapsed);
    }
    public static void addMiddle(int n) {
        ArrayList<Integer> array = new ArrayList<Integer>(n);
        long startingtime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            array.add((array.size() / 2), i);
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startingtime);
        System.out.println("Total time taken to add n elements in the middle = " + timeElapsed);
    }
    public static void addEnd(int n) {
        ArrayList<Integer> array = new ArrayList<Integer>(n);
        long startingtime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            array.add(array.size(), i);
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startingtime);
        System.out.println("Total time taken to add n elements in the end = " + timeElapsed);
    }
    public static void main(String[] args) {
        for (int i = 100000; i <= 10000000; i += 100000) {
            System.out.println("results for n = " + i);
            addFirst(i);
            addMiddle(i);
            addEnd(i);
            System.out.println("\n\n");
        }
    }
}

results for n = 100000
        Total time taken to add n elements at the beginning = 1831
        Total time taken to add n elements in the middle = 762
        Total time taken to add n elements in the end = 15



        results for n = 200000
        Total time taken to add n elements at the beginning = 4237
        Total time taken to add n elements in the middle = 1991
        Total time taken to add n elements in the end = 16



        results for n = 300000
        Total time taken to add n elements at the beginning = 11554
        Total time taken to add n elements in the middle = 4588
        Total time taken to add n elements in the end = 31