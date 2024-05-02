import java.util.HashMap;

public class gfg_12_longestSubArrayWithGivenSum {
    public static void main(String[] args)
    {
        int[] arr={8,3,1,6,-6,6,2,2};
        int result=hashMapSolution(arr, 4);
        System.out.println(result);
    }

    public static int hashMapSolution(int[] arr, int sum)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        int pSum=0, maxLength=0;
        for(int i=0; i<arr.length; i++)
        {
            pSum+=arr[i];
            if(pSum==sum)
            {
                int length=i+1;
                if(length>maxLength)
                {
                    maxLength=length;
                }
            }
            if(hMap.containsKey(pSum-sum))
            {
                int length=i-hMap.get(pSum-sum);
                if(length>maxLength)
                {
                    maxLength=length;
                }
            }
            if(!hMap.containsKey(pSum))
            {
                hMap.put(pSum, i);
            }
        }

        return maxLength;
    }

    public static int naiveSolution(int[] arr, int target)
    {
        int maxLength=0;

        for(int i=0; i<arr.length; i++)
        {
            int curSum=0;
            for(int j=i; j<arr.length; j++)
            {
                curSum+=arr[j];
                if(curSum==target)
                {
                    int length=j-i+1;
                    if(length>maxLength)
                    {
                        maxLength=length;
                    }
                }
            }
        }

        return maxLength;
    }
}
