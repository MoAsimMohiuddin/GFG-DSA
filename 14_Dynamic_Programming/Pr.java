import java.util.Arrays;

public class Pr {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("hello");
        System.out.println(coinChange(coins, 11, coins.length));
    }

    static void fiboUsingLoop(int n) {
        int a=0, b=1, sum=0, count=0;

        System.out.print(a+", "+b+", ");
        
        while(count<n) {
            sum=a+b;
            System.out.print(sum+", ");
            a=b;
            b=sum;
            count++;
        }
    }

    static void fibonacciUsingRecursion(int n) {
        System.out.print("0, 1, ");
        helperFunctionFibo(0, 1, n, 0);
    }
    static void helperFunctionFibo(int a, int b, int n, int count) {
        if(count>=n) {return;}
        System.out.print(a+b+", ");
        helperFunctionFibo(b, a+b, n, count+1);
    }

    static int nthFiboUsingLoop(int n) {
        int a=0, b=1, res=0, count=2;

        while(count++<n) {
            res=a+b;
            a=b;
            b=res;
        }
        return res;
    }

    static int nthFiboUsingRecursion(int n) {
        if(n==0||n==1) {return n;}
        return nthFiboUsingRecursion(n-1)+nthFiboUsingRecursion(n-2);
    }

    static int[] memo=new int[100];
    
    static int fiboOptimizedUsingDP(int n) {
        Arrays.fill(memo, -1);
        return dpHelper(n);
    }
    static int dpHelper(int n) {
        if(memo[n]==-1) {
            int res;
            if(n==0 || n==1) {
                res=n;
            }else{
                res=dpHelper(n-1)+dpHelper(n-2);
            }

            memo[n]=res;
        }

        printArray(memo);
        return memo[n];
    }

    
    static void printArray(int[] arr) {
        System.out.println("***");
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
        System.out.println("***");
    }

    static int lcs(String str1, String str2, int m, int n) {
        if(m<=0 || n<=0) {
            return 0;
        }else{
            int res;
            if(str1.charAt(m-1)==str2.charAt(n-1)) {
                res = 1+lcs(str1, str2, m-1, n-1);
            }else{
                res=Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
            }

            return res;
        }
    }

    static int coinChange(int[] coins, int amount, int size) {
        return helperFunctionCoinChange(coins, 0, amount, 0);
    }

    static int helperFunctionCoinChange(int[] coins, int startIndex, int amount, int count) {
        if(startIndex>=coins.length || amount<0) return Integer.MAX_VALUE;
        if(amount == 0) {
            return count;
        }
        else {
            return Math.min(helperFunctionCoinChange(coins, startIndex, amount-coins[startIndex], count+1), helperFunctionCoinChange(coins, startIndex+1, amount, count));
        }
    }
}
