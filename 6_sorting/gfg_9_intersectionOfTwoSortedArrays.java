public class gfg_9_intersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1={3, 5, 10, 10, 10, 15, 15, 20};
        int[] arr2={5,10,10,15,30};
        func(arr1, arr2);
    }

    static void func(int[] arr1, int[] arr2)
    {
        int i=0, j=0, size1=arr1.length, size2=arr2.length;

        while(i<size1 && j<size2)
        {
            if(arr1[i]==arr2[j] && (i<size1-1 && arr1[i]!=arr1[i+1] || j<size2-1 && arr2[j]!=arr2[j+1]))
            {
                System.out.print(arr1[i++]+", ");
                j++;
            }
            else if(arr1[i]==arr2[j] && (arr1[i+1]==arr2[i] && arr2[j+1]==arr2[j]))
            {
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
    }
    public static void naiveMethod(int[] arr1, int[] arr2)
    {
        for(int i=0; i<arr1.length; i++)
        {
            if(i>0 && arr1[i-1]==arr1[i])
            {
                continue;
            }
            for(int j=0; j<arr2.length; j++)
            {
                if(arr1[i]==arr2[j])
                {
                    System.out.print(arr1[i]+", ");
                    break;
                }
            }
        }
    }

    public static void method(int[] arr1, int[] arr2)
    {
        int l=0, h=0;

        while(l<arr1.length && h<arr2.length)
        {
            if(h>0 && arr2[h-1]==arr2[h])
            {
                h++;
                continue;
            }
            if(arr1[l]<arr2[h])
            {
                l++;
            }
            else if(arr2[h]<arr1[l])
            {
                h++;
            }
            else
            {
                System.out.print(arr2[h]+", ");
                l++;
                h++;
            }
        }
    }
}
