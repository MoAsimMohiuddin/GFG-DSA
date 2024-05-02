public class indexOfFirstElement{
    public static void main(String[] args)
    {
        int[] arr={1,1,1,1,1,2,3};

        int res=sol(arr, 2);
        System.out.println(res);
    }

    public static int sol(int[] arr, int element)
    {
        int low=0, high=arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]==element)
            {
                if(mid==0)
                {
                    return mid;
                }
                
                while(mid>0 && arr[mid-1]==arr[mid])
                {
                    mid-=1;
                }

                return mid;
            }
            else if(arr[mid]>element)
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