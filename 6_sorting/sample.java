public class sample {
    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 9, 2};
        printArray(arr);
        qsLamutoPartition(arr, 0, arr.length-1, 7);
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

    public static void qsLamutoPartition(int[] arr, int low, int high, int k)
    {
        if(low>=high)
        {
            return;
        }

        if(low<high)
        {
            int pivot=LamutoPartition(arr, low, high, k);
            qsLamutoPartition(arr, low, pivot-1, k);
            qsLamutoPartition(arr, pivot+1, high, k);
        }
    }    

    public static int LamutoPartition(int[] arr, int low, int high, int k)
    {
        int index=low, pivot=arr[high];

        for(int i=low; i<=high; i++)
        {
            if(Math.abs(arr[i]-k)<Math.abs(pivot-k))
            {
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                index++;
            }
        }

        int temp=arr[index];
        arr[index]=arr[high];
        arr[high]=temp;

        return index;
    }
}
