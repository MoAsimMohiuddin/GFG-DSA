public class maximumEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr={10, 12, 14, 7, 8};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr)
    {
        int count=1, maxCount=1;
        for(int i=1; i<arr.length; i++)
        {
            if( (arr[i]%2==0 && arr[i-1]%2==1) || (arr[i]%2==1 && arr[i-1]%2==0))
            {
                count++;
                if(count>maxCount)
                {
                    maxCount=count;
                }
            }
            else
            {
                count=1;
            }
        }

        return maxCount;
    }
}
