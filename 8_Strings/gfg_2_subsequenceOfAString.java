public class gfg_2_subsequenceOfAString {
    public static void main(String[] args)
    {
        boolean result=recursiveEfficientSolution("ABCDE", "ADE", 5, 3);
        System.out.println(result);
    }

    public static boolean bitMethod(String str, String target)
    {
        int length=str.length(), subsequences=(int)Math.pow(2, str.length());

        for(int i=0; i<subsequences; i++)
        {
            String subseq="";
            for(int j=0; j<length; j++)
            {
                if((i&(1<<j))!=0)
                {
                    subseq+=str.charAt(j);
                }
            }
            System.out.println(subseq);
            if(subseq.equals(target))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean efficientSolution(String str, String target)
    {
        int index=0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)==target.charAt(index))
            {
                index++;
            }
        }

        return index==target.length();
    }

    public static boolean recursiveEfficientSolution(String str, String target, int n, int m)
    {
        if(m==0)
        {
            return true;
        }
        if(n==0)
        {
            return false;
        }

        if(str.charAt(m-1)==str.charAt(n-1))
        {
            return recursiveEfficientSolution(str, target, n-1, m-1);
        }
        else
        {
            return recursiveEfficientSolution(str, target, n-1, m);
        }
    }
}
