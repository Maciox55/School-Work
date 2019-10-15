import java.lang.reflect.Array;
import java.util.Random;

public class bubble {
    private static Random random;
    private static int[] arr;


    public static void main(String[] args) {
        arr = new int[6];
        random = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + ", ");


        }
        bubble();
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }


    }
    public static void bubble()
    {
        for (int a = 0; a < arr.length-1; a++)
        {
            for (int b = 0; b < arr.length-1; b++)
            {
                if(arr[b] > arr[b+1])
                {
                    int temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;

                }

            }
        }

    }
}
