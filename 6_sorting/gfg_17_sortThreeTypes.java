public class gfg_17_sortThreeTypes {
    public static void main(String[] args)
    {
        int[] arr={0,1,0,0,2,0,1,0,2};
        printArray(arr);
        sort0s1s2s(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static void sort0s1s2s(int[] arr)
    {
        int low=0, mid=0, high=arr.length-1;

        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                mid++;
                low++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else
            {
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
    }

    public static void sortt(int[] arr, int pivotIndex)
    {
        //sort around a pivot. And all elements equal to pivot together.

        int index=0, pivot=arr[pivotIndex];

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<pivot)
            {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
        }

        
        int temp=arr[index];
        arr[index]=arr[pivotIndex];
        arr[pivotIndex]=temp;

        int indexPivot=index+1;
        for(int i=index+1; i<arr.length; i++)
        {
            if(arr[i]==pivot)
            {
                temp=arr[i];
                arr[i]=arr[indexPivot];
                arr[indexPivot]=temp;
                indexPivot++;
            }
        }
    }
}
