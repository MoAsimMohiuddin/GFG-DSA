// Question: Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.

// Optimal Approach:
// Let the Array be {1, 9, 2, 8, 6, 4, 3}, k=100. Let's say that we calculated the number of subarrays having product<k till ith index. Let the Sub Array now be {1,9}. Now, If we add a new element to the existing Sub Array which is 2, And if it still satisfies the constraint p<k, The the Number of New Sub Arrays after adding 2 are {2}, {9, 2}, {1, 9, 2}. That is basically the length of the New Sub Array. Or new Window. So, As long as adding new Element satisfies the constraint p<k, We add the length of our new window to the result.
// If Adding new element doesn't satisfy the constraint p<k, We can just remove an element from the starting of the Sub Array until the constraint true. And since the Sub Array is changed now, We Again add the length of the new window to our result since sub array was changed.


public class Count_subArrays_less_than_k_POTDjuly4th {
    public static int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int count=0, st=0, en=0;
        long p=1;
        
        while(st<=en && en<n)
        {
            p*=a[en];
            while(st<=en && p>=k)
            {
                p/=a[st++];
            }
            
            if(st<=en)
            {
                count+=en-st+1;
            }
            en++;
        }
        
        return count;
    }
}
