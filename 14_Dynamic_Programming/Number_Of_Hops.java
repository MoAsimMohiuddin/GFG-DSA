public class Number_Of_Hops {
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }

    static long countWays(int n)
    {
        // add your code here
        if(n==1) return 1;
        int[] dp=new int[n+1];
        
        dp[0]=1;dp[1]=1;dp[2]=2;
        
        for(int i=3; i<=n; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        
        return dp[n];
    }
}
