public class Pr{
    public static void main(String[] args) {
        int []arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(kadanesAlgorithm(arr));
    }
    
    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    static int maxProfit(int[] arr) {
        int result=0, size=arr.length, min=arr[0];

        for(int i=1; i<size-1; i++) {
            if(arr[i]<min) {
                min=arr[i];
                continue;
            }else{
                if(arr[i]-min>result) {
                    result=arr[i]-min;
                }
            }
        }
        return result;
    }

    static void sortArrayOf0s1s2s(int[] arr) {
        int temp=0, size=arr.length;

        for(int i=0; i<size; i++) {
            if(arr[i]==0) {
                int t=arr[i];
                arr[i]=arr[temp];
                arr[temp]=t;
                temp++;
            }
        }

        for(int i=temp;i<size; i++) {
            if(arr[i]==1) {
                int t=arr[i];
                arr[i]=arr[temp];
                arr[temp]=t;
                temp++;
            }
        }
        
        for(int i=temp;i<size; i++) {
            if(arr[i]==2) {
                int t=arr[i];
                arr[i]=arr[temp];
                arr[temp]=t;
                temp++;
            }
        }
    }

    static int kadanesAlgorithm(int[] arr) {
        int max=0, sum=0, size=arr.length;

        for(int i=0; i<size; i++) {
            if(arr[i]+sum>arr[i]) {
                sum+=arr[i];
            }else{
                sum=arr[i];
            }

            if(sum>max) {
                max=sum;
            }
        }

        return max;
    }
}