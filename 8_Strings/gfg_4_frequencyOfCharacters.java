public class gfg_4_frequencyOfCharacters{
    public static void main(String[] args)
    {
        // System.out.println('a'-'b');
        String str="mohammedasimmohiuddin";
        function(str);
    }

    public static void function(String str)
    {
        int[] count=new int[26];

        for(int i=0; i<str.length(); i++)
        {
            count[str.charAt(i)-'a']++;
        }

        for(int i=0; i<count.length; i++)
        {
            if(count[i]>0)
            {
                System.out.print((char)(i+'a'));
                System.out.println(count[i]);
            }
        }
    }
}