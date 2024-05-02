public class Dp_13_Optimal_Game_Strategy {
    public static void main(String[] args) {
        int[] arr={2, 3, 15, 7};
        System.out.println(tabulationSolution(arr, arr.length));
    }

    static int optimalStrategyForAGame(int[] arr, int n) {
        int sum=0;
        for(int k: arr) sum+=k;

        return helperFunction(arr, 0, n-1, sum);
    }

    static int helperFunction(int[] arr, int low, int high, int sum) {
        /*
        Imagine that you have an option of chosing an element starting from index i and ending at index j.
        Let the function be f(i, j).
        If you chose the element at left most index, The opponent has the function f(i+1, j) to chose from.
        If you chose the element at right most index, The opponent has the function f(i, j+1) to chose from.

        Since the opponent is playing optimally too, We get the Min( f(i+1, j), f(i, j+1) ).

        And we need the maximum of these two to get the best answer.
        So, the recursive function is.

        f(i, j)=Max
        (
            arr[i] + Min( f(i+2, j), f(i+1)(j-1)),
            arr[j] + Min( f(i+1, j-1), f(i)(j-2))
        )

        */
        if(low+1==high) return Math.max(arr[low], arr[high]);
        return Math.max(sum-helperFunction(arr, low+1, high, sum-arr[low]), sum-helperFunction(arr, low, high-1, sum-arr[high]));
    }

    static int method(int[] arr, int low, int high) {
        if(low+1==high) return Math.max(arr[low], arr[high]);
        return Math.max(arr[low]+Math.min(method(arr, low+1, high-1), method(arr, low+2, high)), arr[high]+Math.min(method(arr, low, high-2), method(arr, low+1, high-1)));
    }

    // Optimized Solution using Dynamic Programming. Tabulation.
    static int tabulationSolution(int[] arr, int n) {
        int[][] dp=new int[n][n];

        for(int g=0; g<n; g++) {
            for(int i=0, j=g; j<n; i++, j++) {
                if(g==0) dp[i][j]=arr[i];
                else if(g==1) dp[i][j]=Math.max(arr[i], arr[j]);
                else{
                    dp[i][j]=Math.max(
                        arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]),
                        arr[j]+Math.min(dp[i+1][j-1], dp[i][j-2])
                    );
                }
            }
        }

        return dp[0][n-1];
    }
}
