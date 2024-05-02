public class smallestPositiveMissingNumber {
    public static void main(String[] args)
    {
        int[] arr={5,2,1,3};
        int result=efficientSolution(arr);
        System.out.println("The Smallest Positive Missing Number is "+result);
        System.out.println("Modified Array is");
        printArray(arr);
    }

    // We can write the naive solution by using an extra array to mark the found elements.

    public static int efficientSolution(int[] arr)
    {
        // In this solution, We keep the elements in the range 1,size(inclusive) on their respective indices in the array. i.e element 1 at index 0, element 3 at index 2 , etc. And then we iteratively check if the current element is equal to i+1 or not. If not, We return i+1.

        int size=arr.length;
        for(int i=0; i<size; i++)
        {
            // We use a while loop because even after swapping once, If the swapped element is still in the range of 1, size we still need to swap it.
            while((arr[i]>=1 && arr[i]<=size) && (arr[i]!=arr[arr[i]-1]))
            {
                int temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
        }

        for(int i=0; i<size; i++)
        {
            if(arr[i]!=i+1)
            {
                return i+1;
            }
        }

        return size+1;
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
