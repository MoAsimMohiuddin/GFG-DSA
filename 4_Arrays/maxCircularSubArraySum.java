public class maxCircularSubArraySum {
    public static void main(String[] args)
    {
        int[] arr={-12, -14};
        int result=efficientSolution(arr);
        System.out.println(result);
    }

    public static int naiveSolution(int[] arr)
    {
        int curSum=0, maxSum=0;

        //Naive Solution for finding maximum sum of normal subarray.
        for(int i=0; i<arr.length; i++)
        {
            curSum=0;
            for(int j=i; j<arr.length; j++)
            {
                curSum+=arr[j];
                if(curSum>maxSum)
                {
                    maxSum=curSum;
                }
            }
        }

        //Naive Solution for finding maximum sum of circular subarray.
        for(int i=1; i<arr.length; i++)
        {
            curSum=0;
            System.out.println("---- CIRCULAR SUBARRAY STARTING FROM "+arr[i]);
            for(int j=i; j<arr.length; j++)
            {
                curSum+=arr[j];
                if(curSum>maxSum)
                {
                    maxSum=curSum;
                }
                System.out.println("Currently "+arr[j]+", curSum="+curSum);

                if(j==arr.length-1)
                {
                    j=-1;
                }

                if(j==i-1)
                {
                    break;
                }
            }
        }

        return maxSum;
    }

    public static int efficientSolution(int[] arr)
    {
        int curSum=0, maxSum=0;

        // Efficient Solution for finding maximum sum of normal subArray. (Kadane's Algorithm).
        for(int i=0; i<arr.length; i++)
        {
            if(curSum+arr[i]>arr[i])
            {
                curSum+=arr[i];
            }
            else
            {
                curSum=arr[i];
            }
            if(curSum>maxSum)
            {
                maxSum=curSum;
            }
        }

        // Efficient Solution for finding maximum sum of circular subArray:
        // In this solution, We find the Minimum subArray sum and subtract it from the whole array sum. This will give us the maximum sum of circular subArray.
        curSum=0;
        int minSum=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            if(curSum+arr[i]<arr[i])
            {
                curSum+=arr[i];
            }
            else
            {
                curSum=arr[i];
            }

            if(curSum<minSum)
            {
                minSum=curSum;
            }
        }

        System.out.println("Minimum subArray Sum is :"+minSum);
        int totalSum=0;
        for(int k:arr)
        {
            totalSum+=k;
        }
        System.out.println("TotalSum="+totalSum);
        int maxCSum=totalSum-minSum;

        if(maxCSum>maxSum)
        {
            return maxCSum;
        }
        else
        {
            return maxSum;
        }
    }
}
