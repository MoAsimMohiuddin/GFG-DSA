import java.util.ArrayDeque;

public class bp{
    public static void main(String[] args)
    {
        String str="{([])}";
        System.out.println(balancedParanthesis(str));
        // ArrayDeque<Character> stack=new ArrayDeque<Character>();
        // System.out.println(stack.peek());
    }

    static boolean balancedParanthesis(String str)
    {
        ArrayDeque<Character> stack=new ArrayDeque<Character>();
        int size=str.length();

        for(int i=0; i<size; i++)
        {
            switch(str.charAt(i))
            {
                case('['):
                    stack.push(str.charAt(i));
                    break;

                case('('):
                    stack.push(str.charAt(i));
                    break;
                
                case('{'):
                    stack.push(str.charAt(i));
                    break;
                
                case(']'):
                    if(stack.peek()==null) return false;
                    if(stack.peek()=='[') stack.pop();
                    else return false;
                    break;
                case(')'):
                    if(stack.peek()==null) return false;
                    if(stack.peek()=='(') stack.pop();
                    else return false;
                    break;
                case('}'):
                    if(stack.peek()==null) return false;
                    if(stack.peek()=='{') stack.pop();
                    else return false;
                    break;
            }
        }

        return stack.size()==0?true:false;
    }
}