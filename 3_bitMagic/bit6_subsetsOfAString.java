public class bit6_subsetsOfAString {
    public static void main(String[] args)
    {
        subsetsOfAString("asim");
    }

    public static void subsetsOfAString(String str)
    {
        int sizeOfString=str.length();
        int numberOfSubsets=power(2, sizeOfString);

        for(int i=0; i<numberOfSubsets; i++)
        {
            System.out.print("\"");
            for(int j=0; j<sizeOfString; j++)
            {
                if((i&(1<<j))!=0)
                {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.print("\"");
            System.out.println();
        }
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
