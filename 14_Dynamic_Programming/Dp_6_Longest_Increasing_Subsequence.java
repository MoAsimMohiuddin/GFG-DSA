// Given an Array of Integers, Find the longest increasing subsequence of the elements.
// Naive Solution is to find all the increasing subsequences of the Array using Superset, and then finding the longest amongst those. But it requires 2^n T.C.

import java.util.ArrayList;

public class Dp_6_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr={8, 13, 15, 2, 9, 100, 150, 1};
        System.out.println(LIS_Binary_Search(arr, arr.length));
    }

    public static int LIS(int[] arr, int n) {
        int[] lis=new int[n];
        lis[0]=1;

        for(int i=1; i<n; i++) {
            int max=0;

            for(int j=i-1; j>=0; j--) {
                if(arr[i]>arr[j]) {
                    max=Math.max(lis[j], max);
                }
            }

            lis[i]=max+1;
        }

        int max=lis[0];

        for(int i=1; i<n; i++) {
            if(lis[i]>max) max=lis[i];
        }

        return max;
    }

    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static int LIS_Binary_Search(int[] arr, int n) {
        ArrayList<Integer> tailList=new ArrayList<>();

        tailList.add(arr[0]);

        for(int i=1; i<n; i++) {
            int tSize=tailList.size();

            if(tailList.get(tSize-1)<arr[i]) {
                tailList.add(arr[i]);
            }else{
                int low=0, high=tSize-1;

                while(low<high) {
                    int mid=low+(high-low)/2;

                    if(tailList.get(mid)>=arr[i]) {
                        high=mid;
                    }else{
                        low=mid+1;
                    }
                }

                tailList.set(high, arr[i]);
            }
        }

        return tailList.size();
    }
}
