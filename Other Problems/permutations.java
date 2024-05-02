import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        String str="abc";
        List<String> result=permuteString(str);
        System.out.println(result);
    }

    static void recurPermute(List<List<Integer>> ans, List<Integer> ds, boolean[] freq, int[] arr)
    {
        if(ds.size()==arr.length)
        {
            ans.add(new ArrayList<>(ds));
        }
        else
        {
            for(int i=0; i<arr.length; i++)
            {
                if(!freq[i])
                {
                    freq[i]=true;
                    ds.add(arr[i]);
                    recurPermute(ans, ds, freq, arr);
                    freq[i]=false;
                    ds.remove(ds.size()-1);
                }
            }
        }
    }

    static List<List<Integer>> permute(int[] arr)
    {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] freq=new boolean[arr.length];
        List<Integer> ds=new ArrayList<>();

        recurPermute(ans, ds, freq, arr);

        return ans;
    }

    static List<String> permuteString(String str)
    {
        List<String> ans=new ArrayList<>();
        boolean[] freq=new boolean[str.length()];
        ArrayList<Character> ds=new ArrayList<Character>();
        char[] arr=str.toCharArray();
        recurPermuteString(arr, ans, freq, ds);
        return ans;
    }

    static void recurPermuteString(char[] arr, List<String> ans, boolean[] freq, ArrayList<Character> ds)
    {
        if(ds.size()==arr.length)
        {
            String str="";
            for(int i=0; i<ds.size(); i++)
            {
                str+=ds.get(i);
            }
            ans.add(str);
        }

        for(int i=0; i<arr.length; i++)
        {
            if(!freq[i])
            {
                freq[i]=true;
                ds.add(arr[i]);
                recurPermuteString(arr, ans, freq, ds);
                freq[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
