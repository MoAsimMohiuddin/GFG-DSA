public class gfg_12_quickSort {
    public static void main(String[] args)
    {
        int[] arr={4,3,2};
        printArray(arr);
        int res=LamutoPartition(arr, 0, arr.length-1); 
        printArray(arr);
        System.out.println(res);
    }

    public static void qsLamutoPartition(int[] arr, int low, int high)
    {
        if(low>=high)
        {
            return;
        }

        if(low<high)
        {
            int pivot=LamutoPartition(arr, low, high);
            qsLamutoPartition(arr, low, pivot-1);
            qsLamutoPartition(arr, pivot+1, high);
        }
    }    

    public static int LamutoPartition(int[] arr, int low, int high)
    {
        int index=low, pivot=arr[high];

        for(int i=low; i<=high; i++)
        {
            if(arr[i]<pivot)
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

    public static void qsHoarePartition(int[] arr, int low, int high)
    {
        if(low>=high)
        {
            return;
        }

        if(low<high)
        {
            int pivot=hoarePartition(arr, low, high);
            qsHoarePartition(arr, low, pivot);
            qsHoarePartition(arr, pivot+1, high);
        }
    }

    public static int hoarePartition(int[] arr, int low, int high)
    {
        int l=low-1, h=high-1;
        int pivot=arr[low];        

        while(true)
        {
            do
            {
                l++;
            }
            while(arr[low]<pivot);

            do
            {
                h--;
            }
            while(arr[high]>pivot);

            if(l>=h)
            {
                return h;
            }

            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
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
}

/*
-> Space analysis of QuickSort:
Quicksort is an In place sorting algorithm if recursion call stack is ignored O(1). Since the array is partitioned inside itself withoout using any extra space.
If recursion call stack is considered, Quicksort has a Auxillary space of O(n). Because in the worst case, There will be n number of recursion activation records in the recursion call stack.

-> Stability in QuickSort:
If we use Naive partition to implement quicksort, We can assure stability while sorting. Since we use extra space, The original position of equal elements is not changed. So, Quicksort with Naive partition is stable sorting algorithm.
If we use lamuto or hoares partition to implement quickort, Stability is ignored.
But lamuto and hoares partition quicksort is inplace, Whereas naive partition is not.

-> Time complexity of QuickSort:
In best case, The time complexity for quicksort is O(nlogn). In this case, At every step the array is divided into two equal halves and partition is performed.
In worst case, The time complexity for quicksort is O(n*n). In this case, At every step the array is decreased by 1 size and partition is performed at every step. Resulting in O(n*n).
But, The average time complexity for quicksort is o(nlogn). To Analyse average time complexity for quicksort, We need to consider every permutation for an array, Calculate time complexity for it, Add all the time complexities for that array and divide it with the number of permutations.
*/


