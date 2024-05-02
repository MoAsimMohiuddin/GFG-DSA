// Given a non-increasing sorted array(reverse sorted array), Find the number of 1s occuring in the array.

public class countOnesInBinaryArray {
    public static void main(String[] args)
    {
        int[] arr={0,0,0,0};
        int result=bs(arr);
        System.out.println(result);
    }

    public static int bs(int[] arr)
    {
        int size=arr.length;
        if(arr[size-1]==1)
        {
            return size;
        }

        int low=0, high=size-1, mid=0;

        while(low<=high)
        {
            mid=(low+high)/2;

            if(arr[mid]!=arr[mid+1])
            {
                break;
            }
            else if(arr[mid]==arr[mid+1] && arr[mid]==1)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        if(mid==0 && arr[0]==0)
        {
            return 0;
        }
        else
        {
            return mid+1;
        }
    }
}
