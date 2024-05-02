import java.util.HashMap;

public class gfg_16_distinctElementsInEachWindow {
    public static void main(String[] args)
    {
        int[] arr={10, 20, 10, 10, 30, 40};
        hashSetSolution(arr, 4);
    }
    
    public static void hashSetSolution(int[] arr, int k)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        for(int i=0; i<k; i++)
        {
            if(!hMap.containsKey(arr[i]))
            {
                hMap.put(arr[i], 1);
            }
            else
            {
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }
        }
        System.out.print(hMap.size()+", ");
        for(int i=k; i<arr.length; i++)
        {
            System.out.println("element="+arr[i]);
            System.out.println(hMap);
            if(hMap.get(arr[i-k])==1)
            {
                hMap.remove(arr[i-k]);
            }
            else if(hMap.get(arr[i-k])>1)
            {
                hMap.put(arr[i-k], hMap.get(arr[i-k])-1);
            }
            if(hMap.containsKey(arr[i]))
            {
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }
            else
            {
                hMap.put(arr[i], 1);
            }

            System.out.print(hMap.size()+", ");
        }
        System.out.println(hMap);
    }
}