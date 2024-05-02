public class pairSumSortedRotated {
    public static void main(String[] args)
    {
        int[] arr={3,4,5,1,2};
        boolean result=meth(arr, 7);
        System.out.println(result);
    }
    
    static boolean meth(int[] arr, int target)
    {
        int low=0, high=arr.length-1;

        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                low=i+1;
                high=i;
            }
        }

        while(low!=high)
        {
            if(low>arr.length-1)
            {
                low=0;
            }

            if(high<0)
            {
                high=arr.length-1;
            }

            int sum=arr[low]+arr[high];
            if(sum==target)
            {
                return true;
            }
            else if(sum>target)
            {
                high--;
            }
            else
            {
                low++;
            }
        }

        return false;
    }

    public static boolean method(int[] arr, int target)
    {
        int low=0, high=arr.length-1;
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                low=i+1;
                high=i;
            }
        }

        while(low!=high)
        {
            if(low>arr.length-1)
            {
                low=0;
            }

            if(high<0)
            {
                high=arr.length-1;
            }

            int sum=arr[low]+arr[high];
            if(sum==target)
            {
                System.out.println("low="+low+", high="+high);
                return true;
            }
            else if(sum>target)
            {
                high--;
            }
            else
            {
                low++;
            }
        }

        return false;
    }
}
