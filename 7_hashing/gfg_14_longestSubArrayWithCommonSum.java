import java.util.HashMap;

public class gfg_14_longestSubArrayWithCommonSum {
    public static void main(String[] args)
    {
        int[] arr1={0,1,0,1,1,1,1};
        int[] arr2={1,1,1,1,1,0,1};
        int result=hashMapSolution(arr1, arr2);
        System.out.println(result);
    }

    public static int hashMapSolution(int[] arr1, int[] arr2)
    {
        int[] arr=new int[arr1.length];

        for(int i=0; i<arr.length; i++)
        {
            arr[i]=arr1[i]-arr2[i];
        }

        int pSum=0, length=0, maxLength=0;
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++)
        {
            pSum+=arr[i];
            if(pSum==0)
            {
                length=i+1;
                if(length>maxLength)
                {
                    maxLength=length;
                }
            }
            if(hMap.containsKey(pSum))
            {
                length=i-hMap.get(pSum);
                if(length>maxLength)
                {
                    maxLength=length;
                }
            }
            else
            {
                hMap.put(pSum, i);
            }
        }

        return maxLength;
    }
}
