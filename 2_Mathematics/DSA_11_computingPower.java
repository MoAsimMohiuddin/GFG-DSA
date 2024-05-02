public class DSA_11_computingPower {
    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
    }

    public static int power(int x, int n)
    {
        int res=1;

        for(int i=1; i<=n; i++)
        {
            res=res*x;
        }
        return res;
    }

    public static int efficientSolution(int number, int exponent)
    {
        if(exponent==0)
        {
            return 1;
        }
        int temp=efficientSolution(number, exponent/2);
        temp=temp*temp;
        if(exponent%2==0)
        {
            return temp;
        }
        else
        {
            return(temp*number);
        }
    }
}
