// Given an unsorted array of integers and a sum. The task is to count the number of subarray which adds to the given sum.

// Example 1:

// Input:
// n = 5
// arr[] = {10,2,-2,-20,10}
// sum = -10
// Output: 3
// Explanation: Subarrays with sum -10 are: 
// [10, 2, -2, -20], [2, -2, -20, 10] and 
// [-20, 10].

import java.util.HashMap;

public class numberOfSubArraysWithGivenSum {
    public static void main(String[] args) {
        int[] arr={10,2,-2,-20,10};
        int sum=-10;
        System.out.println(efficientMethod(arr, sum));
    }

    static int efficientMethod(int[] arr, int sum) {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        
        int currSum=0, result=0, n=arr.length;
        
        for(int i=0; i<n; i++) {
            currSum+=arr[i];
            if(currSum==sum) {
                result++;
            }
            if(hMap.containsKey(currSum-sum)) {
                result+=hMap.get(currSum-sum);
            }

            if(hMap.containsKey(currSum)) {
                hMap.put(currSum, hMap.get(currSum)+1);
            }else{
                hMap.put(currSum, 1);
            }
        }
        
        return result;
    }
}
