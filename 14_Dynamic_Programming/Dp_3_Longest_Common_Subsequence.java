// Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.

// Example 1:

// Input:
// A = 6, B = 6
// str1 = ABCDGH
// str2 = AEDFHR
// Output: 3
// Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
// Example 2:

// Input:
// A = 3, B = 2
// str1 = ABC
// str2 = AC
// Output: 2
// Explanation: LCS of "ABC" and "AC" is "AC" of length 2.

import java.util.Arrays;

public class Dp_3_Longest_Common_Subsequence {
    public static void main(String[] args) {
        System.out.println(mySol("ACABBBBDBAAB", "BBCCBEECDCDE"));
    }

    static int mySol(String st1, String st2) {
        int p1=0, p2=0, len1=st1.length(), len2=st2.length(), res=-1, count=0;

        for(int k=0; k<len1; k++) {
            System.out.println("k="+k);
            count=0;
            for(int i=k; i<len1; i++) {
                p1=i;
                for(int j=p2; j<len2; j++) {
                    System.out.println("i="+i+", j="+j);
                    if(st1.charAt(p1)==st2.charAt(j)) {
                        count++;
                        p2=j+1;
                        break;
                    }
                }

                if(count>res) res=count;
                p1++;
            }
            p2=0;
        }

        return res;
    }

    // Memoization Solution.
    static int longestCommongSubsequence(int[][] memo, String str1, String str2, int m, int n) {
        if (memo[m][n] == -1) {
            int res;
            if (m <= 0 || n <= 0) {
                res = 0;
            } else {
                if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                    res = 1 + longestCommongSubsequence(memo, str1, str2, m - 1, n - 1);
                } else {
                    res = Math.max(longestCommongSubsequence(memo, str1, str2, m - 1, n),
                            longestCommongSubsequence(memo, str1, str2, m, n - 1));
                }
            }

            memo[m][n] = res;
        }

        return memo[m][n];
    }

    // Tabulation Method
    static int lcsTabulation(String s1, String s2, int m, int n) {
        int[][] tab=new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    tab[i][j]=1+tab[i-1][j-1];
                }else{
                    tab[i][j]=Math.max(tab[i-1][j], tab[i][j-1]);
                }
            }
        }

        return tab[m][n];
    }
}

/*
Variation of LCS:
i) Diff utility - Using LCS, we can find the difference between current changes and the last commit in version control systems like Git, Mercurial, etc.
ii) Minimum Insertion and Deletions to transform string1 to string2. For this we can just find the LCS of two Strings and then number of insertions are m-l and number of deletions are n-l.
iii) Shortest Common Supersequence,
iv) Longest Palindromic Subsequence,
v) Longest Repeating Subsequence,
vi) Space Optimization in LCS Tabulation Method. In Tabulation method, For knowing the current length of common subsequence, We just need the previous one answer. So, we don't need an DP Array with size m*n. We can just maintain one row and one column to optimize the space. And make the auxillary space constant(O(1)),
vii) Printing LCS. We can print the LCS String using Tabulation method by traversing the array backwards and shifting diagonally.
*/
