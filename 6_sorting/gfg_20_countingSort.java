public class gfg_20_countingSort {
    public static void main(String[] args)
    {
        int[] arr={1,4,4,1,0,1,3,2,4,0,1,3,2,4,2,3,1,0};
        printArray(arr);
        naiveSolution(arr, 5);
        printArray(arr);
    }

    public static void naiveSolution(int[] arr, int k)
    {
        int[] newArr=new int[k];

        for(int i:arr)
        {
            newArr[i]++;
        }

        int index=0;
        for(int i=0; i<k; i++)
        {
            int count=newArr[i];
            while(count>0)
            {
                arr[index++]=i;
                count--;
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
