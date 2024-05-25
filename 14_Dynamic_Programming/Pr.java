import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pr {
    public static void main(String[] args) {
        List<String> words=new ArrayList<>();
        words.add("rat");
        words.add("mat");
        words.add("bat");
        words.add("cat");
        words.add("chat");
        words.add("tab");
        words.add("fab");
        words.add("batt");

        List<Character> chars=new ArrayList<>();
        chars.add('t');
        chars.add('a');
        chars.add('b');
        chars.add('c');

        wordCanBeFormed(words, chars);
    }

    static void wordCanBeFormed(List<String> words, List<Character> chars) {
        // You are given a dictionary (a set of words). They will enter a set of characters you have to print all the words that can be formed using these characters.
        int wordsLen=words.size(), charsLen=chars.size();
        HashMap<Character, Integer> hMap=new HashMap<Character, Integer>();

        for(int i=0; i<wordsLen; i++) {
            hMap.clear();
            boolean bool=true;
            for(int j=0; j<charsLen; j++) {
                hMap.put(chars.get(j), hMap.getOrDefault(chars.get(j), 0)+1);
            }
            char[] charArray=words.get(i).toCharArray();

            for(char ch: charArray) {
                if(!hMap.containsKey(ch)) {
                    bool=false;
                    break;
                } else {
                    hMap.put(ch, hMap.get(ch)-1);
                    if(hMap.get(ch)==0) hMap.remove(ch);
                }
            }

            if(!bool) {
                continue;
            } else{
                System.out.println(words.get(i));
            }
        }
    }

    static String reverseVowels(String s) {
        StringBuilder str=new StringBuilder(s);
        List<Character> vowels=new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int len=str.length(), i=0, j=len-1;

        while(i<j) {
            while(i<len && !vowels.contains(str.charAt(i))) i++;
            while(j>=0 && !vowels.contains(str.charAt(j))) j--;
            if(i>=j) break;
            char temp=str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;j--;
        }

        return str.toString();
    }

    static void fiboUsingLoop(int n) {
        int a=0, b=1, sum=0, count=0;

        System.out.print(a+", "+b+", ");

        while(count<n) {
            sum=a+b;
            System.out.print(sum+", ");
            a=b;
            b=sum;
            count++;
        }
    }

    static void fibonacciUsingRecursion(int n) {
        System.out.print("0, 1, ");
        helperFunctionFibo(0, 1, n, 0);
    }
    static void helperFunctionFibo(int a, int b, int n, int count) {
        if(count>=n) {return;}
        System.out.print(a+b+", ");
        helperFunctionFibo(b, a+b, n, count+1);
    }

    static int nthFiboUsingLoop(int n) {
        int a=0, b=1, res=0, count=2;

        while(count++<n) {
            res=a+b;
            a=b;
            b=res;
        }
        return res;
    }

    static int nthFiboUsingRecursion(int n) {
        if(n==0||n==1) {return n;}
        return nthFiboUsingRecursion(n-1)+nthFiboUsingRecursion(n-2);
    }

    static int[] memo=new int[100];

    static int fiboOptimizedUsingDP(int n) {
        Arrays.fill(memo, -1);
        return dpHelper(n);
    }
    static int dpHelper(int n) {
        if(memo[n]==-1) {
            int res;
            if(n==0 || n==1) {
                res=n;
            }else{
                res=dpHelper(n-1)+dpHelper(n-2);
            }

            memo[n]=res;
        }

        printArray(memo);
        return memo[n];
    }


    static void printArray(int[] arr) {
        System.out.println("***");
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
        System.out.println("***");
    }

    static int lcs(String str1, String str2, int m, int n) {
        if(m<=0 || n<=0) {
            return 0;
        }else{
            int res;
            if(str1.charAt(m-1)==str2.charAt(n-1)) {
                res = 1+lcs(str1, str2, m-1, n-1);
            }else{
                res=Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
            }

            return res;
        }
    }

    static int coinChange(int[] coins, int amount, int size) {
        return helperFunctionCoinChange(coins, 0, amount, 0);
    }

    static int helperFunctionCoinChange(int[] coins, int startIndex, int amount, int count) {
        if(startIndex>=coins.length || amount<0) return Integer.MAX_VALUE;
        if(amount == 0) {
            return count;
        }
        else {
            return Math.min(helperFunctionCoinChange(coins, startIndex, amount-coins[startIndex], count+1), helperFunctionCoinChange(coins, startIndex+1, amount, count));
        }
    }

    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length;
        if(n>len) return false;

        if(len==1 && flowerbed[0]==0) return true;

        if(flowerbed[0]==0 && flowerbed[1]==0) {
            flowerbed[0]=1;
            n--;
        }
        if(n==0) return true;
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0) {
            flowerbed[len-1]=1;
            n--;
        }
        if(n==0) return true;

        for(int i=1; i<len-1; i++) {
            if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0) {
                flowerbed[i]=1;
                n--;
            }

            if(n==0) break;
        }

        if(n==0) return true;
        return false;
    }
}
