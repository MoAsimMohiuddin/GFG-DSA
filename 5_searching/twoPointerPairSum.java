public class twoPointerPairSum {
    public static void main(String[] args) {
        int[] arr={2,4,8,9,11,12,20,30};
        boolean res=efficientApproach(arr, 23);
        System.out.println(res);
    }

    public static boolean efficientApproach(int[] arr, int target)
    {
        int low=0, high=arr.length-1;

        while(low<=high)
        {
            if(arr[low]+arr[high]==target)
            {
                return true;
            }
            else if(arr[low]+arr[high]>target)
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
