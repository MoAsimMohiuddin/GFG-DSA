public class Word_Break {
    public static void main(String[] args) {
        String str="leetcode";
        String[] words={"leet", "code"};

        System.out.println(wordBreak(str, words, str.length(), words.length));
    }

    static boolean wordBreak(String str, String[] words, int strLen, int arrLen) {
        boolean[] dp=new boolean[strLen+1];

        dp[strLen]=true;
        
        for(int i=strLen-1; i>=0; i--) {
            for(String subStr: words) {
                if(i+subStr.length()<=strLen && str.substring(i, i+subStr.length()).equals(subStr)) {
                    dp[i]=dp[i+subStr.length()];
                }

                if(dp[i]) break;
            }
        }

        printArray(dp);
        return dp[0];
    }

    static void printArray(boolean[] arr) {
        for(boolean bool: arr) {
            System.out.print(bool+", ");
        }
        System.out.println();
    }
}
