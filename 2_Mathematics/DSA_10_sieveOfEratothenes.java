import java.util.Arrays;

public class DSA_10_sieveOfEratothenes{
    public static void main(String[] args)
    {
        sieve(27);
    }

    public static void primeTillN(int n)
    {
        int i;
        int count=0;
        for(i=2; i<=n; i++)
        {
            count=0;
            for(int j=1; j<=i; j++)
            {
                if(i%j==0)
                {
                    count++;
                }
            }
            if(count<=2)
            {
                System.out.print(i+" ");
            }
        }
        System.out.println("");
    }

    public static void sieve(int n)
	{
	    boolean[] myArray=new boolean[n+1];
	    Arrays.fill(myArray, true);
	    
	    for(int i=2; i<=n; i++)
	    {
	        if(myArray[i]==true)
	        {
	            for(int j=i*i; j<=n; j+=i)
	            {
	                myArray[j]=false;
	            }
	        }
	    }
	    
	    for(int i=2; i<myArray.length; i++)
	    {
	        if(myArray[i]==true)
	        {
	            System.out.print(i+" ");
	        }
	    }
	}
}