import java.util.Arrays;
import java.util.Collections;

public class greedyNumberofCoins {
    public static void main(String[] args) {
        Integer[] arr={10, 5, 2, 1};
        int target=37;

        System.out.println(meth(arr, target));
    }

    static int meth(Integer[] coins, int target) {
        Arrays.sort(coins, Collections.reverseOrder());

        int result=0;

        for(Integer coin:coins) {
            if(target>=coin){
                int howmany=target/coin;
                System.out.println(coin+"="+howmany+" coins");
                result+=howmany;

                target-=(howmany*coin);
            }

            if(target==0) {
                break;
            }
        }

        return result;
    }
}
