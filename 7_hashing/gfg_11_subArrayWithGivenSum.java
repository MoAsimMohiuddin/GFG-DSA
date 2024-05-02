import java.util.HashSet;

public class gfg_11_subArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr={5,9,1,2,13,3};
        int sum=25;

        int[] res=twoPointerApproach(arr, sum);
        printArray(res);
    }

    public static boolean efficientSolution(int[] arr, int target)
    {
        HashSet<Integer> hSet=new HashSet<Integer>();
        int pSum=0;
        for(int i:arr)
        {
            pSum+=i;
            if(pSum==target)
            {
                return true;
            }

            if(hSet.contains(pSum-target))
            {
                return true;
            }
            hSet.add(pSum);
        }

        return false;
    }

    public static int[] twoPointerApproach(int[] arr, int target) {
        int sum=arr[0], start=0, end=0, len=arr.length;

        while(end<len) {
            if(sum==target) {
                return new int[]{start, end};
            }
            else if(sum<target) {
                end++;
                if(end<len) {
                    sum+=arr[end];
                }
            }
            else {
                sum-=arr[start++];
            }
        }

        return new int[]{-1, -1};
    }

    static void printArray(int[] arr) {
        for(int k:arr){
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
