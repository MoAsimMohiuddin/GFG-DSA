import java.util.HashSet;

public class Chocolates_Virtusa {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};

        HashSet<Integer> hSet=new HashSet<>();
        System.out.println(method(arr, hSet, 0, arr.length-1, 2));
    }

    static int method(int[] arr, HashSet<Integer> hSet, int low, int high, int k) {
        System.out.println("Low="+low+", high="+high);

        if(low>high) return 0;
        if(low==high) {
            System.out.println("Low==High");
            if(low==k-1) {
                if(!hSet.contains(31*low*high)) {
                    System.out.println("Match Found");
                    hSet.add(31*low*high);
                    return 1;
                }else{
                    return 0;
                }
            }
            else return 0;
        }

        return method(arr, hSet, low+1, high, k)+method(arr, hSet, low, high-1, k);
    }
}
