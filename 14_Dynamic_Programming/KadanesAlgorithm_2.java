// Given an array of integers, Return the maximum sum of elements such that if you pick an element, You're not allowed to pick the adjacent element to it.

import java.util.Arrays;

public class KadanesAlgorithm_2 {
    public static void main(String[] args) {
    int[] arr={-59 -91 -230 -114 -492};
    System.out.println(maximumSum(arr, arr.length));
    }

    public static long maximumSum(int arr[], int sizeOfArray)
    {
      //Your code here
      long[] memo=new long[sizeOfArray];

      Arrays.fill(memo, -1);


      return helperFunction(memo, arr, sizeOfArray, 0);
    }

    static long helperFunction(long[] memo, int[] arr, int n, int index) {
        if(index<0 || index>=n) return 0;
        if(memo[index]==-1) {
            long res=arr[index];

            res= Math.max(arr[index]+helperFunction(memo, arr, n, index+2), helperFunction(memo, arr, n, index+1));

            memo[index]=res;
            System.out.println("res="+res);
        }

        printArray(memo);
        return memo[index];
    }

    static void printArray(long[] arr) {
        for(long k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
