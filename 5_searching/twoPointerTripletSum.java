public class twoPointerTripletSum {
    public static void main(String[] args) {
        int[] arr={2,3,4,8,9,20,40};
        int target=32;

        boolean res=efficientApproach(arr, target);
        System.out.println(res);
    }

    public static boolean efficientApproach(int[] arr, int target)
    {
        for(int i=0; i<arr.length-2; i++)
        {
            if(doubletSum(arr, i, target))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean doubletSum(int[] arr, int l, int target)
    {
        int low=l+1, high=arr.length-1;

        while(low<high)
        {
            if(arr[l]+arr[low]+arr[high]==target)
            {
                return true;
            }
            else if(arr[l]+arr[low]+arr[high]>target)
            {
                high-=1;
            }
            else
            {
                low+=1;
            }
        }

        return false;
    }
}
