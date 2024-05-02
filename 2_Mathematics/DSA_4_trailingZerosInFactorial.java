public class DSA_4_trailingZerosInFactorial {
    public static void main(String[] args)
    {
        int result1=normalApproach(10);
        int result2=efficientApproach(10);
        System.out.println("Result1 : "+result1);
        System.out.println("Result2 : "+result2);
    }

    public static int normalApproach(int num)
    {
        int count=0;
        int fact=1;
        for(int i=1; i<=num; i++)
        {
            fact*=i;
        }

        while(fact%10==0)
        {
            count++;
            fact/=10;
        }
        return count;
    }

    public static int efficientApproach(int num)
    {
        /* The number of trailing zeros in n! is equal to floor value of (n/5)+(n/25)+(n/125)+.....+(n/5*i) until denominator is greater that n.
        */

        int res=0;
        for(int i=5; i<num; i*=5)
        {
            res=res+num/i;
        }
        return res;
    }
}
