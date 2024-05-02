import java.util.Arrays;

public class gfg_14_minimumDifferenceInArray {
    public static void main(String[] args) {
        int[] arr={23,16,90,45,2,10};
        int result=minDiff(arr);
        System.out.println(result);
    }

    public static int minDiff(int[] arr)
    {
        Arrays.sort(arr);

        int minDiff=Integer.MAX_VALUE, curDiff=0;

        for(int i=1; i<arr.length; i++)
        {
            curDiff=arr[i]-arr[i-1];
            if(curDiff<minDiff)
            {
                minDiff=curDiff;
            }
        }

        return minDiff;
    }
}
