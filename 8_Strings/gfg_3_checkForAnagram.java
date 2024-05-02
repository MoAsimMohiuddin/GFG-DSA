import java.util.HashMap;
import java.util.Map;

public class gfg_3_checkForAnagram {
    public static void main(String[] args)
    {
        boolean result=arrayMethod("asim", "isam");
        System.out.println(result);
    }

    public static boolean arrayMethod(String str1, String str2)
    {
        // This method is based on an assumption that all the letters in both the strings are lowercase.
        char[] array=new char[26];

        for(int i=0; i<str1.length(); i++)
        {
            array[str1.charAt(i)-'a']++;
        }

        for(int i=0; i<str2.length(); i++)
        {
            array[str2.charAt(i)-'a']--;
        }

        for(int k:array)
        {
            System.out.println(k);
            if(k!=0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean hashMapMethod(String str1, String str2)
    {
        // This method works for lowercase as well as uppercase letters in the strings.
        // Using HashMap.
        HashMap<Character, Integer> hMap=new HashMap<Character, Integer>();

        for(int i=0; i<str1.length(); i++)
        {
            if(!hMap.containsKey(str1.charAt(i)))
            {
                hMap.put(str1.charAt(i), 1);
            }
            else
            {
                hMap.put(str1.charAt(i), hMap.get(str1.charAt(i))+1);
            }
        }

        for(int i=0; i<str2.length(); i++)
        {
            if(!hMap.containsKey(str2.charAt(i)))
            {
                return false;
            }
            else
            {
                hMap.put(str2.charAt(i), hMap.get(str2.charAt(i))-1);
            }
        }

        for(Map.Entry<Character, Integer> el:hMap.entrySet())
        {
            if(el.getValue()!=0)
            {
                return false;
            }
        }

        // System.out.println(hMap);
        return true;
    }

    public static boolean characterArrayMethod(String str1, String str2)
    {
        if(str1.length()!=str2.length())
        {
            return false;
        }

        char[] charArray=new char[256];

        for(int i=0; i<str1.length(); i++)
        {
            charArray[str1.charAt(i)]++;
            charArray[str2.charAt(i)]--;
        }

        for(int k:charArray)
        {
            if(k!=0)
            {
                return false;
            }
        }
        return true;
    }
}
