// Given an array of positive integers. Find the length of the longest subsequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

// Example 1:
// Input:
// N = 7
// a[] = {2,6,1,9,4,5,3}
// Output:
// 6
// Explanation:
// The consecutive numbers here
// are 1, 2, 3, 4, 5, 6. These 6 
// numbers form the longest consecutive
// subsquence.

import java.util.HashSet;

public class longestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr={2,6,1,9,4,5,3};

        System.out.println(efficientMethod(arr));
    }

    static int efficientMethod(int[] arr) {
	   HashSet<Integer> hSet=new HashSet<Integer>();
	   int result=0;
	   
	   for(int k: arr) {
	       hSet.add(k);
	   }
	   
	   for(int k: arr) {
	       int count=0, temp=k;
	       
	       if(!hSet.contains(temp-1)) {
	           while(hSet.contains(temp++)) {
	               count++;
	           }
	       }
	       
	       result=Math.max(count, result);
	   }
	   
	   return result;
    }
}
