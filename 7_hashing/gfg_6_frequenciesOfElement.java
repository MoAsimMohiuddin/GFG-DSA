import java.util.HashMap;
import java.util.Map;

public class gfg_6_frequenciesOfElement {
    public static void main(String[] args)
    {
        int[] arr={10, 12, 10, 15, 10, 20, 12, 12};
        frequencies(arr);
    }

    // In naive solution we can sort the array and print.
    public static void frequencies(int[] arr)
    {
        // HashMap approach runs the algorithms 

        HashMap<Integer, Integer> freqArray=new HashMap<Integer, Integer>();

        // for(int i=0; i<arr.length; i++)
        // {
        //     if(freqArray.containsKey(arr[i]))
        //     {
        //         int value=freqArray.get(arr[i]);
        //         freqArray.put(arr[i], value+1);
        //     }
        //     else
        //     {
        //         freqArray.put(arr[i], 1);
        //     }
        // }
        // System.out.println(freqArray);

        for(int el:arr)
        {
            freqArray.put(el, freqArray.getOrDefault(el, 0)+1);
        }

        for(Map.Entry<Integer, Integer> el:freqArray.entrySet())
        {
            System.out.println(el.getKey()+":"+el.getValue());
        }
    }
}
