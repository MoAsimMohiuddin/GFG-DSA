import java.util.Arrays;

public class mergeWithoutExtraSpace {
    public static void main(String[] args)
    {
        int[] arr1={1, 2 ,6 ,7, 7 ,15, 21, 30, 39 ,41 ,41 ,43 ,43 ,44 ,47, 49};
        int[] arr2={5, 7, 9 ,17, 24, 27, 30, 32, 35 ,41, 49};

        merge(arr1, arr2);
        for(int k:arr1)
        {
            System.out.print(k+", ");
        }
        for(int k:arr2)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static void merge(int[] arr1, int[] arr2)
    {
        int size1=arr1.length, size2=arr2.length;

        for(int i=size2-1; i>=0; i--)
        {
            int j, last=arr1[size1-1];
            for(j=size1-2; j>=0 && arr1[j]>arr2[i]; j--)
            {
                arr1[j+1]=arr1[j];
            }

            if(last>arr2[i])
            {
                arr1[j+1]=arr2[i];
                arr2[i]=last;
            }
        }
    }

    public static void myMethod(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        int i1=0, i2=0;
        
        while(i1<arr1.length && i2<arr2.length)
        {
            if(arr2[i2]<arr1[i1])
            {
                int index=i2;
                while(index<arr2.length-1 && arr2[index]>arr2[index+1])
                {
                    swap(arr2, arr2, index, index+1);
                    index++;
                }
                // System.out.print("arr[i1]="+arr1[i1]+", arr[i2]="+arr2[i2]+" so swapped.");
                swap(arr1, arr2, i1, i2);
                i1++;
                printArray(arr1);
                printArray(arr2);
                // if(i1<arr1.length && i2<arr2.length)
                // {
                //     System.out.print(" So, Now arr1[i1]="+arr1[i1]+", arr2[i2]="+arr2[i2]);
                // }
                // System.out.println();
            }
            else
            {
                i1++;
            }
        }

        int index=0;
        while(index<arr2.length-1 && arr2[index]>arr2[index+1])
        {
            swap(arr2, arr2, index, index+1);
            index++;
        }

        Arrays.sort(arr1);
    }
    
    public static void swap(long[] arr1, long[] arr2, int i1, int i2)
    {
        long temp=arr1[i1];
        arr1[i1]=arr2[i2];
        arr2[i2]=temp;
    }

    public static void printArray(long[] arr)
    {
        for(long k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
