public class searchInASortedRotatedArray {
    public static void main(String[] args) {
        
    }   

    public static int efficientApproach(int[] arr, int target)
    {
        // In this approach, Each time we skip either the sorted half of the array or the unsorted half of the array depending on the key to search.
        int low=0, high=arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]==target)
            {
                return mid;
            }
            if(arr[mid]>arr[low] && (target>=arr[low] && target<arr[mid]))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            if(arr[mid]<arr[high] && (target>arr[mid] && target<=arr[high]))
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return -1;
    }
}
