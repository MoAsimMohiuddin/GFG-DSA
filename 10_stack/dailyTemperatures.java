import java.util.Arrays;
import java.util.Stack;

public class dailyTemperatures {
    public static void main(String[] args) {
        int[] arr={73, 74, 75, 71, 69, 72, 76, 73};

        int[] result=efficientMethod(arr);

        for(int k:result) {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static int[] efficientMethod(int[] arr) {
        int len=arr.length;
        int[] result=new int[len];
        Arrays.fill(result, 0, len, 0);
        
        Stack<Integer> stack=new Stack<Integer>();

        for(int i=0; i<len; i++) {
            while (!stack.isEmpty() && arr[i]>arr[stack.peek()]) {
                result[stack.peek()]=i-stack.peek();

                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}
