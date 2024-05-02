// Suppose we have two numbers a, b less than n. Now, If we increment a by b*n, Then a becomes a+b*n. Now, If we divide a+b*n by n, It becomes b. If we do modulo n, It becomes a. So, We have two numbers stored in a+b*n.
// So, For every element in the array, We update the values with a[i]=a[i]+(a[a[i]]%size)*size. Then divide each element with size.

public class rearrangeTheArray{
    public static void rearrange(int[] arr)
    {
        int size=arr.length;

        for(int i=0; i<arr.length; i++)
        {
            arr[i]+=((int)arr[(int)arr[i]]%size)*size;
        }

        for(int i=0; i<size; i++)
        {
            arr[i]/=size;
        }
    }

    public static void main(String[] args) {
        int[] arr={5, 0, 3, 7, 1, 4, 6, 2};
        rearrange(arr);
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
