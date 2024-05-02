import java.util.Arrays;

public class gfg_15_chocolateDistribution {
    public static void main(String[] ASIM)
    {
        int[] arr={3,4,1,9,56,7,9,12};
        int result=chocoDist(arr, 5);
        System.out.println(result);
    }

    public static int chocoDist(int[] arr, int m)
    {
        if(m>arr.length)
        {
            return -1;
        }
        Arrays.sort(arr);

        int minDiff=Integer.MAX_VALUE, curDiff=0;
        for(int i=0; i<=arr.length-m; i++)
        {
            curDiff=arr[i+m-1]-arr[i];
            if(curDiff<minDiff)
            {
                minDiff=curDiff;
            }
        }

        return minDiff;
    }
}
