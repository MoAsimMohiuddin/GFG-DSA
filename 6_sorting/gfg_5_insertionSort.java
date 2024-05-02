public class gfg_5_insertionSort
{
    public static void main(String[] args)
    {
        int[] arr={20, 5, 40, 60, 10, 30};
        insertionSort(arr);
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr)
    {
        for(int i=1; i<arr.length; i++)
        {
            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    
    public static void insertionSortt(int[] arr)
    {
        for(int i=1; i<arr.length; i++)
        {
            int j=i-1;
            int index=i;

            if(arr[i]<arr[i-1])
            {
                while(j>=0)
                {
                    if(arr[index]<arr[j])
                    {
                        int temp=arr[j];
                        arr[j]=arr[index];
                        arr[index]=temp;
                        index=j;
                    }
                    j--;
                }
            }
        }
    }
}