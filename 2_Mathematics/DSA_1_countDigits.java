public class DSA_1_countDigits{
    public static void main(String[] args)
    {
        int result=countNumberOfDigits(1234);
        System.out.println(result);
    }

    public static int countNumberOfDigits(int num)
    {
        int count=0;
        while(num>0)
        {
            count++;
            num/=10;
        }
        return count;
    }
}