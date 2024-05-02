// Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not. Both the arrays can be sorted or unsorted. There can be duplicate elements.

// Example 1:

// Input:
// a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
// a2[] = {11, 3, 7, 1, 7}
// Output: Yes
// Explanation:
// a2[] is a subset of a1[]

import java.util.ArrayList;
import java.util.HashMap;

public class arraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] a1= {11, 7, 1, 4};
        int[] a2= {11};

        ArrayList<ArrayList<Integer>> result=printSubSets(a1, a2);
        System.out.println(result);
    }

    public static String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long, Long> hMap=new HashMap<Long, Long>();
        
        for(int i=0; i<n; i++) {
            if(!hMap.containsKey(a1[i])) {
                hMap.put(a1[i], 1L);
            }
            else{
                hMap.put(a1[i], hMap.get(a1[i])+1);
            }
        }
        
        for(int i=0; i<m; i++) {
            if(hMap.containsKey(a2[i])) {
                hMap.put(a2[i], hMap.get(a2[i])-1);
                if(hMap.get(a2[i])==0) {
                    hMap.remove(a2[i]);
                }
            }
            else{
                return "No";
            }
        }
        
        return "Yes";
    }

    static String effMethod(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();

        for(int k: arr1) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k)+1);
            }else{
                hMap.put(k, 1);
            }
        }

        for(int k: arr2) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k)-1);
                if(hMap.get(k)==0) {
                    hMap.remove(k);
                }
            }else{
                return "No";
            }
        }

        return "Yes";
    }

    static ArrayList<ArrayList<Integer>> printSubSets(int[] arr, int[] arr2) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> subsets=new ArrayList<>();
        
        calcSubsets(arr, res, subsets, 0, arr.length, arr2);

        return res;
    }

    static void calcSubsets(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subsets, int index, int size, int[] arr2) {
        res.add(new ArrayList<>(subsets));

        for(int i=index; i<size; i++) {
            subsets.add(arr[i]);
            checkIsSubset(subsets, arr2);

            calcSubsets(arr, res, subsets, i+1, size, arr2);
            
            subsets.remove(subsets.size()-1);
        }
    }

    static boolean checkIsSubset(ArrayList<Integer> subset, int[] arr2) {
        HashMap<Integer, Integer> hMap=new HashMap<>();
        int size=subset.size();

        for(int k: arr2) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k));
            }else{
                hMap.put(k, 1);
            }
        }

        for(int i=0; i<size; i++) {
            if(hMap.containsKey(subset.get(i))) {
                hMap.put(subset.get(i), hMap.get(subset.get(i))-1);
                if(hMap.get(subset.get(i))==0) {
                    hMap.remove(subset.get(i));
                }
            }else{
                return false;
            }
        }

        if(hMap.size()==0) {
            System.out.println("FOUND IT");
            System.out.println(subset);
            return true;
        }else{
            return false;
        }
    }
}
