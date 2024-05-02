public class gfg_7_sortingSubArraysLowHigh {
    public static void main(String[] args)
    {
        int[] arr={10, 15, 20, 11, 30};
        printArray(arr);
        efficientMethod(arr, 1, 3);
        printArray(arr);
    }

    public static void efficientMethod(int[] arr, int low, int high)
    {
        int mid=(low+high)/2, index1=0, index2=0;
        int[] arr1=new int[mid-low+1];
        int[] arr2=new int[high-mid];

        for(int i=low; i<=high; i++)
        {
            if(i<=mid)
            {
                arr1[index1++]=arr[i];
            }
            else
            {
                arr2[index2++]=arr[i];
            }
        }
        int resIndex=low;

        int l=0, h=0;

        while(l<arr1.length || h<arr2.length)
        {
            if(l>=arr1.length)
            {
                for(int i=h; i<arr2.length; i++)
                {
                    arr[resIndex++]=arr2[h];
                }
                break;
            }
            else if(h>=arr2.length)
            {
                for(int i=l; i<arr1.length; i++)
                {
                    arr[resIndex++]=arr1[l++];
                }
                break;
            }
            if(arr1[l]<=arr2[h])
            {
                arr[resIndex]=arr1[l];
                resIndex++;
                l++;
            }
            else if(arr2[h]<arr1[l])
            {
                arr[resIndex]=arr2[h];
                resIndex++;
                h++;
            }
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
