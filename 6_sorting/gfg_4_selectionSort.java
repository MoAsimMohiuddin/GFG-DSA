public class gfg_4_selectionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Array before sorting : ");
        printArray(arr);
        selectionSortt(arr);
        System.out.println("Array after sorting : ");
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        // Finding maximum element.
        int index=-1;

        for (int i = arr.length-1; i >= 0; i--)
        {
            index=i;
            for (int j = 0; j <=i; j++)
            {
                if (arr[j] > arr[index]) {
                    index=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void selectionSortt(int[] arr) {
        // Finding minimum element.
        int index=-1;

        for (int i = 0; i < arr.length; i++)
        {
            index=i;
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[j] < arr[index]) {
                    index=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int k : arr) {
            System.out.print(k + ", ");
        }
        System.out.println();
    }
}
