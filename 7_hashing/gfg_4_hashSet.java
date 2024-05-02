import java.util.HashSet;
import java.util.Iterator;

public class gfg_4_hashSet {
    public static void main(String[] args)
    {
        int[] keys={50, 51, 49, 16, 56, 15, 19};
        HashSet<Integer> myHSet=new HashSet<Integer>(keys.length);
        // Used to store only keys.

        for(int key:keys)
        {
            myHSet.add(key);
        }

        // for(int k:myHSet)
        // {
        //     System.out.print(k+", ");
        // }
        // System.out.println();

        Iterator<Integer> iter=myHSet.iterator();

        while(iter.hasNext())
        {
            System.out.print(iter.next()+", ");
        }

        System.out.println();
        System.out.println(myHSet.contains(49));
        System.out.println(myHSet.hashCode());
    }
}