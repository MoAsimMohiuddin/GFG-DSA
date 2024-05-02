import java.util.HashSet;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        
    }

    static int longestSubstrDistinctChars(String s){
        // code here
        HashSet<Character> set=new HashSet<>();

        int len=s.length(), max=0, count=0, start=0;

        for(int i=0; i<len; i++) {
            if(set.add(s.charAt(i))) {
                count++;
                max=Math.max(max, count);
            }else{
                while(s.charAt(start)!=s.charAt(i)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                count=i-start+1;

                set.add(s.charAt(i));
            }
        }

        return max;
    }
}
