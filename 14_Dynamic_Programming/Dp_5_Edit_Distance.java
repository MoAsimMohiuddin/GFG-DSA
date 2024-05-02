// Return the minimum number of operations required to convert str1 to str2 by using below operations: i) Insert a character, ii) Delete a character, iii) Replace a character.
// Real World application for this problem is the spelling error feature in search engines. We can find the edit distance value between the word typed by user and the remaining words in the dictionary, and suggest the word with the least edit distance value. "Did You Mean?" feature.

import java.util.Arrays;

public class Dp_5_Edit_Distance {
    public static void main(String[] args) {
        String str1="SATURDAY", str2="SUNDAY";
        int[][] memo=new int[9][7];

        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        // System.out.println(memoization(memo, str1, str2, 8, 6));
        System.out.println(tablulation(str1, str2, 8, 6));
    }

    static int recursiveSolution(String str1, String str2, int n, int m) {
        if(n==0) return m;
        if(m==0) return n;
        if(str1.charAt(n-1)==str2.charAt(m-1)) return recursiveSolution(str1, str2, n-1, m-1);
        else{
            return 1+Math.min(recursiveSolution(str1, str2, n, m-1), Math.min(recursiveSolution(str1, str2, n-1, m), recursiveSolution(str1, str2, n-1, m-1)));
        }
    }

    static int mySolution(String str1, String str2, int n, int m) {
        if(n==0) return m;
        if(m==0) return n;
        if(str1.charAt(n-1)==str2.charAt(m-1)) return recursiveSolution(str1, str2, n-1, m-1);
        else{
            String addedString=str1+str2.charAt(m-1);
            String replString=str1.substring(0, n-1)+str2.charAt(m-1);
            return 1+Math.min(mySolution(addedString, str2, n+1, m), Math.min(mySolution(str1, str2, n-1, m), mySolution(replString, str2, n, m)));
        }
    }

    static int memoization(int[][] memo, String str1, String str2, int n, int m) {
        if(memo[n][m]!=-1) {
            return memo[n][m];
        }else{
            int res;

            if(n==0) {
                memo[n][m]=m;
                return memo[n][m];
            }
            if(m==0){
                memo[n][m]=n;
                return memo[n][m];
            }

            if(str1.charAt(n-1)==str2.charAt(m-1)) res=memoization(memo, str1, str2, n-1, m-1);
            else{
                res=1+Math.min(memoization(memo, str1, str2, n, m-1), Math.min(memoization(memo, str1, str2, n-1, m), memoization(memo, str1, str2, n-1, m-1)));
            }

            memo[n][m]=res;
        }

        return memo[n][m];
    }

    static int tablulation(String str1, String str2, int n, int m) {
        int[][] tab=new int[n+1][m+1];

        for(int i=0; i<=m; i++) {
            tab[0][i]=i;
        }

        for(int i=0; i<=n; i++) {
            tab[i][0]=i;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) tab[i][j]=tab[i-1][j-1];
                else{
                    tab[i][j]=1+Math.min(tab[i][j-1], Math.min(tab[i-1][j], tab[i-1][j-1]));
                }
            }
        }

        return tab[n][m];
    }
}
