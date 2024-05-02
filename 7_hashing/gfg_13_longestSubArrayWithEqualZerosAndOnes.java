// Important Problem

import java.util.HashMap;

public class gfg_13_longestSubArrayWithEqualZerosAndOnes {
    public static void main(String[] args)
    {
        int[] arr={1,0,1,1,1,0,0};
        int result=gfgSolution(arr);
        System.out.println(result);
    }
    
    public static int hashSetSolution(int[] arr)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();

        int zeros=0, ones=0, length=0, maxLength=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==0){zeros++;}
            else if(arr[i]==1){ones++;}
            if(ones-zeros==0)
            {
                length=i+1;
                System.out.println("length at i="+i+" is "+length);
                if(length>maxLength)
                {
                    maxLength=length;
                }
            }
            else if(hMap.containsKey(ones-zeros))
            {
                length=i-hMap.get(ones-zeros);
                System.out.println("length at i="+i+" is "+length);
                if(length>maxLength)
                {
                    maxLength=length;
                }
                // hMap.put(null, i);
                continue;
            }

            hMap.put(ones-zeros, i);
        }

        System.out.println(hMap);
        return maxLength;
    }

    public static int gfgSolution(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==0)
            {
                arr[i]=-1;
            }
        }

        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        int pSum=0, length=0, maxLength=0;
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
            if(!hMap.containsKey(pSum))
            {
                hMap.put(pSum, i);
            }
        }

        return maxLength;
    }

    public static int naiveSolution(int[] arr)
    {
        int ones=0, zeros=0, length=0, maxLength=0;

        for(int i=0; i<arr.length; i++)
        {
            ones=0;zeros=0;
            for(int j=i; j<arr.length; j++)
            {
                if(arr[j]==0)
                {
                    zeros++;
                }
                else if(arr[j]==1)
                {
                    ones++;
                }
                if(ones==zeros)
                {
                    length=j-i+1;
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
