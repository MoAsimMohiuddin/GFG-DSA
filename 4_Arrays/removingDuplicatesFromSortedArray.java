public class removingDuplicatesFromSortedArray {
    public static void main(String[] args)
    {
        int[] arr={1,1,1,1,2,2,3,3,3,4,4,4,5,5,5};
        solution(arr);
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static void solution(int[] arr)
    {
        int res=1;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]!=arr[res-1])
            {
                arr[res]=arr[i];
                res++;
            }
        }
        for(int i=res; i<arr.length; i++)
        {
            arr[i]=-1;
        }
    }
}
