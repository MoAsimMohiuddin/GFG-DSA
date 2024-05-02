public class gfg_8_mergeSort {
    public static void main(String[] args)
    {
        int[] arr={12, 34, 0, -1212, 12312, 234, 23, 23};
        System.out.println("Array before sorting : ");
        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Array after sorting : ");
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int low, int high)
    {
        if(high>low)
        {
            int mid=(low+high)/2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, high);
        }
    }

    // public static void merge(int[] arr, int low, int mid, int high)
    // {
    //     int[] arr1=new int[mid-low+1];
    //     int[] arr2=new int[high-mid];

    //     int index1=0, index2=0;
    //     for(int i=low; i<=high; i++)
    //     {
    //         if(i<=mid)
    //         {
    //             arr1[index1++]=arr[i];
    //         }
    //         else
    //         {
    //             arr2[index2++]=arr[i];
    //         }
    //     }
    //     int resIndex=low;

    //     int l=0, h=0;

    //     // My code:
    //     while(l<arr1.length || h<arr2.length)
    //     {
    //         if(l>=arr1.length)
    //         {
    //             while(h<arr2.length)
    //             {
    //                 arr[resIndex++]=arr2[h++];
    //             }
    //             break;
    //         }
    //         if(h>=arr2.length)
    //         {
    //             while(l<arr1.length)
    //             {
    //                 arr[resIndex++]=arr1[l++];
    //             }
    //             break;
    //         }
    //         if(arr1[l]<=arr2[h])
    //         {
    //             arr[resIndex++]=arr1[l++];
    //         }
    //         else
    //         {
    //             arr[resIndex++]=arr2[h++];
    //         }
    //     }

    //     // GFG Code:
    //     // while(l<arr1.length && h<arr2.length)
    //     // {
    //     //     if(arr1[l]<=arr2[h])
    //     //     {
    //     //         arr[resIndex++]=arr1[l++];
    //     //     }
    //     //     else
    //     //     {
    //     //         arr[resIndex++]=arr2[h++];
    //     //     }
    //     // }

    //     // while(l<arr1.length)
    //     // {
    //     //     arr[resIndex++]=arr1[l++];
    //     // }
    //     // while(h<arr2.length)
    //     // {
    //     //     arr[resIndex++]=arr2[h++];
    //     // }
    // }

    public static void merge(int[] arr, int low, int high)
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
        for(int k=low; k<=high; k++)
        {
            arr[k]=newArr[index++];
        }
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");;
        }
        System.out.println();
    }
}
