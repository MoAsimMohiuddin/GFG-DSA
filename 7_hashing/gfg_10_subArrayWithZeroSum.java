import java.util.HashSet;

public class gfg_10_subArrayWithZeroSum {
    public static void main(String[] args)
    {
        int[] arr={-3, 4, -3, -1, 1};
        System.out.println(efficientSolution(arr));
    }

    public static boolean efficientSolution(int[] arr)
    {
        HashSet<Integer> hSet=new HashSet<Integer>();
        int pSum=0;
        for(int i=0; i<arr.length; i++)
        {
            pSum+=arr[i];
            if(hSet.add(pSum)==false)
            {
                return true;
            }
            if(pSum==0)
            {
                return true;
            }
        }

        return false;
    }
}
