public class gfg_3_bubbleSort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Array before sorting : ");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Array after sorting : ");
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean sorted=false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted=true;
                }
            }

            if(sorted==false)
            {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int k : arr) {
            System.out.print(k + ", ");
        }
        System.out.println();
    }
}