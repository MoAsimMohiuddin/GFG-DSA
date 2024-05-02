public class repeatingElement {
    public static void main(String[] args) {
        int[] arr={0,2,1,3,5,4,6,2};
        int res=efficientApproach1(arr);
        System.out.println(res);
    }

    public static int booleanArrayApproach(int[] arr)
    {
        boolean[] boolArr=new boolean[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            if(boolArr[arr[i]]==false)
            {
                boolArr[arr[i]]=true;
            }
            else if(boolArr[arr[i]]==true)
            {
                return arr[i];
            }
        }

        return -1;
    }

    public static int efficientApproach(int[] arr)
    {
        // For Arrays with values excluding 0.
        /*
        This is a famous Algorithm called Floyd's cycle detection Algorithm or Hare-Tortoise Algorithm
        which used to detect a loop in a linked list. But we can also use it to detect a loop in Array.
        */
        int slow = arr[0], fast = arr[0];

		do{
			slow = arr[slow];
			fast = arr[arr[fast]];
		
		}while(slow != fast);
		
		slow = arr[0];

		while(slow != fast)
		{
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
    }

    public static int efficientApproach1(int[] arr)
    {
        // For Arrays with values including 0.
        int slow=arr[0]+1, fast=arr[0]+1;

        do
        {
            slow=arr[slow]+1;
            fast=arr[arr[fast]+1]+1;
        }
        while(slow!=fast);

        slow=arr[0]+1;

        while(slow!=fast)
        {
            slow=arr[slow]+1;
            fast=arr[fast]+1;
        }

        return slow-1;
    }
}
