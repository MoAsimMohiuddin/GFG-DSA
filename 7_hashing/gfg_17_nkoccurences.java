import java.util.HashMap;
import java.util.Map;

public class gfg_17_nkoccurences {
    public static void main(String[] args)
    {
        int[] arr={30, 10, 20, 30, 30, 40, 30, 40, 30};
        OnkSolution(arr, 4);
    }

    public static void OnkSolution(int[] arr, int k)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++)
        {
            if(hMap.size()==k-1)
            {
                for(Map.Entry<Integer, Integer> element:hMap.entrySet())
                {
                    int key=element.getKey(), value=element.getValue();
                    hMap.put(key, value-1);
                    value=hMap.get(key);
                    if(value==0)
                    {
                        hMap.remove(key);
                    }
                }
            }
            if(hMap.containsKey(arr[i]))
            {
                hMap.put(arr[i], hMap.get(arr[i])+1);
                System.out.println("Inserted "+arr[i]);
            }
            else
            {
                hMap.put(arr[i], 1);
                System.out.println("Inserted "+arr[i]);
            }
        }

        for(Map.Entry<Integer, Integer> el:hMap.entrySet())
        {
            int count=0;
            for(int i=0; i<arr.length; i++)
            {
                if(el.getKey()==arr[i])
                {
                    count++;
                }
            }
            if(count>arr.length/k)
            {
                System.out.println(arr[el.getKey()]);
            }
        }
    }

    public static void hashMapSolution(int[] arr, int k)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++)
        {
            if(hMap.containsKey(arr[i]))
            {
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }
            else
            {
                hMap.put(arr[i], 1);
            }
        }

        System.out.println("The hashMap is");
        System.out.println(hMap);
        System.out.println("Elements occuring more than n/k times are");
        for(int el:arr)
        {
            if(hMap.get(el)>arr.length/k)
            {
                hMap.put(el, -1);
                System.out.println(el);
            }
        }
        // System.out.println();

        // // System.out.println("For each");
        // for(Map.Entry<Integer, Integer> element:hMap.entrySet())
        // {
        //     System.out.println(element);
        // }
    }
}
