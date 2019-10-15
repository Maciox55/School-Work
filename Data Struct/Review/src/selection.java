import java.util.Random;

public class selection {
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
        selection();
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void selection(){
        for(int i = 0; i<arr.length-1; i++){
            int min = i;
            for(int j = i+1; j<arr.length; j++)
            {
                if(arr[j]<arr[min])
                {
                    min = j;
                }
                int temp = arr[min];
                arr[min]=arr[i];
                arr[i] = temp;

            }
            System.out.println();
            for (int z = 0; z < arr.length; z++)
            {
                System.out.print(arr[z] + ", ");
            }
        }

    }
}
