import java.util.ArrayList;

public class ArrayLeaders {
    public static ArrayList<Integer> leaders(int[] arr)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int size=arr.length, currentLeader=arr[size-1];
        result.add(currentLeader);
        for(int i=size-2; i>=0; i--)
        {
            if(arr[i]>currentLeader)
            {
                result.add(arr[i]);
                currentLeader=arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr={1,10,3,8,5,6};
        ArrayList<Integer> result=new ArrayList<>();
        result=leaders(arr);
        System.out.println("The Leaders are:");
        for(int i=0; i<result.size(); i++)
        {
            System.out.print(result.get(i)+", ");
        }
        System.out.println();
    }
}
