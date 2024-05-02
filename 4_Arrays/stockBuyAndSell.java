public class stockBuyAndSell {
    public static void main(String[] args) {
        int[] arr={1,5,3,8,12};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr)
    {
        int profit=0;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]>arr[i-1])
            {
                profit+=arr[i]-arr[i-1];
            }
        }

        return profit;
    }
}
