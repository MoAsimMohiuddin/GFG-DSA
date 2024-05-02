// Question: Given an Array, Find a peak element. An element is peak if it's greater than it's adjacent elements.
// We can skip one half of the array at every iteration because if the adjacent element is greater than the current element, Then there has to be a peak element at the adjacent half of the array.

public class peakElement{
    public static void main(String[] args)
    {
        int[] arr={1, 13};

        int res=naive(arr);
        System.out.println(res);
    }

    public static int naive(int[] arr)
    {
        if(arr[0]>arr[1])
        {
            return 0;
        }
        
        if(arr[arr.length-1]>arr[arr.length-2])
        {
            return arr.length-1;
        }
        int low=0, high=arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if( (mid==0 && arr[mid]>arr[mid+1]) || (mid==arr.length-1 && arr[mid]>arr[mid-1]))
            {
                return mid;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            else if(arr[mid-1]>arr[mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return -1;
    }
}