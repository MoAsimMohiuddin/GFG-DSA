import java.util.Arrays;

public class Dp_12_Minimum_Jumps_To_Reach_The_End {
    public static void main(String[] args) {
        int[] arr={4,1,5,3,1,3,2,1,8};
        // System.out.println(recursiveSolution(arr, arr.length-1));
        // int[] memo=new int[arr.length];

        // Arrays.fill(memo, -1);

        // System.out.println(memoization(arr, memo, arr.length-1));

        // System.out.println(myTabulationSolution(arr, arr.length));
        System.out.println(greedySolution(arr, arr.length));
    }

    static int myMethod(int[] arr, int n) {
        int count=0;

        for(int i=n-1; i>=0; i--) {
            System.out.println("i="+i);
            int res=-1;
            for(int j=i-1; j>=0; j--) {
                for(int k=1; k<=arr[j]; k++) {
                    if(j+k==i) {
                        res=j;
                        break;
                    }
                }
            }

            if(res!=-1) {
                count++;
                i=res+1;
            }
        }

        return count;
    }

    static int recursiveSolution(int[] arr, int n) {
        if(n==0) return 0;

        int res=Integer.MAX_VALUE;

        for(int i=0; i<=n-1; i++) {
            if(i+arr[i]>=n) {
                int sub_res=recursiveSolution(arr, i);
                if(sub_res!=Integer.MAX_VALUE) {
                    res=Math.min(res, sub_res+1);
                }
            }
        }

        return res;
    }

    static int memoization(int[] arr, int[] memo, int n) {
        if(memo[n]==-1) {
            int res=Integer.MAX_VALUE;

            if(n==0) res=0;

            for(int i=0; i<=n-1; i++) {
                if(i+arr[i]>=n) {
                    int sub_res=memoization(arr, memo, i);
                    if(sub_res!=Integer.MAX_VALUE) res=Math.min(res, sub_res+1);
                }
            }

            memo[n]=res;
        }

        printArray(memo);
        return memo[n];
    }

    static int myTabulationSolution(int[] arr, int n) {
        int[] tab=new int[n];

        tab[0]=0;

        for(int i=1; i<n; i++) {
            tab[i]=Integer.MAX_VALUE;
            for(int j=i-1; j>=0; j--) {
                if(j+arr[j]>=i) {
                    tab[i]=Math.min(tab[i], tab[j]+1);
                }
            }
        }

        printArray(tab);
        return tab[n-1];
    }

    static int greedySolution(int[] arr, int n) {
        // In this solution, We Iterate through windows of elements. We calculate the maximum jump that can be made from each window of elements. And iteratively calculate the numbers of jumps needed.

        int left=0, right=0, res=0;

        while(right<n-1) {
            int farthest=0;

            for(int i=left; i<=right; i++) {
                farthest=Math.max(farthest, i+arr[i]);
            }

            left=right+1;
            right=farthest;
            res++;
        }

        return res;
    }

    static void printArray(int[] arr) {
        for(int k: arr){
            System.out.print(k+", ");
        }

        System.out.println();
    }
}
