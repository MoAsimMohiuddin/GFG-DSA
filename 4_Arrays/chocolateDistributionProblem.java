// Given an array A[] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
// 1. Each student gets exactly one packet.
// 2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

// Input:
// N = 8, M = 5
// A = {3, 4, 1, 9, 56, 7, 9, 12}
// Output: 6
// Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.

import java.util.Arrays;

public class chocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr={3, 4, 1, 9, 56, 7, 9, 12};
        int students=5;

        System.out.println(efficientSolution(arr, students));
    }

    static int efficientSolution(int[] arr, int students) {
        Arrays.sort(arr);

        int low=0, high=students-1, size=arr.length, result=Integer.MAX_VALUE;

        while(high<size) {
            System.out.println("arr[low]="+arr[low]+", arr[high]="+arr[high]);
            int diff=arr[high]-arr[low];
            if(diff<result) {
                result=diff;
            }
            low++;high++;
        }

        return result;
    }
}
