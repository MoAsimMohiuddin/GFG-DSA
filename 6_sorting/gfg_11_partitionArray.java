public class gfg_11_partitionArray {
    public static void main(String[] args)
    {
        int[] arr={3,2,1,4};
        printArray(arr);
        hoarePartition(arr, 0, arr.length-1);
        printArray(arr);
        // System.out.println(res);
    }

    public static void partition(int[] arr, int k)
    {
        int[] newArr=new int[arr.length];
        int index=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<=arr[k])
            {
                newArr[index++]=arr[i];
            }
        }

        // newArr[index++]=arr[k];

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>arr[k])
            {
                newArr[index++]=arr[i];
            }
        }

        for(int i=0; i<arr.length; i++)
        {
            arr[i]=newArr[i];
        }
    }

    public static void lamutoPartition(int[] arr, int low, int high)
    {
        // We assume the pivot to be the high element of the array.

        int pivot=arr[high], index=low;

        for(int i=low; i<high; i++)
        {
            if(arr[i]<pivot)
            {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
        }

        int temp=arr[high];
        arr[high]=arr[index];
        arr[index]=temp;
    }
    public static void lamutoPartitionPivot(int[] arr, int low, int high, int indexx)
    {
        // We assume the pivot to be the high element of the array.

        int pivot=arr[indexx], index=low;

        for(int i=low; i<=high; i++)
        {
            if(arr[i]<pivot)
            {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                if(index==indexx)
                {
                    indexx=i;
                }
                index++;
            }
        }

        int temp=arr[indexx];
        arr[indexx]=arr[index];
        arr[index]=temp;
    }

    public static void hoarePartition(int[] arr, int l, int h)
    {
        int pivot=arr[l], low=l-1, high=h+1;
        while(true)
        {
            do
            {
                low++;
            }
            while(arr[low]<pivot);

            do
            {
                high--;
            }
            while(arr[high]>pivot);

            if(low>=high)
            {
                break;
            }
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
        }
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static int par(int[] arr, int low, int high)
    {
        int index=0, pivot=arr[high];

        for(int i=low; i<=high; i++)
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
        arr[index]=arr[high];
        arr[high]=temp;

        return index;
    }
}