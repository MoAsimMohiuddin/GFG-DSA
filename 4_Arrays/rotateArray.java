public class rotateArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        printArray(arr);
        rotate(arr, 5);
        printArray(arr);
    }

    public static void rotate(int[] arr, int k)
    {
        int low=0, high=arr.length-k-1;

        while(low<=high)
        {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }

        low=arr.length-k;
        high=arr.length-1;

        while(low<=high)
        {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }

        low=0;
        high=arr.length-1;

        while(low<=high)
        {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
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
