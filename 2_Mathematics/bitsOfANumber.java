public class bitsOfANumber {
    public static void main(String[] args) {
        String result=bits(8);
        System.out.println(result);
    }

    public static String bits(int number)
    {
        String resultantString="";
        while(number>0)
        {
            if(number%2==0)
            {
                resultantString+="0";
            }
            else
            {
                resultantString+="1";
            }
            number/=2;
        }
        String myStr="";
        for(int i=resultantString.length()-1; i>=0; i--)
        {
            myStr=myStr+resultantString.charAt(i);
        }
        return myStr;
    }
}
