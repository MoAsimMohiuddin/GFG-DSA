// If we find the longest palindromic subsequence from a string s1, and find the longest palindromic subsequence from rev(s1), both the palindromic subsequences are basically the reverse of each other. So, it's equivalent to finding the LCS between s1 and rev(s1). Because finding LCS maintains the order of characters. So, If we find the LCS between s1, rev(s1), we find the longest palindromic subsequence.

import java.util.Arrays;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("CHARACTER", "CHARACTER".length()));
    }

    static int longestPalindromicSubsequence(String s1, int len) {
        String s2="";
        for(int i=len-1; i>=0; i--) {
            s2+=s1.charAt(i);
        }

        int[][] memo=new int[len+1][len+1];
        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        return LCS(memo, s1, s2, len, len);
    }
    static int LCS(int[][] memo, String s1, String s2, int m, int n) {
        if(memo[m][n]==-1) {
            int res;
            if(m<=0 || n<=0) res=-1;
            else if(s1.charAt(m-1)==s2.charAt(n-1)) res=1+LCS(memo, s1, s2, m-1, n-1);
            else res=Math.max(LCS(memo, s1, s2, m-1, n), LCS(memo, s1, s2, m, n-1));

            memo[m][n]=res;
        }

        return memo[m][n];
    }
}

// Basically we need to find the longest subsequence in s1 which reads the same from starting to end, and ending to start. So, if we have to do this, we can basically find the LCS between s1 and rev(s1) which will essentially give us the desired result.