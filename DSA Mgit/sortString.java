import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sortString {
    public static void main(String[] args) {
        String str="aaaabbbbccccd";
        String res=remDup(str);

        System.out.println(res);

        HashMap<String, Integer> hMap=new HashMap<String, Integer>();

        hMap.put("red", 5);
        hMap.put("blue", 3);
        hMap.put("green", 8);
        hMap.put("yellow", 2);

        for(Map.Entry<String, Integer> el: hMap.entrySet()) {
            System.out.println(el.getKey());
        }
    }

    static String remDup(String str) {
        char[] arr=str.toCharArray();
        Arrays.sort(arr);

        int len=str.length();
        String result="";

        int temp=0;

        for(int i=1; i<len; i++) {
            if(arr[i]!=arr[i-1]) {
                result+=arr[temp];
                temp=i;
            }
        }
        result+=arr[len-1];

        return result;
    }
}
