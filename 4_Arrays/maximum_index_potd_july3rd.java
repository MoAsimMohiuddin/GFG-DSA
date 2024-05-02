// Question: Given an array arr[] of n positive integers. The task is to find the maximum of j - i subjected to the constraint of arr[i] <= arr[j].

// Optimal Approach:

// Time Complexity - O(N)
// Auxillary Space - O(N)

// The Approach is to Maintain Two Auxillary Arrays of size n.
// One Array is to store Minimum element till ith index namely minArray.
// Another Array is to store Maximum element till ith index namely maxArray.

// After creating these two Arrays, We just need to compare the minimum element till ith index and maximum element till ith index and if they satisfy the constraint, Just update the result.

// Logic :

// If Minimum Element till ith index is lesser than or equal to Greater Element till ith index, There is a possibility that there might be a greater element at (i+1)th index and so on. So if minArray[i]<=maxArray[j], We increment j by keeping ith minimum element still in picture. We calculate the Difference and update the Result.

// If Minimum Element till ith index is greater than Maximum Element, Then there is no possibility that it might be greater than (i+1)th index. So, If minArray[i]>maxArray[j], We just increment i.

public class maximum_index_potd_july3rd {
    public static void main(String[] args) {
        int[] arr={34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(optimalApproach(arr, arr.length));
    }

    static int optimalApproach(int[] arr, int n)
    {
        int[] lMin=new int[n];
        int[] rMax=new int[n];
        
        lMin[0]=arr[0];
        rMax[n-1]=arr[n-1];
        
        int min=lMin[0];
        for(int i=1; i<n; i++)
        {
            if(arr[i]<min)
            {
                lMin[i]=arr[i];
                min=arr[i];
            }
            else
            {
                lMin[i]=min;
            }
        }
        
        int max=rMax[n-1];
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i]>max)
            {
                rMax[i]=arr[i];
                max=arr[i];
            }
            else
            {
                rMax[i]=max;
            }
        }
        
        int i=0, j=0, result=0;
        
        while(i<n && j<n)
        {
            if(lMin[i]<=rMax[j])
            {
                int diff=j-i;
                if(diff>result)
                {
                    result=diff;
                }
                j++;
            }
            else
            {
                i++;
            }
        }
        
        return result;
    }
}
