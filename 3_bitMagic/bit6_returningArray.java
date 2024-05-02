public class bit6_returningArray {
    public static void main(String[] args)
    {
        String[] result=permutations("abc");
        System.out.println("The subsets are : ");
        for(int i=0; i<result.length; i++)
        {
            System.out.print(result[i]+" ");
        }
    }

    public static String[] permutations(String str)
    {
        int sizeOfString=str.length();
        int numberOfSubsets=power(2, sizeOfString);
        String[] resultantArray=new String[numberOfSubsets];
        int resultantArrayIndex=0;
        String tempString="";
        for(int i=0; i<numberOfSubsets; i++)
        {
            tempString="";
            for(int j=0; j<sizeOfString; j++)
            {
                if((i&(1<<j))!=0)
                {
                    tempString=tempString+str.charAt(j);
                }
            }
            resultantArray[resultantArrayIndex]=tempString;
            resultantArrayIndex++;
        }

        return resultantArray;
    }

    public static int power(int x, int n)
    {
        if(n==0)
        {
            return 1;
        }
        int temp=power(x, n/2);
        temp=temp*temp;
        if(n%2==0)
        {
            return temp;
        }
        else
        {
            return(temp*x);
        }
    }
}
