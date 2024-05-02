class Cupcakes_Virtusa {
    public static void main(String[] args) {
        int[] arr={1, 2, 3};
        System.out.println(method(arr));
    }

    static int method(int[] arr) {
        return helper(arr, 0,  0, arr.length);
    }

    static int helper(int[] arr, int result, int index, int n) {
        if(index==n) {
            if(result%2==0) return 1;
            else return 0;
        }

        int[] addedArray=new int[n];

        for(int i=0; i<=index; i++) addedArray[i]=arr[i];
        for(int i=index+1; i<n; i++) addedArray[i]=arr[i]+arr[index];

        return helper(addedArray, result+arr[index], index+1, n)+helper(arr, result, index+1, n);
    }
}