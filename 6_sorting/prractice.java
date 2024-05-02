public class prractice
{
    public static void main(String[] args)
    {
        int[] arr={3,5,4,2,9};
        System.out.println(kthSmallest(arr, arr.length, 3));
    }
    //Function to find the kth smallest element in the array.
    public static int kthSmallest(int arr[], int n, int k)
    {
        // Your code here
        int result=mergeSort(arr, 0, arr.length-1, k);
        return result;
    }
    
    public static int mergeSort(int[] arr, int low, int high, int k)
    {
        int result=0;
        if(high>low)
        {
            int mid=(low+high)/2;

            result+=mergeSort(arr, low, mid, k);
            if(result!=0)
            {
                return result;
            }
            result+=mergeSort(arr, mid+1, high, k);
            if(result!=0)
            {
                return result;
            }
            result+=merge(arr, low, high, k);
            if(result!=0)
            {
                return result;
            }
        }
        
        return result;
    }
    
    public static int merge(int[] arr, int low, int high, int k)
    {
        int mid=(low+high)/2;
        int i=low, j=mid+1, index=0;
        int [] newArr=new int[high-low+1];
        
        while(i<=mid && j<=high)
        {
            if(arr[j]<arr[i])
            {
                newArr[index++]=arr[j++];
            }
            else
            {
                newArr[index++]=arr[i++];
            }
        }
        
        while(i<=mid)
        {
            newArr[index++]=arr[i++];
        }
        while(j<=high)
        {
            newArr[index++]=arr[j++];
        }
        
        index=0;
        for(int x=low; x<=high; x++)
        {
            arr[x]=newArr[index++];
        }
        
        if(k-1>=low && k-1<=high)
        {
            System.out.println("low="+low+", high="+high+". So, "+arr[k-1]+" is returned");
            return arr[k-1];
        }
        else
        {
            return 0;
        }
    }
}