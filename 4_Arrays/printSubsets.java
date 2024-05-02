import java.util.ArrayList;

public class printSubsets {
    public static void main(String[] args) {
        int[] arr={1, 2, 3};
        System.out.println(findSubsets(arr));
    }

    static ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> subset=new ArrayList<>();

        calcSubsets(arr, res, subset, 0, arr.length);
        return res;
    }

    static void calcSubsets(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int index, int size) {
        res.add(new ArrayList<>(subset));

        for(int i=index; i<size; i++) {
            subset.add(arr[i]);
            calcSubsets(arr, res, subset, i+1, size);
            subset.remove(subset.size()-1);
        }
    }
}
