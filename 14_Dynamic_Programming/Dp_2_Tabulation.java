public class Dp_2_Tabulation {
    public static void main(String[] args) {
        
    }

    static int nthFiboTabulation(int n) {
        int[] arr=new int[n+1];

        arr[0]=0; arr[1]=1;

        for(int i=2; i<=n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[n];
    }
}
