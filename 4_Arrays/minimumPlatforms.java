// Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
// Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
// Example 1:

// Input: n = 6 
// arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
// dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
// Output: 3
// Explanation: 
// Minimum 3 platforms are required to 
// safely arrive and depart all trains.

import java.util.Arrays;

public class minimumPlatforms {
    public static void main(String[] args) {
        int[] arr={900, 940, 950, 1100, 1500, 1800};
        int[] dep={910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arr, dep, arr.length));
    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        // We can sort the arrivals and departures. That way we can see how many trains arrived before the old train left the platform. And accordingly update the maximum amount of platforms.
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int max=1, platforms=1, i=1, j=0;
        
        while(i<n) {
            if(arr[i]>dep[j]) {
                platforms--;
                j++;
            }
            else{
                platforms++;
                i++;
            }
            
            if(platforms>max) {
                max=platforms;
            }
        }
        
        return max;
    }
}
