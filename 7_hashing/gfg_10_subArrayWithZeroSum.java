import java.util.HashSet;

public class gfg_10_subArrayWithZeroSum {
    public static void main(String[] args)
    {
        int[] arr={-3, 4, -3, -1, 1};
        System.out.println(efficientSolution(arr));
    }

    static int equilibriumPoint(int[] arr, int size) {
        int lSum=0, rSum=0;

        for(int i=1; i<size-1; i++) rSum+=arr[i];

        for(int i=1; i<size; i++) {
            if(lSum==rSum) return i+1;
            else {
                lSum+=arr[i];
                rSum-=arr[i+1];
            }
        }

        if(lSum==rSum) return size;

        return -1;
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
