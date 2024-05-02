import java.util.Arrays;

public class Dp_10_Maximum_Cuts {
    public static void main(String[] args) {
        int[] memo=new int[6];
        Arrays.fill(memo, -1);
        System.out.println(tabulationSolution(5, 1, 2, 3));
    }

    static int method(int[] memo, int result, int count, int a, int b, int c) {
        if(result<0) return -count-1;
        if(memo[result]==-1) {
            int res;
            if(result==0) res=0;
            else{
                res=Math.max(1+method(memo, result-a, count+1, a, b, c), Math.max(1+method(memo, result-b, count+1, a, b, c), 1+method(memo, result-c, count+1, a, b, c)));
            }

            memo[result]=res;
        }

        return memo[result];
    }

    static int tabulationSolution(int n, int a, int b, int c) {
        int[] dp=new int[n+1];
        dp[0]=0;

        for(int i=1; i<=n; i++) {
            dp[i]=-1;
            
            if(i-a>=0) dp[i]=Math.max(dp[i], dp[i-a]);
            if(i-b>=0) dp[i]=Math.max(dp[i], dp[i-b]);
            if(i-c>=0) dp[i]=Math.max(dp[i], dp[i-c]);

            if(dp[i]!=-1) dp[i]++;
        }

        return dp[n];
    }
}
