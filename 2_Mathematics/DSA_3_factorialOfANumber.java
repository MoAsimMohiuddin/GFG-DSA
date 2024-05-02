public class DSA_3_factorialOfANumber {
    public static void main(String[] args)
    {
        int result1=iterativeApproach(5);
        int result2=recursiveApproach(5);
        System.out.println("Result1 : "+result1);
        System.out.println("Result2 : "+result2);
    }

    public static int iterativeApproach(int num)
    {
        int fact=1;
        for(int i=1; i<=num; i++)
        { 
            fact=fact*i;
        }
        return fact;
    }

    public static int recursiveApproach(int num)
    {
        if(num==0)
        {
            return 1;
        }
        else
        {
            return(num*recursiveApproach(num-1));
        }
    }
}
