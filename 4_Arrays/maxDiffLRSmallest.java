public class maxDiffLRSmallest {
    public static void main(String[] args)
    {
        int[] arr = {2, 4, 8, 7, 7, 9, 3};
        int result=findMaxDiff(arr, arr.length);
        System.out.println(result);
    }

    static int findMaxDiff(int arr[], int n)
    {
	    // Your code here
	    int lSmallest=0, rSmallest=findRightSmallest(arr, 1), diff=Math.abs(lSmallest-rSmallest), maxDiff=diff;
	    
	    lSmallest=arr[0];
	    
	    if(rSmallest==arr[1])
	    {
	        rSmallest=findRightSmallest(arr, 2);
	    }
	    
	    for(int i=1; i<n-1; i++)
	    {
	        if(rSmallest==arr[i])
	        {
	            rSmallest=findRightSmallest(arr, i+1);
	        }
	        
            System.out.println("For arr[i]="+arr[i]+", lSmallest="+lSmallest+", rSmallest="+rSmallest);
	        diff=Math.abs(lSmallest-rSmallest);
	        maxDiff=Math.max(diff, maxDiff);
	        
	        if(arr[i]<lSmallest)
	        {
	            lSmallest=arr[i];
	        }
	    }
	    
        diff=Math.abs(lSmallest-0);
        maxDiff=Math.max(maxDiff, diff);

	    return maxDiff;
    }
    
    static int findRightSmallest(int[] arr, int k)
    {
        int size=arr.length, result=arr[size-1];
        
        for(int i=size-2; i>=k; i--)
        {
            if(arr[i]<result)
            {
                result=arr[i];
            }
        }
        
        return result;
    }
}
