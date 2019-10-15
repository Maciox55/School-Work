import java.util.Random;

public class insertion {
    public static int arr[];
    public static Random random;

    public static void main(String[] args) {
        arr = new int[6];
        random = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = random.nextInt(500);
            System.out.print(arr[i] + ", ");


        }
        insertion(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void insertion(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int point = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > point)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = point;
            System.out.println();
            for (int k = 0; k < arr.length; k++)
            {
                System.out.print(arr[k] + ", ");
            }
        }
    }
}
