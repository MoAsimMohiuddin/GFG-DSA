public class moveZerosToEnd {
    public static void main(String[] args)
    {
        int[] arr={0,1,1,0,2,4,0,5,7,0,1,2};
        efficientSolution(arr);
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static void method(int[] arr)
    {
        
    }

    public static void efficientSolution(int[] arr)
    {
        int count=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count++]=temp;
            }
        }
    }
}
