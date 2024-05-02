public class DSA_2_palindromeNumber {
    public static void main(String[] args)
    {
        boolean result=checkPalindrome(1234);
        System.out.println(result);
    }

    public static boolean checkPalindrome(int num)
    {
        int res=0, rem=0, temp=num;

        while(temp>0)
        {
            rem=temp%10;
            res=res*10+rem;
            temp/=10;
        }

        System.out.println("Palindrome is "+res);
        if(res==num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
