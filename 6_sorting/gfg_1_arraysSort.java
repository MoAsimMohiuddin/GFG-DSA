import java.util.Arrays;

public class gfg_1_arraysSort {
    public static void main(String[] args)
    {
        int[] arr={5,4,3,2,1};
        char[] arr1={'e', 'd', 'c', 'b', 'a'};

        System.out.println("Array before sorting ");
        for(int el:arr)
        {
            System.out.print(el+", ");
        }
        System.out.println();

        Arrays.sort(arr);
        System.out.println("Array after sorting ");
        for(int el:arr)
        {
            System.out.print(el+", ");
        }
        System.out.println();

        System.out.println("Character array before sorting ");
        for(char k:arr1)
        {
            System.out.print(k+", ");
        }
        System.out.println();

        Arrays.sort(arr1);
        System.out.println("Character array after sorting ");
        for(char k:arr1)
        {
            System.out.print(k+", ");
        }
        System.out.println();

        // Arrays.sort(array, startingIndex, endingIndex) can be used to sort a specific part of the array. End index is not included.
    }
}
