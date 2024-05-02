import java.util.ArrayList;
import java.util.List;

public class nextPermutation {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        List<Integer> arr1=new ArrayList<Integer>();
        for(int k:arr)
        {
            arr1.add(k);
        }

        List<Integer> result=method(arr1);
        System.out.println(result);
    }

    static List<Integer> method(List<Integer> arr)
    {
        List<List<Integer>> ans=new ArrayList<>();
        permutations(ans, arr, 0, 2);
        System.out.print("ans=");
        System.out.println(ans);
        List<Integer> result=new ArrayList<Integer>();

        for(int i=0; i<ans.size(); i++)
        {
            if(ans.get(i).equals(result))
            {
                result=ans.get(i+1);
                break;
            }
        }

        return result;
    }

    static void permutations(List<List<Integer>> ans, List<Integer> arr, int l, int r)
    {
        if(l==r)
        {
            ans.add(arr);
        }

        for(int i=l; i<=r; i++)
        {
            arr=swap(arr, l, i);
            permutations(ans, arr, l+1, r);
            arr=swap(arr, l, i);
        }
    }

    static List<Integer> swap(List<Integer> arr, int l, int r)
    {
        System.out.print("Before Swapping = ");
        System.out.println(arr);

        int element=arr.get(l);
        arr.set(l, arr.get(r));
        arr.set(r, element);

        System.out.print("After Swapping = ");
        System.out.println(arr);

        return arr;
    }
}
