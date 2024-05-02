import java.util.Arrays;
import java.util.HashSet;

public class gfg_15_longestConsecutiveSubSequence {
    public static void main(String[] args)
    {
        int[] arr={1,3,4,3,3,2,9,10};
        int result=hashSetSolution(arr);
        System.out.println(result);
    }

    public static int hashSetSolution(int[] arr)
    {
        HashSet<Integer> hSet=new HashSet<Integer>();
        for(int i=0; i<arr.length; i++)
        {
            hSet.add(arr[i]);
        }
        int result=0;
        for(int i=0; i<arr.length; i++)
        {
            // If there exists an element before the current element, Then it's not the starting of a subsequence and there is no point in looking through this subsequence.
            if(!hSet.contains(arr[i]-1))
            {
                int element=arr[i]+1, length=1;
                while(hSet.contains(element))
                {
                    length++;
                    element++;
                }
                if(length>result)
                {
                    result=length;
                }
            }

        }

        return result;
    }

    public static int sortingSolution(int[] arr)
    {
        Arrays.sort(arr);

        int length=0, result=0;

        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]==arr[i-1]+1)
            {
                length++;
                if(length>result)
                {
                    result=length;
                }
            }
            else if(arr[i]!=arr[i-1])
            {
                length=0;
            }
        }

        return result+1;
    }
}
