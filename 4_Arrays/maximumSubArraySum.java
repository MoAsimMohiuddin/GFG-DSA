public class maximumSubArraySum{
    public static void main(String[] args)
    {
        int[] arr={1, -2, 10, 20, -30, -100, 5000};
        int result=naiveSolution(arr);
        System.out.println(result);
    }

    public static int naiveSolution(int[] arr)
    {
        int curSum=0, maxSum=0;

        for(int i=0; i<arr.length; i++)
        {
            curSum=0;
            for(int j=i+1; j<arr.length; j++)
            {
                curSum+=arr[j];
                if(curSum>maxSum)
                {
                    maxSum=curSum;
                }
            }
        }

        return maxSum;
    }

    public static int kadanesAlgortihm(int[] arr)
    {
        int curSum=arr[0], maxSum=arr[0];

        for(int i=1; i<arr.length; i++)
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

        return maxSum;
    }
}