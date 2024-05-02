public class majorityElement {
    public static void main(String[] args) {
        int[] arr={8,3,4,8,8};
        System.out.println(mooresVotingAlgorithm(arr));
    }

    public static int mooresVotingAlgorithm(int[] arr)
    {
        int count=1, maj=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]==maj)
            {
                count++;
            }
            else
            {
                count--;
            }

            if(count==0)
            {
                maj=arr[i];
                count=1;
            }
        }

        count=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==maj)
            {
                count++;
            }
        }

        if(count>arr.length/2)
        {
            return maj;
        }
        else
        {
            return -1;
        }
    }
}
