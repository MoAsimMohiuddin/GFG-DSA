public class prr {
    public static void main(String[] args) {
        int[] arr={10, 15, 20, 11, 30};
        printArray(arr);
        sort(arr, 0, arr.length-1);
        printArray(arr);  
    }   

    public static void sort(int[] arr, int low, int high)
    {
        int mid=(low+high)/2;

        int[] arr1=new int[low-mid+1];
        int[] arr2=new int[high-mid];

        int index1=0, index2=0;
        for(int i=low; i<=high; i++)
        {
            if(i<=mid)
            {
                arr1[index1++]=arr[low+i];
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
            if(l>=arr1.length && h<arr2.length)
            {
                while(h<arr.length)
                {
                    arr[resIndex++]=arr2[h++];
                }
                break;
            }
            else if(h>=arr2.length && l<arr1.length)
            {
                while(l<arr1.length)
                {
                    arr[resIndex++]=arr1[l++];
                }
                break;
            }
            
            if(arr1[l]<=arr2[h])
            {
                arr[resIndex++]=arr[l++];
            }
            else
            {
                arr[resIndex++]=arr[h++];
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