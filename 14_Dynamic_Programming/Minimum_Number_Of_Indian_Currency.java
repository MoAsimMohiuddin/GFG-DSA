import java.util.ArrayList;
import java.util.Collections;

public class Minimum_Number_Of_Indian_Currency {
    public static void main(String[] args) {
        System.out.println(minPartition(1000));
    }
    
    static ArrayList<Integer> minPartition(int N)
    {
        // code here
        int[] dp=new int[N+1];
        int[] coins= { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        
        dp[0]=0;
        
        for(int i=1; i<=N; i++) {
            dp[i]=Integer.MAX_VALUE;
            
            for(int k: coins) {
                if(i-k>=0) {
                    dp[i]=Math.min(dp[i], 1+dp[i-k]);
                }
            }
        }
        
        int currIndex=N;

        ArrayList<Integer> result=new ArrayList<>();

        while(currIndex>0) {
            int res=Integer.MAX_VALUE, index=currIndex, coin=0;

            for(int k: coins) {
                if(currIndex-k>=0 && dp[currIndex-k]<res) {
                    res=Math.min(res, dp[currIndex-k]);
                    coin=k;
                    index=currIndex-k;
                }
            }

            result.add(coin);
            currIndex=index;
        }

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(i+": "+arr[i]+", ");
        }
        System.out.println();
    }
}
