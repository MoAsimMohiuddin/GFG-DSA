import java.util.Arrays;

public class JumpGame{
    public static void main(String[] args) {
        int[] arr={3,2,1,0,4};
        boolean[] dp=new boolean[arr.length];
        Arrays.fill(dp, true);

        System.out.println(greedyMethod(arr));
    }

    static boolean naiveMethod(int[] arr, int index, boolean[] dp) {
        if(index==arr.length-1){
            return true;
        }
        else if(index<arr.length){
            for(int i=index+1; i<=index+arr[index]; i++) {
                if(dp[index]) {
                    if(naiveMethod(arr, i, dp)) {
                        return true;
                    }
                }else{
                    return false;
                }
            }
        }

        dp[index]=false;
        return false;
    }

    static boolean greedyMethod(int[] arr) {
        int size=arr.length, goal=size-1;

        for(int i=size-2; i>=0; i--) {
            if(i+arr[i]>=goal) {
                if(i==0) {
                    return true;
                }
                goal=i;
            }
        }

        return false;
    }
}