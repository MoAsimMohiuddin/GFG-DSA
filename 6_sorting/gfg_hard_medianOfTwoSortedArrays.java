public class gfg_hard_medianOfTwoSortedArrays {
    public static void main(String[] args) {
        
    }

    public static int findMedian(int arr[], int n, int brr[], int m)
    {
        int median=0, count=0, flag=0;
        
        int l=0, h=0;
        
        while(l<n && h<m)
        {
            if(arr[l]<=brr[h])
            {
                System.out.println("arr[l]="+arr[l]+", brr[h]"+brr[h]);
                count++;
                if((m+n)%2==0 && (count>=(m+n)/2) && count<=((m+n)/2)+1)
                {
                    flag=1;
                    median+=arr[l];
                }
                else if( (m+n)%2==1 && count==((m+n)/2)+1)
                {
                    System.out.println("count="+count+", arr[l]="+arr[l]);
                    median=arr[l];
                    break;
                }
                l++;
            }
            else
            {
                count++;
                if( ((m+n)%2==0) && ( (count>=(m+n)/2) && (count<=(m+n)/2+1) ) )
                {
                    flag=1;
                    median+=brr[h];
                }
                else if( (m+n)%2==1 && count==((m+n)/2)+1)
                {
                    System.out.println("count="+count+", arr[h]="+brr[h]);
                    median=brr[h];
                    break;
                }
                h++;
            }
        }
        
        while(l<n)
        {
            count++;
            if((m+n)%2==0 && (count>=(m+n)/2) && count<=((m+n)/2)+1)
            {
                flag=1;
                median+=arr[l];
            }
            else if( (m+n)%2==1 && count==((m+n)/2)+1)
            {
                median=arr[l];
                break;
            }
            l++;
        }
        
        while(h<m)
        {
            count++;
            if( ((m+n)%2==0) && ( (count>=(m+n)/2) && (count<=(m+n)/2+1) ) )
            {
                flag=1;
                median+=brr[h];
            }
            else if( (m+n)%2==1 && count==((m+n)/2)+1)
            {
                median=brr[h];
                break;
            }
            h++;
        }
        
        if(flag==0)
        {
            return median;
        }
        else
        {
            return median/2;
        }
    }
}
