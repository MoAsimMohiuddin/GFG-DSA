public class maxEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr={7,10,13,14};
        int result=efficientSolution(arr);
        System.out.println(result);
    }

    public static int efficientSolution(int[] arr)
    {
        int index1=0, index2=0, maxDiff=Integer.MIN_VALUE, curDiff=0;

        for(int i=1; i<arr.length; i++)
        {
            if( (arr[i]%2==0 && arr[i-1]%2==1) || (arr[i]%2==1 && arr[i-1]%2==0))
            {
                index2++;
            }
            else
            {
                index1=i;
                index2=i;
            }

            curDiff=index2-index1;
            if(curDiff>maxDiff)
            {   
                maxDiff=curDiff;
            }
        }

        return maxDiff+1;
    }
}
