public class rotateArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        effSol(arr, 3);
        for(int k:arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static void effSol(int[] arr, int k) {
        int low=0, high=arr.length-1;

        while(low<high) {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }

        low=0;
        high=arr.length-k-1;
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }

        low=k-1;
        high=arr.length-1;
        while(low<high) {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
