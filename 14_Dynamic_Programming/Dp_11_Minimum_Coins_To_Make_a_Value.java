/*
You are given an amount denoted by value. You are also given an array of coins. The array contains the denominations of the given coins. You need to find the minimum number of coins to make the change for value using the coins of given denominations. Also, keep in mind that you have infinite supply of the coins.

Input:
value = 5
numberOfCoins = 3
coins[] = {3,6,3}
Output: Not Possible
Explanation:We need to make the change for
value = 5 The denominations are {3,6,3}
It is certain that we cannot make 5 using
any of these coins.
*/

public class Dp_11_Minimum_Coins_To_Make_a_Value {
    public static void main(String[] args) {
        int[] coins={9, 6, 5, 1};
        // Use Memoization to optimize the result. Changing variables are the value and index. So, a 2D Memo Array is used.
        // System.out.println(recursiveMethod(coins, 11, 0, 0));
        System.out.println(myTabulationSolution(coins, 11));
    }

    static int recursiveMethod(int[] coins, int value, int count, int index) {
        if(value==0) return count;
        else if(value<0 || index>=coins.length) return Integer.MAX_VALUE;
        else{
            return Math.min(recursiveMethod(coins, value-coins[index], count+1, index), recursiveMethod(coins, value, count, index+1));
        }
    }

    static int myTabulationSolution(int[] coins, int value) {
        // O(value)(Coins) T.C
        int[] tab=new int[value+1];
        tab[0]=0;

        int n=coins.length;

        for(int i=1; i<=value; i++) {
            int res=Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if(i>=coins[j]) {
                    res=Math.min(res, tab[i-coins[j]]);
                }
            }

            if(res!=Integer.MAX_VALUE) {
                tab[i]=res+1;
            }else{
                tab[i]=res;
            }
        }

        printArray(tab);

        return tab[value];
    }

    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }

        System.out.println();
    }
}
