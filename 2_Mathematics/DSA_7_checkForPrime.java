public class DSA_7_checkForPrime {
    public static void main(String[] args)
    {
        boolean r1=normalApproach(17);
        boolean r2=normalApproach(17);
        boolean r3=normalApproach(17);
        System.out.println("Result1 : "+r1);
        System.out.println("Result2 : "+r2);
        System.out.println("Result3 : "+r3);
    }

    public static boolean normalApproach(int num)
    {
        for(int i=2; i<num; i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean efficientApproach(int num)
    {
        if(num==1)
        {
            return false;
        }
        /*
        When a number is Composite, All of it's divisors come in pairs. If a divisor exists before sqrt(n), Then a divisor must exist after sqrt(n) as well. So, we don't need to check after sqrt(n).
         */
        for(int i=2; i*i<=num; i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean moreEfficientApproach(int num)
    {
        /*
        This approach is very similar to the above approach. But we add some test cases in this case which makes this algorithm a much better and efficient approach to check if the number is prime or not.
        if a number is a multiple of 2 or 3, Then It must be an composite number. If the number if not a multiple of 2 or 3, We can ignore the unnecesary comparisions to check if it's prime or not.
        */

        if(num==1)
        {
            return false;
        }
        if(num==2 || num==3)
        {
            return true;
        }
        if(num%2==0 || num%3==0)
        {
            return false;
        }

        for(int i=5; i*i<=num; i+=6)
        {
            if(num%i==0 || (num+2)%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
