public class maximumConsecutiveOnes {
    public static void main(String[] args) {
        int [] arr={1,0,1,1,1,1,0,1,1};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr)
    {
        int count=0, maxCount=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==1)
            {
                count++;
                if(count>maxCount)
                {
                    maxCount=count;
                }
            }
            else
            {
                count=0;
            }
        }

        return maxCount;
    }
}