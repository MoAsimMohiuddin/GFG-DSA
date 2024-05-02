import java.util.ArrayList;

public class gfg_13_kthSmallestElement {
    public static void main(String[] args)
    {
        int[] arr={50,40,30,20,10};

        int result=myEfficientSolution(arr, 0, arr.length-1, 2);
        System.out.println(result);
    }

    public static int mySol(int[] arr, int k)
    {
        if(k<=0 || k>=arr.length)
        {
            return -1;
        }
        int count=0, curSmall=Integer.MAX_VALUE;
        ArrayList<Integer> indexList=new ArrayList<Integer>();

        while(count<k)
        {
            curSmall=Integer.MAX_VALUE;
            for(int i=0; i<arr.length; i++)
            {
                if(indexList.contains(i))
                {
                    continue;
                }

                if(arr[i]<curSmall)
                {
                    curSmall=arr[i];
                    indexList.add(i);
                }
            }
            count++;
        }

        return curSmall;
    }

    public static int mySol2(int[] arr, int k)
    {
        int minIndex=-1;
        for(int i=0; i<k; i++)
        {
            int min=Integer.MAX_VALUE;
            minIndex=i;
            for(int j=i; j<arr.length; j++)
            {
                if(arr[j]<min)
                {
                    min=arr[j]; 
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }

        return arr[k-1];
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static int efficientSolution(int[] arr, int low, int high, int k)
    {
        while(low<=high)
        {
            int pivot=lamutoPartition(arr, low, high);

            if(pivot==k-1)
            {
                return arr[pivot];
            }
            else if(pivot>k-1)
            {
                high=pivot-1;
            }
            else
            {
                low=pivot+1;
            }
        }

        return -1;
    }

    public static int myEfficientSolution(int[] arr, int low, int high, int k)
    {
        if(low>=high)
        {
            return -1;
        }
        else
        {
            int pivot=lamutoPartition(arr, low, high);
            if(pivot==k-1)
            {
                return arr[pivot];
            }
            else if(pivot>k-1)
            {
                return myEfficientSolution(arr, low, pivot-1, k);
            }
            else
            {
                return myEfficientSolution(arr, pivot+1, high, k);
            }
        }
    }

    public static int lamutoPartition(int[] arr, int low, int high)
    {
        int index=low, pivot=arr[high];

        for(int i=low; i<=high; i++)
        {
            if(arr[i]<pivot)
            {
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                index++;
            }
        }

        int temp=arr[index];
        arr[index]=arr[high];
        arr[high]=temp;

        return index;
    }
}
