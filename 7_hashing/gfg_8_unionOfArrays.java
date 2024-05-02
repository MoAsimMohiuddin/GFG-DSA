import java.util.HashSet;

public class gfg_8_unionOfArrays {
    public static void main(String[] args)
    {
        int[] arr1={3,3,3};
        int[] arr2={3,3};
        int result=union(arr1, arr2);
        System.out.println(result);
    }

    public static int union(int[] arr1, int[] arr2)
    {
        HashSet<Integer> hset=new HashSet<Integer>();

        for(int i:arr1)
        {
            if(hset.add(i))
            {
                System.out.print(i+", ");
            }
        }
        for(int i:arr2)
        {
            if(hset.add(i))
            {
                System.out.print(i+", ");
            }
        }

        System.out.println();


        return hset.size();
    }
}
