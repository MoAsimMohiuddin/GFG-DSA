public class gfg_1_palidromeCheck {
    public static void main(String[] args)
    {
        String str="abba";
        boolean result=palindrome(str);
        System.out.println(result);
    }
    
    public static boolean palindrome(String str)
    {
        int low=0, high=str.length()-1;

        while(low<high)
        {
            if(str.charAt(low++)!=str.charAt(high--))
            {
                return false;
            }
        }

        return true;
    }
}
