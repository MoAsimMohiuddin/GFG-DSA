public class maximumOccuredInteger {
    public static void main(String[] args)
    {

    }

    public static int efficientSolution(int[] L, int[] R)
    {
        /* We create an Additional frequency Array which is initially filled with zeros.
        Then we traverse through the One element from each Array(L & R) which represents the ranges,
        We increment the Starting Point by 1 and decrement the Ending Point by 1.
        Then we traverse through it and calculate the preSum of the Array simultaneously. Whenever we find
        the preSum as the highest, We update it in another variable and return the maximum occured integer.
        */
        int size=L[0];
        for(int i=0; i<L.length; i++)
        {
            if(L[i]>size)
            {
                size=L[i];
            }
            if(R[i]>size)
            {
                size=R[i];
            }
        }
        
        int [] freq=new int[size+2];
        
        for(int i=0; i<L.length; i++)
        {
            freq[L[i]]++;
            freq[R[i]+1]--;
        }
        
        int maxEl=freq[0], pSum=freq[0], maxSum=freq[0];
        for(int i=1; i<freq.length; i++)
        {
            pSum+=freq[i];
            if(pSum>maxSum)
            {
                maxSum=pSum;
                maxEl=i;
            }
        }
        
        return maxEl;
    }
}
