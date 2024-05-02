public class missingNumber {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,3,7,8};
        int res=effMethod(arr);
        System.out.println(res);
    }

    public static int effMethod(int[] arr) {
        int size=arr.length;

        for(int i=0; i<size; i++) {
            while((arr[i]>=1 && arr[i]<=size) && arr[i]!=arr[arr[i]-1]) {
                int temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
        }

        for(int i=0; i<size; i++) {
            if(arr[i]!=i+1) {
                return i+1;
            }
        }

        return size+1;
    }
}
