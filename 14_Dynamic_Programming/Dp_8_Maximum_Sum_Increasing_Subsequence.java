public class Dp_8_Maximum_Sum_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr={20, 10, 5};
        System.out.println(method(arr, arr.length));
    }

    static int method(int[] arr, int n) {
        int[] sumArray=new int[n];

        sumArray[0]=arr[0];

        int res=sumArray[0];

        for(int i=1; i<n; i++) {
            int max=0;

            for(int j=i-1; j>=0; j--) {
                if(arr[j]<arr[i]) {
                    max=Math.max(max, sumArray[j]);
                }
            }

            sumArray[i]=arr[i]+max;

            res=Math.max(res, sumArray[i]);
        }

        printArray(sumArray);
        return res;
    }

    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
