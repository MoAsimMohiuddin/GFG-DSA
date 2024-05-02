// Question: Given an Integer Sorted Arry, Find a sub array whose sum equals to 's' given in the question.
// Example: {1,2,3,4,5,6,7,8,9,10}, s=18. Ans={6,5,4,3}

import java.util.ArrayList;

public class subArrayWithGivenSumInLinearTimeConstantSpace {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int sum=15;
        ArrayList<Integer> result=efficientSolution(arr, sum);
        for(int i=0; i<result.size(); i++)
        {
            System.out.print(result.get(i)+", ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> efficientSolution(int[] arr, int sum)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        if(sum==0)
        {
            result.add(-1);
            return result;
        }

        int size=arr.length, pSum=0, i=0, low=0;
        while(i<size)
        {
            pSum+=arr[i];
            while(pSum>sum)
            {
                pSum-=arr[low++];
            }

            if(pSum==sum)
            {
                result.add(low+1);
                result.add(i+1);
                return result;
            }
            i++;
        }

        result.add(-1);
        result.add(-1);
        return result;
    }
}
