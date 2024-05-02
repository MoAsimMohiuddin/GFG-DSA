import java.util.HashSet;

public class gfg_9_pairSum {
    public static void main(String[] args)
    {

    }

    public static boolean pairSum(int[] arr, int sum)
    {
        HashSet<Integer> hset=new HashSet<Integer>();

        for(int i=0; i<arr.length; i++)
        {
            if(hset.contains(sum-arr[i]))
            {
                return true;
            }
            else
            {
                hset.add(arr[i]);
            }
        }

        return false;
    }
}
