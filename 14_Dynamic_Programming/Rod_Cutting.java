import java.util.Arrays;

public class Rod_Cutting {
    public static void main(String[] args) {
        int[] prices={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(method(8, prices));
    }

    static int method(int N, int[] prices) {

        int[][] memo = new int[N + 1][N + 1];
        for(int[] arr: memo) Arrays.fill(arr, -1);

        // return helperFunction(prices, N, 0, 0);
        // return memoization(memo, prices, N-1, N);

        return tabulation(prices, N);

    }

    static int helperFunction(int[] prices, int N, int index, int sum) {
        if(N==0) return sum;
        else if(N<0 || index>=N) return 0;
        return Math.max(
            helperFunction(prices, N-(index+1), index, sum+prices[index]),
            helperFunction(prices, N, index+1, sum)
        );
    }

    static int memoization(int[][] memo, int[] prices, int index, int N) {
        if(index==0) return prices[0]*N;
        if(memo[index][N]!=-1) return memo[index][N];

        int notTake=memoization(memo, prices, index-1, N);
        int take=Integer.MIN_VALUE;

        if((index+1)<=N) take=prices[index]+memoization(memo, prices, index, N-(index+1));

        memo[index][N]=Math.max(take, notTake);

        return memo[index][N];
    }

    static int tabulation(int[] prices, int N) {
        int[][] dp=new int[N][N+1];

        for(int i=0; i<=N; i++) {
            dp[0][i]=prices[0]*i;
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<=N; j++) {
                int notTake=dp[i-1][j];
                int take=Integer.MIN_VALUE;

                int rodLength=i+1;

                if(rodLength<=j) {
                    take=prices[i]+dp[i][j-rodLength];
                }

                dp[i][j]=Math.max(take, notTake);
            }
        }

        printArray(dp);
        return dp[N-1][N];
    }

    static void printArray(int[][] arr) {
        System.out.println("Start");
        for(int[] k: arr) {
            for(int i: k) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
        System.out.println("End");
    }
}
