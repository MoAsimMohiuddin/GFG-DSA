public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(method("aacabdkacaa", 11));
    }

    static int method(String str, int len) {
        String rev="";
        for(char ch: str.toCharArray()) {
            rev=ch+rev;
        }

        if(str.equals(rev)) return len;
        return lcs(str, rev, len);
    }

    static int lcs(String str, String rev, int len) {
        int[][] dp=new int[len+1][len+1];

        int endIndex = 0;
        int maxLen = 0;

        for(int i=1; i<=len; i++) {
            for(int j=1; j<=len; j++) {
                if(str.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i-1;
                    }
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        
        int startIndex = endIndex - maxLen + 1;
        System.out.println("The Longest Palindromic Substring is "+str.substring(startIndex, endIndex + 1));

        printArray(dp);
        return dp[len][len];
    }
    
    static void printArray(int[][] arr) {
        for(int[] a: arr) {
            for(int k: a) {
                System.out.print(k+", ");
            }
            System.out.println();
        }
    }
}
