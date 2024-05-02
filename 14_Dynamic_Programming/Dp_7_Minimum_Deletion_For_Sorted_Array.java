public class Dp_7_Minimum_Deletion_For_Sorted_Array{
    public static void main(String[] args) {
        int[] sampleArray={10, 20, 30};
        System.out.println(method(sampleArray, sampleArray.length));
    }

    static int method(int[] arr, int n) {
        int liss=lis(arr, n);
        return n-liss;
    }

    static int lis(int[] arr, int n) {
        int[] lisArray=new int[n];

        lisArray[0]=1;

        int res=1;

        for(int i=1; i<n; i++) {
            int max=0;
            for(int j=i-1; j>=0; j--) {
                if(arr[j]<arr[i]) {
                    max=Math.max(max, lisArray[j]);
                }
            }

            lisArray[i]=max+1;

            res=Math.max(res, max+1);
        }

        return res;
    }
}