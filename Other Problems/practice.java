import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

// import Arrays.*;
public class practice {
    public static void main(String[] args)
    {
        int[] arr={5,6,2,8,3,5,1,7};

        int[] result=missingAndRepeating(arr);
        for(int k:result)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static int[] missingAndRepeating(int[] arr)
    {
        int[] result=new int[2];
        int n=arr.length;

        System.out.println("Array is");
        printArrayy(arr);

        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i]+", "+arr[arr[i]-1]+" swapped");

            int temp=arr[i];
            arr[i]=arr[arr[i]-1];
            arr[temp-1]=temp;

            printArrayy(arr);
        }
        
        for(int i=0; i<n; i++)
        {
            if(Math.abs(arr[i])!=i+1)
            {
                result[0]=i+1;
            }
            
            if(i>0 && arr[i]==arr[i-1])
            {
                result[1]=arr[i];
            }
        }
        printArrayy(arr);
        return result;
    }

    static void printArrayy(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
    static ArrayList<ArrayList<Integer>> uniqueRow(int[][] a, int m, int n)
    {
        HashSet<Integer> hSet=new HashSet<Integer>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int num=findNum(a[i]);
                if(!hSet.contains(num))
                {
                    hSet.add(num);
                    ArrayList<Integer> arr=new ArrayList<Integer>();
                    for(int k:a[i])
                    {
                        arr.add(k);
                    }

                    result.add(arr);
                }
            }
        }

        return result;
    }

    static int findNum(int[] arr)
    {
        String str="";
        int size=arr.length;

        for(int i=0; i<size; i++)
        {
            str+=arr[i];
        }

        return Integer.parseInt(str);
    }
    void methoddd(int a)
    {
        System.out.println("Hello");
    }
    static int longestSubArrayWithGivenSum(int[] arr, int target)
    {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();

        int pSum=0, size=arr.length, length=0, maxLength=0;

        for(int i=0; i<size; i++)
        {
            pSum+=arr[i];

            if(pSum==target)
            {
                if(i+1>maxLength)
                {
                    maxLength=i+1;
                }
            }

            if(hMap.containsKey(pSum-target))
            {
                length=i-hMap.get(pSum-target);

                if(length>maxLength)
                {
                    maxLength=length;
                }
                continue;
            }

            hMap.put(pSum, i);
        }

        return maxLength;
    }

    static int longestSubArrayWithZeroSum(int[] arr)
    {
        HashMap<Integer, Integer> hmap=new HashMap<Integer, Integer>();

        int pSum=0, size=arr.length, length=0, maxLength=0;

        for(int i=0; i<size; i++)
        {
            pSum+=arr[i];
            if(pSum==0)
            {
                if(i+1>maxLength)
                {
                    maxLength=i+1;
                }
            }
            
            if(hmap.containsKey(pSum))
            {
                length=i-hmap.get(pSum);
                if(length>maxLength)
                {
                    maxLength=length;
                }

                continue;
            }

            hmap.put(pSum, i);
        }

        return maxLength;
    }

    static int[][] mergeOverLappingIntervals(int[][] Intervals)
    {
        // Code here // Code here

        Arrays.sort(Intervals, new java.util.Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });

        int res=0, size=Intervals.length;
        
        for(int i=1; i<size; i++)
        {
            if(Intervals[i][0]<=Intervals[res][1])
            {
                Intervals[res][0]=Math.min(Intervals[res][0], Intervals[i][0]);
                Intervals[res][1]=Math.max(Intervals[res][1], Intervals[i][1]);
            }
            else
            {
                res++;
                Intervals[res]=Intervals[i];
            }
        }
        // System.out.println("res="+res);
        // System.out.println("Array is");
        // for(int i=0; i<Intervals.length; i++)
        // {
        //     for(int j=0; j<2; j++)
        //     {
        //         System.out.println(Intervals[i][j]);
        //     }
        // }
        int[][] result=new int[res+1][2];
        for(int i=0; i<=res; i++)
        {
            for(int j=0; j<2; j++)
            {
                result[i][j]=Intervals[i][j];
            }
        }
        
        return result;
    }
    
    static int[][] rotateMatrix(int[][] mat, int n, int m)
    {
        int[][] newMatrix=new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                newMatrix[i][j]=mat[m-j-1][i];
            }
        }

        return newMatrix;
    }

    static int stockBuyAndSellSingleDay(int[] arr)
    {
        int profit=0, maxProfit=0, minElement=arr[0], size=arr.length;

        for(int i=1; i<size; i++)
        {
            if(arr[i]<minElement)
            {
                minElement=arr[i];
            }
            else
            {
                profit=arr[i]-minElement;
                if(profit>maxProfit)
                {
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }
    static void sortArrayOf012(int[] arr)
    {
        int temp=0, i;

        for(i=0; i<arr.length; i++)
        {
            if(arr[i]==0)
            {
                int swapper=arr[temp];
                arr[temp]=arr[i];
                arr[i]=swapper;
                temp++;;
            }
        }

        for(i=temp; i<arr.length; i++)
        {
            if(arr[i]==1)
            {
                int swapper=arr[i];
                arr[i]=arr[temp];
                arr[temp]=swapper;
                temp++;
            }
        }
    }
    static int kadanesAlgorithm(int[] arr)
    {
        int sum=0, size=arr.length, maxSum=0;

        ArrayList<Integer> subArray=new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();

        for(int i=0; i<size; i++)
        {
            if(sum+arr[i]>arr[i])
            {
                subArray.add(arr[i]);
                sum+=arr[i];
            }
            else
            {
                subArray.clear();
                sum=arr[i];
                subArray.add(arr[i]);
            }
            if(sum>maxSum)
            {
                maxSum=sum;
                result=subArray;
                result=new ArrayList<Integer>(subArray);
            }
            System.out.println("sum="+sum);
        }
        System.out.println(result);
        
        return maxSum;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int currSum=arr[0], low=0, high=0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        while(low<n && high<n)
        {
            System.out.println("low="+low);
            System.out.println("high="+high);
            if(currSum<s)
            {
                currSum=currSum+arr[++high];
            }
            else if(currSum>s)
            {
                currSum-=arr[low++];
            }
            else
            {
                result.add(low+1);
                result.add(high+1);
                return result;
            }
        }
        
        result.add(-1);
        return result;
    }

//     static class Pair{
//         long x;
//         long y;
        
//         Pair(long x, long y){
//             this.x = x;
//             this.y = y;
//         }
//     }
//    //Function to find repeated element and its frequency.
//    public static Pair findRepeating(Long arr[],int n)
//    {
//        //Your code here
//        int low=0, high=arr.length-1;
//        int mid=(low+high)/2, count=0;
       
//        while(low<high)
//        {
//            mid=(low+high)/2;
           
//            if(mid==0 && arr[mid]==arr[mid+1])
//            {
//                count+=leftArrayCheck(arr, mid);
//                Pair result=new Pair(arr[mid], count);
//                return result;
//            }
//            else if(mid==n-1 && arr[mid]==arr[mid-1])
//            {
//                count+=rightArrayCheck(arr, mid);
//                Pair result=new Pair(arr[mid], count);
//                return result;
//            }
//            else if(arr[mid]==arr[mid-1] || arr[mid]==arr[mid+1])
//            {
//                count+=leftArrayCheck(arr, mid);
//                count+=rightArrayCheck(arr, mid)-1;
//                Pair result=new Pair(arr[mid], count);
//                return result;
//            }
           
//            if(mid-low!=arr[mid]-arr[low])
//            {
//                high=mid-1;
//            }
//            else if(high-mid!=arr[high]-arr[mid])
//            {
//                low=mid+1;
//            }
//            else
//            {
//             break;
//            }
//        }
       
//        return new Pair(-1, -1);
//    }
   
//    public static int leftArrayCheck(Long[] arr, int index)
//    {
//        int count=0, i=index;
       
//        while(arr[i]==arr[index])
//        {
//            count++;
//            i--;
//            if(i<0)
//            {
//             break;
//            }
//        }
       
//        return count;
//    }
   
//    public static int rightArrayCheck(Long[] arr, int index)
//    {
//        int count=0, i=index, len=arr.length;
       
//        while(arr[i]==arr[index])
//        {
//            count++;
//            i++;
//            if(i>=len)
//            {
//             break;
//            }
//        }
       
//        return count;
//    }
    // public static int findMedian(int arr[], int n, int brr[], int m)
    // {
    //     //Your code here
    //     int count=0, index1=0, index2=0, median=0;
        
    //     while(index1<arr.length && index2<brr.length)
    //     {
    //         if(arr[index1]<brr[index2])
    //         {
    //             System.out.println("arr1 At index "+index1);
    //             count++;
    //             if((arr.length+brr.length)%2==1)
    //             {
    //                 if(count==(arr.length+brr.length)/2)
    //                 {
    //                     median=arr[index1];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             else if((arr.length+brr.length)%2==0)
    //             {
    //                 if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length+1)/2)
    //                 {
    //                     median+=arr[index1];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             index1++;
    //         }
    //         else
    //         {
    //             System.out.println("arr2 At index "+index2);
    //             count++;
    //             if((brr.length+arr.length)%2==1)
    //             {
    //                 if(count==(arr.length+brr.length)/2)
    //                 {
    //                     median=brr[index2];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             else if((arr.length+brr.length)%2==0)
    //             {
    //                 if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length-1)/2)
    //                 {
    //                     System.out.println("Entered");
    //                     median=median+brr[index2];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             index2++;
    //         }

    //     }
        
    //     if(index1>=arr.length)
    //     {
    //         while(index1<arr.length)
    //         {
    //             System.out.println("arr1 At index "+index1);
    //             count++;
    //             if((brr.length+arr.length)%2==1)
    //             {
    //                 if(count==(brr.length+arr.length)/2)
    //                 {
    //                     median=arr[index1];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //            else if((arr.length+brr.length)%2==0)
    //             {
    //                 if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length+1)/2)
    //                 {
    //                     median+=arr[index1];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             index1++;
    //         }
    //     }
        
    //     if(index2>=brr.length)
    //     {
    //         while(index2<brr.length)
    //         {
    //             System.out.println("arr2 At index "+index2);
    //             if((brr.length+arr.length)%2==1)
    //             {
    //                 if(count==(arr.length+brr.length)/2)
    //                 {
    //                     median=brr[index2];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //            else if((arr.length+brr.length)%2==0)
    //             {
    //                 if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length+1)/2)
    //                 {
    //                     median+=brr[index2];
    //                     System.out.println("index="+count+", median="+median);
    //                 }
    //             }
    //             index2++;
    //         }
    //     }
        
    //     if((arr.length+brr.length)%2==1)
    //     {
    //         return median;
    //     }
    //     else
    //     {
    //         return median/2+1;
    //     }
    // }

    public static int findMedian(int arr[], int n, int brr[], int m)
    {
        //Your code here
        int count=0, index1=0, index2=0, median=0;
        
        while(index1<arr.length && index2<brr.length)
        {
            if(arr[index1]<brr[index2])
            {
                count++;
                if((arr.length+brr.length)%2==1)
                {
                    if(count==(arr.length+brr.length)/2)
                    {
                        median=arr[index1];
                    }
                }
                else if((arr.length+brr.length)%2==0)
                {
                    if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length)/2+1)
                    {
                        median+=arr[index1];
                    }
                }
                index1++;
            }
            else
            {
                count++;
                if((brr.length+arr.length)%2==1)
                {
                    if(count==(arr.length+brr.length)/2)
                    {
                        median=brr[index2];
                    }
                }
               else if((arr.length+brr.length)%2==0)
                {
                    if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length)/2+1)
                    {
                        median+=brr[index2];
                    }
                }
                index2++;
            }

        }
        
        if(index1>=arr.length)
        {
            while(index1<arr.length)
            {
                count++;
                if((brr.length+arr.length)%2==1)
                {
                    if(count==(brr.length+arr.length)/2)
                    {
                        median=arr[index1];
                    }
                }
               else if((arr.length+brr.length)%2==0)
                {
                    if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length)/2+1)
                    {
                        median+=arr[index1];
                    }
                }
                index1++;
            }
        }
        
        if(index2>=brr.length)
        {
            while(index2<brr.length)
            {
                count++;
                if((brr.length+arr.length)%2==1)
                {
                    if(count==(arr.length+brr.length)/2)
                    {
                        median=brr[index2];
                    }
                }
               else if((arr.length+brr.length)%2==0)
                {
                    if(count==(arr.length+brr.length)/2 || count==(arr.length+brr.length)/2+1)
                    {
                        median+=brr[index2];
                    }
                }
                index2++;
            }
        }
        
        if((arr.length+brr.length)%2==1)
        {
            return median;
        }
        else
        {
            return (median/2);
        }
    }
}
