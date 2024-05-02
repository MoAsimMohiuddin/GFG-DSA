public class PrintArray{
    public static void printArray(int[] arr)
    {
        int size=arr.length;
        System.out.println("Array is");
        for(int i=0; i<size; i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
}