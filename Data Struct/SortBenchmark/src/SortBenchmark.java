import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortBenchmark {

    //Insertion Sort Method
    public static void insertionSort(int array[]) {
        int len = array.length;
        for (int c = 1; c < len; ++c) {
            int key = array[c];
            int d = c - 1;
            while (d >= 0 && array[d] > key) {
                array[d + 1] = array[d];
                d = d - 1;
            }
            array[d + 1] = key;
        }
    }
    // Selection Sort Method
    static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    static void merge(int array[], int start, int mid, int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int leftArray[] = new int[n1];

        int rightArray[] = new int[n2];

        for (int c = 0; c < n1; ++c) {
            leftArray[c] = array[start + c];
        }
        for (int c = 0; c < n2; ++c) {
            rightArray[c] = array[mid + 1 + c];
        }

        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    //MergeSort Method
    static void mergeSort(int array[], int start, int end) {
        // Checks if start is less then end
        if (start < end) {
            //Get mid pivot
            int mid = (start + end) / 2;
            //Sort halves
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            // Merge halves
            merge(array, start, mid, end);
        }
    }

    public static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        // Loops till low is less than high
        for (int c = low; c < high; c++) {
            //If current element is smaller than or equal to pivot
            if (array[c] <= pivot) {
                i++;
                // Swap array[i] and array[c]
                int temp = array[i];
                array[i] = array[c];
                array[c] = temp;
            }
        }
        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    // QuickSort Method
    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            //partitioning the array into segments for recursion
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }
    //Utility to print all array elements
    static void displayArray(int array[]) {

        // Loop and print array element at index
        for (int c = 0; c < array.length; ++c) {
            System.out.print(array[c] + " ");
        }
         System.out.println();

    }

    public static void main(String[] args) {

        //Start time and end time
        long startTime, stopTime;

        // Calculated time for algorithm in miliseconds
        long usedTime_ms;

        //Random instance
        Random rng = new Random();
        // Declares arrays for each type of sorting
        int elements = 100000;
        int arrInsertion[] = new int[elements];
        int arrSelection[] = new int[elements];
        int arrMerge[] = new int[elements];
        int arrQuick[] = new int[elements];

        //Random elements for arrays
        for(int i = 0; i<elements; i++ )
        {
            arrInsertion[i]= rng.nextInt(100000);
            arrSelection[i]= rng.nextInt(100000);
            arrMerge[i]= rng.nextInt(100000);
            arrQuick[i]= rng.nextInt(100000);

        }

        System.out.print("Efficiency of sorting for:" + elements + " elements in miliseconds");

        // INSERTION SORT
        //System.out.println("\n Before Insertion Sort: ");
        //displayArray(arrInsertion);
        // Set the start time
        startTime = System.nanoTime();
        insertionSort(arrInsertion);
        stopTime = System.nanoTime();
        // Time taken between start time and stop time
        usedTime_ms = (stopTime - startTime);
        //System.out.println("\n After Insertion Sort: ");
        //displayArray(arrInsertion);
        System.out.println("\n Time taken by INSERTION Sort: " + TimeUnit.NANOSECONDS.toMillis(usedTime_ms));

        // SELECTION SORT
        //System.out.println("\n Unsorted before : ");
        //displayArray(arrSelection);
        // Sets the start time
        startTime = System.nanoTime();
        selectionSort(arrSelection);
        // set the stop time
        stopTime = System.nanoTime();
        // Calculates time taken
        usedTime_ms = (stopTime - startTime);
        //System.out.println("\n After Selection Sort: ");
        //displayArray(arrSelection);
        System.out.println("\n Time taken by SELECTION Sort: " + TimeUnit.NANOSECONDS.toMillis(usedTime_ms));

        //MERGE SORT
        //System.out.println("\n Before Merge Sorted: ");
        //displayArray(arrMerge);
        // Stores the start time
        startTime = System.nanoTime();
        mergeSort(arrMerge, 0, arrMerge.length - 1);
        // Stores the stop time
        stopTime = System.nanoTime();
        // Calculates time taken
        usedTime_ms = (stopTime - startTime);
        //System.out.println("\n After Merge Sorted: ");
        //displayArray(arrMerge);
        System.out.println("\n Time taken by MERGE Sort: " + TimeUnit.NANOSECONDS.toMillis(usedTime_ms));

        // Quick sort
        //System.out.println("\n Before Quick Sorted: ");
        //displayArray(arrQuick);
        // Sets the start time
        startTime = System.nanoTime();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        // Sets the stop time
        stopTime = System.nanoTime();
        // Calculates time taken
        usedTime_ms = (stopTime - startTime);
        //System.out.println("\n After Quick Sorted: ");
        //displayArray(arrQuick);
        System.out.println("\n Time taken by QUICK Sort: " + TimeUnit.NANOSECONDS.toMillis(usedTime_ms));
    }
}

    Efficiency of sorting for:100000 elements in miliseconds
        Time taken by INSERTION Sort: 1628

        Time taken by SELECTION Sort: 5329

        Time taken by MERGE Sort: 29

        Time taken by QUICK Sort: 19

