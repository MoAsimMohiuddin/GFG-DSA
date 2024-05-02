public class bit3_powerOfTwo {
    public static void main(String[] args)
    {
        boolean result=efficientSolution(256);
        System.out.println(result);
    }

    public static boolean powerOfTwo(int number)
    {
        // O(logn) time complexity
        int i=0;
        while(Math.pow(2, i)<=number)
        {
            if(number==Math.pow(2, i))
            {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean mySetBitsSolution(int number)
    {
        // This approach is implemented using Brian Kerningam's algorithm.
        // My Approach
        // O(number of setBits) time complexity
        int count=0;
        while(number>0)
        {
            number=number&(number-1);
            count++;
        }
        if(count==1)
        {
            return true;
        }
        return false;
    }

    public static boolean naiveSolution(int number)
    {
        while(number>0)
        {
            if(number%2!=0)
            {
                return false;
            }
            number/=2;
        }
        return true;
    }

    public static boolean efficientSolution(int number)
    {
        if(number==0)
        {
            return true;
        }
        return((number&(number-1))==0);
    }
}
