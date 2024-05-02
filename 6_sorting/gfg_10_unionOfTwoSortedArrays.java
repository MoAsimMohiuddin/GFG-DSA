public class gfg_10_unionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1={2, 3, 3, 3, 4, 4};
        int[] arr2={4, 4};
        efficientMethod(arr1, arr2);
    }

    public static void efficientMethod(int[] arr1, int[] arr2)
    {
        int l=0, h=0, element=Integer.MIN_VALUE;

        while(l<arr1.length && h<arr2.length)
        {
            if(arr1[l]<=arr2[h])
            {
                if(arr1[l]!=element)
                {
                    System.out.print(arr1[l]+", ");
                    element=arr1[l];
                }
                l++;
            }
            else if(arr2[h]<arr1[l])
            {
                if(arr2[h]!=element)
                {
                    System.out.print(arr2[h]+", ");
                    element=arr2[h];
                }
                h++;
            }
        }

        while(l<arr1.length)
        {
            if(arr1[l]!=element)
            {
                if(l>0 && arr1[l-1]!=arr1[l])
                {
                    System.out.print(arr1[l]+", ");
                }
            }
            l++;
        }

        while(h<arr2.length)
        {
            if(arr2[h]!=element)
            {
                if(h>0 && arr2[h-1]!=arr2[h])
                {
                    System.out.print(arr2[h]+", ");
                }
            }
            h++;
        }

        System.out.println();
    }
}
