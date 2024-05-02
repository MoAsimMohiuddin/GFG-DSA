import java.util.Arrays;

public class Dp_4_Coin_Change {
    public static void main(String[] args) {
        int[] arr={1,2,3};

        int[][] memo=new int[arr.length][5];
        for(int[] k: memo) {
            Arrays.fill(k, -1);
        }

        System.out.println(tabulationMethod(arr, 4));
    }

    static int recursiveSolution(int[][] memo, int[] arr, int endIndex, int sum) {
        if(endIndex<0 || sum<0) return 0;
        else if(memo[endIndex][sum]==-1){
            int res=0;

            if(sum==0) res=1;

            res+=recursiveSolution(memo, arr, endIndex, sum-arr[endIndex])+recursiveSolution(memo, arr, endIndex-1, sum);

            memo[endIndex][sum]=res;
        }
        return memo[endIndex][sum];
    }

    static int recur(int[] arr, int endIndex, int sum) {
        if(endIndex<0 || sum<0) return 0;
        if(sum==0) return 1;

        return recur(arr, endIndex, sum-arr[endIndex])+recur(arr, endIndex-1, sum);
    }

    static int tabulationMethod(int[] arr, int sum) {
        int[][] tab=new int[arr.length+1][sum+1];
        int len=arr.length;

        for(int i=0; i<arr.length; i++) {
            tab[i][0]=1;
        }

        for(int i=1; i<=len; i++) {
            for(int j=1; j<=sum; j++) {
                if(arr[i-1]<=j) {
                    tab[i][j]=tab[i-1][j]+tab[i][j-arr[i-1]];
                }else{
                    tab[i][j]=tab[i-1][j];
                }
            }
        }

        return tab[len][sum];
    }
}
