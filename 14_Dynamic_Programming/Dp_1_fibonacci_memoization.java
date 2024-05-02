/*
If we write a normal recursive solution for finding the nth fibonacci number, The time complexity is O(2^n). But with memoization, We can optimize the time complexity to O(n).
*/

import java.util.Arrays;

public class Dp_1_fibonacci_memoization {
    public static void main(String[] args) {
        int n=10;
        int[] memoArray=new int[n+1];
        Arrays.fill(memoArray, -1);

        int fibNumber=fiboMemo(memoArray, n);
        System.out.println(fibNumber);
    }

    static int fiboMemo(int[] memo, int num)
    {
        if(memo[num]==-1)
        {
            int res;
            if(num==1 || num==0)
            {
                res=num;
            }
            else
            {
                res=fiboMemo(memo, num-1)+fiboMemo(memo, num-2);
            }

            memo[num]=res;
        }

        return memo[num];
    }

}
