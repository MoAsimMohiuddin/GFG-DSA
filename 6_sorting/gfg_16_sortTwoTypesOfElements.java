import java.util.Arrays;

public class gfg_16_sortTwoTypesOfElements {
    public static void main(String[] args)
    {
        int[] arr={15,14,13,12};
        printArray(arr);
        sortEvenOdd(arr);
        printArray(arr);
    }

    public static void sortEvenOdd(int[] arr)
    {
        //Put even elements first then odd elements.
        int index=0;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]%2==0)
            {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
        }

        Arrays.sort(arr, 0, index);
        Arrays.sort(arr, index+1, arr.length);
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
