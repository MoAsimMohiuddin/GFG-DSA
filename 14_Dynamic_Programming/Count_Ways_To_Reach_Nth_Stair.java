/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Input:
n = 4
Output: 5
Explanation:
You can reach 4th stair in 5 ways.
Way 1: Climb 2 stairs at a time.
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair
and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs
then 1 stair.
Way 5: Climb 1 stair, then 1 stair and
then 2 stairs.
*/

public class Count_Ways_To_Reach_Nth_Stair {
    public static void main(String[] args) {
        System.out.println(dpSolution(4));
    }

    static int recursiveSolution(int n, int currStair) {
        if(currStair==n) return 1;
        else if(currStair>n) return 0;
        return recursiveSolution(n, currStair+1)+recursiveSolution(n, currStair+2);
    }

    static int dpSolution(int n) {
        int[] dp=new int[n+1];
        dp[0]=1; dp[1]=1;

        for(int i=2; i<=n; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%(int)(Math.pow(10, 9)+7);
        }

        return dp[n];
    }

    static int iterativeSolution(int n) {
        int a=1, b=1, count=2, res=0;

        while(count<=n) {
            res=a+b;
            a=b;
            b=res;
            count++;
        }

        return res;
    }
}
