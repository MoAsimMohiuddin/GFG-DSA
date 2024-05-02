import java.util.HashMap;
import java.util.Map;

public class gfg_5_hashMap {
    public static void main(String[] args)
    {
        // HashMaps are used to store key value pairs.
        // Most of the operations in hashMap are O(1) on average and some even O(1) in worst case.
        HashMap<String, Integer> myHMap=new HashMap<String, Integer>();

        myHMap.put("Messi", 10);
        myHMap.put("Messi", 10);
        myHMap.put("Ronaldinho", 10);
        myHMap.put("Neymar", 11);
        myHMap.put("Suarez", 9);
        myHMap.put("Iniesta", 8);

        System.out.println(myHMap);

        for(Map.Entry<String, Integer> entry:myHMap.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        System.out.println(myHMap.containsKey("Messi"));
        myHMap.remove("Messi");
        System.out.println(myHMap.containsKey("Messi"));

        System.out.println(myHMap.containsValue(11));


        System.out.println(myHMap.get("Neymar"));
        System.out.println(myHMap.get("Neymarrrrr"));
    }
}
