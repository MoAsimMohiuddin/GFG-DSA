// Question :
// Given an array arr[] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

import java.util.Stack;

public class next_greater_element {
    public static void main(String[] args) {
        int[] arr={73, 74, 75, 71, 69, 72, 76, 73};
        int[] result=nextLargerElement(arr, arr.length);

        for(int k:result)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static int[] nextLargerElement(int[] arr, int n)
    { 
        // Your code here
        
        Stack<Integer> stack=new Stack<Integer>();
        
        int[] result=new int[n];
        
        int i=n-1;
        
        while(i>=0)
        {
            System.out.print("arr[i]="+arr[i]);
            if(stack.isEmpty())
            {
                System.out.println(", Stack was empty");
                result[i]=-1;
                stack.push(arr[i--]);
            }
            else
            {
                System.out.println();
                if(arr[i]<stack.peek())
                {
                    result[i]=stack.peek();
                    stack.push(arr[i--]);
                }
                else
                {
                    stack.pop();
                }
            }
        }
        
        return result;
    } 
}
