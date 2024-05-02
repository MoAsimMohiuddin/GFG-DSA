public class subsetsRecursive {
    public static void main(String[] args) {
        subsets("abc");
    }

    static void subsets(String str)
    {
        printSubsets(str, "", 0);
    }

    static void printSubsets(String str, String curr, int index)
    {
        if(index==str.length())
        {
            System.out.println(curr);
            return;
        }

        printSubsets(str, curr, index+1);
        printSubsets(str, curr+str.charAt(index), index+1);
    }
}
