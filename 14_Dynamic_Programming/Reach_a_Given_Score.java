// Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.

// Example 1:

// Input:
// n = 8
// Output: 1
// Explanation:when n = 8,{3,5} and {5,3}
// are the two possible permutations but
// these represent the same combination.
// Hence output is 1.
// Example 2:

// Input:
// n = 20
// Output: 4
// Explanation:When n = 20, {10,10},
// {5,5,5,5},{10,5,5} and {3,3,3,3,3,5}
// are different possible permutations.
// Hence output will be 4.


public class Reach_a_Given_Score {
    public static void main(String[] args) {
        System.out.println(method(64));
    }

    static int method(int n) {
        int[] dp=new int[n+1];
        int[] arr={3, 5, 10};

        dp[0]=1;

        for(int k: arr) {
            for(int i=k; i<=n; i++) {
                if(i-k>=0) {
                    dp[i]+=dp[i-k];
                }
            }
        }

        return dp[n];
    }
}
