// Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.

// Example 1:

// Input:
// n = 7
// A[] = {1,0,0,1,0,1,1}
// Output: 8
// Explanation: The index range for the 8 
// sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
// (4, 5) ,(2, 5), (0, 5), (1, 6)

// We can solve this problem by replacing all zeros with -1. After doing that, We create a hashmap and store the sum of elements until index i and their count, And if sum is zero, We increment result by 1. Also if the sum occured again, We increment the result by the number of times it previously occured. This is because if at an index i, The sum is same as indexes before, That means we have multiple subarrays having zero sum in between the current subarray and previously occured subarrays.

import java.util.HashMap;

public class numberOfSubArraysWithEqualOnesAndZeros{
    public static void main(String[] args) {
        int[] arr={1,0,0,1,0,1,1};
        System.out.println(efficientMethod(arr));
    }

    static int efficientMethod(int[] arr) {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        
        int result=0, sum=0, n=arr.length;
        
        for(int i=0; i<n; i++) {
            if(arr[i]==0) {
                arr[i]=-1;
            }
            
            sum+=arr[i];
            
            if(sum==0) {
                result++;
            }
            
            if(hMap.containsKey(sum)) {
                result+=hMap.get(sum);
                hMap.put(sum, hMap.get(sum)+1);
            }else{
                hMap.put(sum, 1);
            }
        }
        
        return result;
    }
}