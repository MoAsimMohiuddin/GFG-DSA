// Question: Given an array arr[] of N positive integers, where elements are consecutive (sorted). Also, there is a single element which is repeating X (any variable) number of times. Now, the task is to find the element which is repeated and number of times it is repeated.
// We can solve this problem by using these two steps:
// For finding the number of times the element is repeated, We just have to subtract the size from the difference between the first element and the last element. If the difference is 1, There is no repeating element. Else
// For finding the repeating element, We can skip one half of the Array at every iteration using one condition, If we subtract the sizeOfFirstHalf from the difference between the firstHalfElement and lastHalfElement, And if the difference is zero, That means first half doesn't have any repeating element and we can skip the first half. Similarly we can skip Another half.

public class countOnlyRepeated {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,4,4,4,4};

        Pair result=efficientSolution(arr);
        System.out.println("Repeated = "+result.repeated+", Count = "+result.count);
    }

    public static Pair efficientSolution(int[] arr)
    {
        int size=arr.length, count=0;
        count=size-(arr[size-1]-arr[0]);
        if(count==1)
        {
            return new Pair(-1, -1);
        }

        int low=0, high=size-1;

        while(low<=high)
        {
            int mid=(low+high)/2;
            int diff=mid-(arr[mid]-arr[0]);

            if(diff==0)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return new Pair(arr[low], count);
    }
}

class Pair{
    int repeated;
    int count;

    Pair(int x, int y)
    {
        this.repeated=x;
        this.count=y;
    }
}