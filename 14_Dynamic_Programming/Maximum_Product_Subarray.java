public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr={4, -6, -10, -11};
        System.out.println(dpSolution(arr));
    }

    static int bruteForce(int[] arr, int n) {
        int result=1;

        for(int i=0; i<n; i++) {
            int product=1;

            for(int j=i; j<n; j++) {
                product*=arr[j];
                result=Math.max(result, product);
            }
        }

        return result;
    }

    static int dpSolution(int[] arr) {
        int result=Integer.MIN_VALUE, curMin=1, curMax=1;

        for(int k: arr) result=Math.max(result, k);


        for(int k: arr) {
            if(k==0) {
                curMin=1;curMax=1;
                continue;
            }

            int temp=curMax;
            curMax=Math.max(k*curMax, Math.max(k*curMin, k));
            curMin=Math.min(k*temp, Math.min(k*curMin, k));
            result=Math.max(curMax, result);
        }

        return result;
    }
}
