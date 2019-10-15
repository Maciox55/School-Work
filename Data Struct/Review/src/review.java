public class review {
    public static void main(String[] args) {
        System.out.println(Fibo(12));
    }

    static int Fibo(int n)
    {
        if( n<= 1)
        {
            return n;
        }else
        {
            return Fibo(n-1)+Fibo(n-2);

        }

    }

}
