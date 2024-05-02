public class Ways_To_Write_N_As_Sum {
    public static void main(String[] args) {
        System.out.println(tabulationSolution(8));
    }

    static int recursiveSolution(int n) {
        return helperFunction(n, 1, 0);
    }

    static int helperFunction(int n, int currNum, int sum) {
        if(sum==n) return 1;
        else if(sum>n || currNum>n) return 0;
        else return helperFunction(n, currNum, sum+currNum)+helperFunction(n, currNum+1, sum);
    }

    static int tabulationSolution(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;

        for(int i=1; i<n; i++) {
            for(int j=i; j<n+1; j++) {
                dp[j]+=dp[j-i];
            }
        }

        printArray(dp);
        return dp[n];
    }

    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
