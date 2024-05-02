import java.util.Arrays;

public class gfg_19_mergeOverlappingIntervals{
    public static void main(String[] args)
    {
        Interval[] arr={new Interval(5, 10), new Interval(2, 3), new Interval(6, 8), new Interval(1, 7)};
        efficientSolution(arr);
    }

    public static boolean checkIfIntervalsMerge(int[] arr1, int[] arr2)
    {
        if(arr1[0]>=arr2[0] && arr1[0]<=arr2[1])
        {
            return true;
        }
        else if(arr2[0]>=arr1[0] && arr2[0]<=arr1[1])
        {
            return true;
        }

        return false;
    }

    public static void naiveSolution(Interval[] arr)
    {
        // Time complexity : O(n*n*n)
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length; j++)
            {
                if(i!=j && arr[i].a>=arr[j].a && arr[i].a<=arr[j].b)
                {
                    int min, max;
                    if(arr[i].a<arr[j].a)
                    {
                        min=arr[i].a;
                    }
                    else
                    {
                        min=arr[j].a;
                    }

                    if(arr[i].b>arr[j].b)
                    {
                        max=arr[i].b;
                    }
                    else
                    {
                        max=arr[j].b;
                    }
                    System.out.print("Merge Intervals {"+arr[i].a+", "+arr[i].b+"} and {"+arr[j].a+", "+arr[j].b+"}");
                    System.out.println(" to {"+min+", "+max+"};");
                    System.out.println();
                }
            }
        }
    }

    public static void efficientSolution(Interval[] arr)
    {
        Arrays.sort(arr);

        int res=0;

        for(int i=1; i<arr.length; i++)
        {
            if(arr[i].a<=arr[res].b)
            {
                int min, max;
                if(arr[i].a<arr[res].a)
                {
                    min=arr[i].a;
                }
                else
                {
                    min=arr[res].a;
                }

                if(arr[i].b>arr[res].b)
                {
                    max=arr[i].b;
                }
                else
                {
                    max=arr[res].b;
                }

                arr[res].a=min;
                arr[res].b=max;
            }
            else
            {
                res++;
                arr[res]=arr[i];
            }
        }

        System.out.println("Array after merging : ");
        for(int i=0; i<=res; i++)
        {
            System.out.print("{"+arr[i].a+", "+arr[i].b+"}, ");
        }
    }
}

class Interval implements Comparable<Interval>{
    int a;
    int b;

    public Interval(int a, int b)
    {
        this.a=a;
        this.b=b;
    }

    public int compareTo(Interval a)
    {
        return this.b-a.b;
    }
}
