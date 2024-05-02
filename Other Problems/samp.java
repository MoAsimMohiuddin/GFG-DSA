public class samp {
    public static void main(String[] args)
    {
        System.out.println(Math.floorDiv(1, 2)+Math.floorDiv(1, 2));
    }

    public static int digitalRoot(int n)
    {
        // add your code here
        while(n/10>0)
        {
            n=sumOfDigits(n);
            if(n/10==0)
            {
                return n;
            }
        }

        return n;
    }
    
    static int sumOfDigits(int n)
    {
        int sum=0;
        
        while(n>0)
        {
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        
        return sum;
    }

    public static boolean subSequence(String str, String subString)
    {
        int index=0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)==subString.charAt(index))
            {
                index++;
            }
        }

        if(index==subString.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int[] twoRepeated(int arr[], int N)
    {
        // Your code here
        int [] result=new int[2];
        for(int i=0; i<arr.length; i++)
        {
            System.out.println("at i="+i+" the array is :");
            printArray(arr);   
            arr[Math.abs(arr[i])-1]=arr[Math.abs(arr[i])-1]*-1;
        }
        System.out.println("Modified array is : ");
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
        // int index=0;
        // for(int k:arr)
        // {
        //     if(k>0)
        //     {
        //         result[index]=k;
        //         index+=1;
        //     }
        // }
        
        return result;
    }

    public static void printArray(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
    public static int searchInSortedRotatedArray(int[] arr, int key)
    {
        int low=0, high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            System.out.println("arr[mid]="+arr[mid]);
            if(arr[mid]==key)
            {
                return mid;
            }
            if(arr[mid]>arr[low])
            {
                if(key>arr[low] && key<arr[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(key>arr[mid] && key<=arr[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }

        return -1;
    }

    public static int minimumElementInSortedRotatedArray(int[] arr)
    {
        int low=0, high=arr.length-1, min=Integer.MAX_VALUE;
        while(low<=high)
        {
            if(low-high>=-1 && low-high<=1)
            {
                if(arr[low]<min)
                {
                    min=arr[low];
                }
                if(arr[high]<min)
                {
                    min=arr[high];
                }
            }
            int mid=(low+high)/2;
            System.out.println("arr[mid]="+arr[mid]);
            if(arr[mid]>arr[low])
            {
                if(arr[low]<min)
                {
                    min=arr[low];
                }
                low=mid+1;
            }
            else
            {
                if(arr[mid]<min)
                {
                    min=arr[mid];
                }
                high=mid-1;
            }
        }

        return min;
    }
}
