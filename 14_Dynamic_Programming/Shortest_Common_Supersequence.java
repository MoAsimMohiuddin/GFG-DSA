/* Given two strings s1 and s2, Find the shortest string which has both s1 and s2 as a subsequence in it.
Ex: s1=AGGTAB, s2=GXTXAYB, shortest_common_supersequence=AGXGTXAYB. We need to return the length which is 9.
*/

import java.util.Arrays;

public class Shortest_Common_Supersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abcd", "xycd", 4, 4));
    }
    
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] memo=new int[m+1][n+1];
        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        
        int l=lcs(memo, X, Y, m, n);
        System.out.println("LCS="+l);
        return (m-l+n-l+l+1);
    }
    
    static int lcs(int[][] memo, String s1, String s2, int m, int n) {
        if(memo[m][n]==-1) {
            int res;
            if(m<=0 || n<=0) {
                res=0;
            }else if(s1.charAt(m-1)==s2.charAt(n-1)) {
                res=1+lcs(memo, s1, s2, m-1, n-1);
            }else{
                res=Math.max(lcs(memo, s1, s2, m-1, n), lcs(memo, s1, s2, m, n-1));
            }
            
            memo[m][n]=res;
        }
        
        return memo[m][n];
    }
}
