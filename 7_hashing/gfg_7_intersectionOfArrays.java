import java.util.HashSet;

public class gfg_7_intersectionOfArrays {
    public static void main(String[] args)
    {
        int[] arr1={10, 15, 20, 15, 30, 30, 5};
        int[] arr2={30, 5, 30, 80};
        int result=intersection(arr1, arr2);
        System.out.println(result);
    }

    public static int intersection(int[] arr1, int[] arr2)
    {
        HashSet<Integer> hset=new HashSet<Integer>();
        // HashSet<Integer> intersection=new HashSet<Integer>();
        for(int i:arr1)
        {
            hset.add(i); 
        }

        int count=0;
        // for(int i:arr2)
        // {
        //     if(hset.add(i)==false)
        //     {
        //         if(intersection.contains(i)==false)
        //         {
        //             count++;
        //             System.out.print(i+", ");
        //             intersection.add(i); 
        //         }
        //     }
        // }

        for(int i:arr2)
        {
            if(hset.contains(i))
            {
                count++;
                hset.remove(i);
            }
        }
        
        System.out.println();
        return count;
    }
}
