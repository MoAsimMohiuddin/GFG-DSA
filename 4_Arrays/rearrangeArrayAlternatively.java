// Question: Given a sorted array of integers, Rearrange the array in such a way that maxEl1, minEl1, maxEl2, minEl2, etc.
public class rearrangeArrayAlternatively {
    public static void twoPointerSolution(int[] arr)
    {
        int size=arr.length, low=0, high=size-1, index=0;
        int[] newArr=new int[size];

        while(low<high)
        {
            newArr[index++]=arr[high--];
            newArr[index++]=arr[low++];
        }

        for(int i=0; i<size; i++)
        {
            arr[i]=newArr[i];
        }
    }

    public static void efficientSolution(int[] arr)
    {
        // If we look at the question, We basically have to place the maximum elements at the even indexes and the minimum elements at the odd indexes. So, We can use the following technique.
        // When we have two numbers a,b both less than n, Then if we add b*n to a, a becomes a+b*n. If we divide a+b*n with n, It becomes b, If we do modulo, We get a.
        // Now, We place minIndex at 0, and maxIndex at n-1, And the maxElement as the lastElement+1, And switch the maxElements at even indexes and minElements at odd indexes. 

        int size=arr.length, minIndex=0, maxIndex=size-1, maxElement=arr[size-1]+1;
        for(int i=0; i<size; i++)
        {
            if(i%2==0)
            {
                arr[i]+=(arr[maxIndex--]%maxElement)*maxElement;
            }
            else
            {
                arr[i]+=(arr[minIndex++]%maxElement)*maxElement;
            }
        }

        for(int i=0; i<size; i++)
        {
            arr[i]/=maxElement;
        }
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5,6};
        twoPointerSolution(arr);
        printArray(arr);
    }
}
