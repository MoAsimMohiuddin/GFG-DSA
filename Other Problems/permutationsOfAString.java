public class permutationsOfAString {
    public static void main(String[] args) {
        permute("abc", 0, 2);
    }

    static void permute(String str, int l, int r)
    {
        if(l==r)
        {
            System.out.println(str);
        }
        else
        {
            for(int i=l; i<=r; i++)
            {
                str=swap(str, l, i);
                permute(str, l+1, r);
                str=swap(str, l, i);
                
            }
        }
    }

    static String swap(String str, int l, int r)
    {
        char temp;
        char[] arr=str.toCharArray();

        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;

        return String.valueOf(arr);
    }
}
