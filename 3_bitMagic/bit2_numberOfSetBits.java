

public class bit2_numberOfSetBits {
    public static void main(String[] args) {
        int result=brianKerningamAlgorithm(15);
        System.out.println(result);
    }

    public static int setBits(int num)
    {
        int count=0;
        while(num>0)
        {
            if(num%2!=0)
            {
                count++;
            }
            num/=2;
        }
        return count;
    }

    public static int brianKerningamAlgorithm(int number)
    {
        int count=0;
        while(number>0)
        {
            number&=(number-1);
            count++;
        }
        return count;
    }
}
