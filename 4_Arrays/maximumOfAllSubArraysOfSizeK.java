// Question: Maximum of all subarrays of size k;
// Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.


import java.util.ArrayList;
import java.util.HashSet;

public class maximumOfAllSubArraysOfSizeK {
    public static void main(String[] args) {
        int[] arr={1,2,3,1,4,5,2,3,6};

        ArrayList<Integer> result=max_of_subarrays(arr, arr.length, 3);
        System.out.println(result);
    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        HashSet<Integer> hSet=new HashSet<Integer>();
        
        int max=arr[0];
        
        for(int i=0; i<k; i++) {
            hSet.add(arr[i]);
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        result.add(max);
        
        for(int i=1; i<n-k+1; i++) {
            if(arr[i+k-1]>max) {
                max=arr[i+k-1];
            }else if(max==arr[i-1]) {
                max=findMax(arr, i, i+k-1);
            }
            result.add(max);
            
            hSet.remove(arr[i-1]);
            hSet.add(arr[i+k-1]);

            System.out.println("Hashset at i="+i+" is "+hSet+", max="+max);
        }
        
        return result;
    }
    
    static int findMax(int[] arr, int start, int end) {
        int result=arr[start];
        for(int i=start; i<=end; i++) {
            if(arr[i]>result){
                result=arr[i];
            }
        }
        
        return result;
    }
}
