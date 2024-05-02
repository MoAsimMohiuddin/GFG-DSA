/*
Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Example 1:

Input: 
N = 6
arr = [5, 2, 3, 10, 6, 8]
sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
Example 2:
Input: 
N = 5
arr = [2, 5, 1, 4, 3]
sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
*/

import java.util.Arrays;

public class Perfect_Sum {
    public static void main(String[] args) {
        int[] arr={5, 2, 3, 10, 6, 8};
        System.out.println(recursiveSolution(arr, 10));
    }

    static int recursiveSolution(int[] arr, int sum) {
        // return helperFunction(arr, sum, 0, 0);
        int[][] memo=new int[arr.length+1][sum+1];
        for (int i = 0; i <= arr.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println("Memo");
        printArray(memo);
        return helperFunctionMemo(memo, arr, sum, 0, 0);
    }

    static int helperFunction(int[] arr, int sum, int index, int currSum) {
        if(currSum==sum) {
            return 1;
        }
        else if(currSum>sum || index>=arr.length) return 0;
        else{
            return helperFunction(arr, sum, index+1, currSum+arr[index])+helperFunction(arr, sum, index+1, currSum);
        }
    }

    static int helperFunctionMemo(int[][] memo, int[] arr, int sum, int index, int currSum) {
        if(currSum>sum || index>=arr.length) return 0;
        if(memo[index][currSum]==-1) {
            int res=0;
            if(currSum==sum) {
                res = 1;
            }
            else{
                res = helperFunctionMemo(memo, arr, sum, index+1, currSum+arr[index])+helperFunctionMemo(memo, arr, sum, index+1, currSum);
            }

            memo[index][currSum]=res;
        }

        System.out.println("New Call");
        printArray(memo);
        return memo[index][currSum];
    }

    static void printArray(int[][] arr) {
        for(int[] k: arr) {
            for(int i=0; i<k.length; i++) {
                System.out.print(k[i]+", ");
            }

            System.out.println();
        }
    }
}
