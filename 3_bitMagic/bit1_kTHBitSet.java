public class bit1_kTHBitSet {
    public static void main(String[] args)
    {
        boolean result=efficeintMethodUsingRightShift(8, 4);
        System.out.println(result);
    }

    public static boolean setOrNot(int number, int k)
    {
        boolean mybool=false;
        int count=0;
        while(count<k)
        {
            if(number%2==0)
            {
                mybool=false;
            }
            else
            {
                mybool=true;
            }
            number/=2;
            count++;
        }

        return mybool;
    }

    public static boolean efficeintMethodUsingLeftShift(int x, int k)
    {
        if((x & (1<<(k-1)))!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean efficeintMethodUsingRightShift(int x, int k)
    {
        if((x>>(k-1)%1)!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
