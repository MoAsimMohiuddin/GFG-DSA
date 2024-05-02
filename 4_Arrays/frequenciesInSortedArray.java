public class frequenciesInSortedArray {
    public static void main(String[] args)
    {
        int[] arr={1};
        method(arr);
    }

    static void method(int[] arr)
    {
        int element=arr[0], count=1, size=arr.length;

        for(int i=1; i<size; i++)
        {
            if(arr[i]==element)
            {
                count++;
            }
            else
            {
                System.out.println(arr[i-1]+"="+count);
                element=arr[i];
                count=1;
            }
        }
        System.out.println(arr[size-1]+"="+count);
    }
}
