import java.util.ArrayList;

public class Pr{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5, 6};
        waveArray(arr);
        printArray(arr);
    }
    static int digitalRoot(int n) {
        if(n/10==0) {
            return n;
        }
        return digitalRoot(countSum(n));
    }
    static int countSum(int n) {
        int sum=0;
        while(n!=0) {
            sum+=n%10;
            n/=10;
        }

        return sum;
    }

    static ArrayList<String> powerSetUsingRecursion(String str) {
        ArrayList<String> result=new ArrayList<>();
        helperFunctionForPowerSet(result, str, " ", 0);

        return result;
    }
    static void helperFunctionForPowerSet(ArrayList<String> result, String str, String curr, int index) {
        if(index==str.length()){
            result.add(curr);
            return;
        }
        else{
            helperFunctionForPowerSet(result, str, curr, index+1);
            helperFunctionForPowerSet(result, str, curr+str.charAt(index), index+1);
        }
    }
    static int countTotalDigits(int n) {
        if(n==0) {
            return 0;
        }else{
            return 1+countTotalDigits(n/10);
        }
    }
    static int sumOfDigitsOfTheNumber(int n) {
        if(n==0) return 0;
        else{
            return n%10+sumOfDigitsOfTheNumber(n/10);
        }
    }
    static void print1ToNWithoutLoop(int n) {
        if(n==1) {
            System.out.print(n+", ");
            return;
        }else{
            print1ToNWithoutLoop(n-1);
            System.out.print(n+", ");
        }
    }

    static int powerUsingRecursion(int n, int p) {
        return helperFunctionForRecursion(n, p, 0);
    }

    static int helperFunctionForRecursion(int n, int p, int count) {
        if(count==p) return 1;
        else return n*helperFunctionForRecursion(n, p, count+1);
    }
    static int largestElement(int[] arr) {
        int largest=Integer.MIN_VALUE;

        for(int k: arr) {
            if(k>largest) {
                largest=k;
            }
        }

        return largest;
    }

    static void leaders(int[] arr) {
        int len=arr.length, leader=arr[len-1];
        System.out.print(leader+", ");

        for(int i=len-1; i>=0; i--) {
            if(arr[i]>leader) {
                leader=arr[i];
                System.out.print(leader+", ");
            }
        }
    }

    static int equilibriumPoint(int[] arr) {
        int lSum=arr[0], rSum=0, n=arr.length;

        for(int i=1; i<n; i++) rSum+=arr[i];

        for(int i=1; i<n; i++) {
            rSum-=arr[i];
            if(lSum==rSum) return i+1;
            System.out.println("lSum="+lSum+", rSum="+rSum);
            lSum+=arr[i];
        }

        return -1;
    }

    static void waveArray(int[] arr) {
        int n=arr.length;

        for(int i=0; i<n-1; i+=2) {
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }

    static void printArray(int[] arr) {
        for(int k:arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}