public class kkkk {
    public static void main(String[] args)
    {
        int[] arr={1,1,1,2,3,8,9,10};
        frequencies(arr);
    }

    public static void frequencies(int[] arr)
    {
        int freq=0, element=1, size=arr.length, index=0, flag=0, count=0;

        while(index<arr.length && element<=size+2)
        {
            if(element==arr[index])
            {
                flag=1;
                freq++;
                index++;
                // System.out.println(element+"==arr["+index+"]"+", freq="+freq);
            }
            else
            {
                // System.out.println("element="+element+", flag="+flag+", freq="+freq);
                if(flag==0)
                {
                    System.out.print(0+" ");
                    count++;
                    element++;
                    continue;
                }
                System.out.print(freq+" ");
                count++;
                freq=0;
                flag=0;
                element++;
            }
        }
        System.out.print(freq+" ");
        count++;
        // System.out.println("count="+count);
        while(count<size)
        {
            System.out.print(0+" ");
            count++;
        }
    }
}
