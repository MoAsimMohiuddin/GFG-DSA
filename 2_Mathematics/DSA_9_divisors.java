public class DSA_9_divisors {
    public static void main(String[] args) {
        efficientApproachInSortedOrder(12);
    }

    public static void normalApproach(int n)
    {
        for(int i=1; i<=n; i++)
        {
            if(n%i==0)
            {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void efficientApproach(int n)
    {
        for(int i=1; i*i<=n; i++)
        {
            if(n%i==0)
            {
                System.out.print(i+" ");
                if(i!=n/i)
                {
                    System.out.print(n/i+" ");
                }
            }
        }
    }

    public static void efficientApproachInSortedOrder(int num)
    {
        int i;
        for(i=1; i*i<num; i++)
        {
            if(num%i==0)
            {
                System.out.print(i+" ");
            }
        }
        for(; i>=1; i--)
        {
            if(num%i==0)
            {
                System.out.print(num/i+" ");
            }
        }
    }
}
