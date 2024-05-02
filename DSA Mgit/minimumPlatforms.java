import java.util.Arrays;

public class minimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep= {910, 1200, 1120, 1130, 1900, 2000};

        int result=findPlatform(arr, dep, arr.length);
        System.out.println("Minimum Platforms are "+result);
    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int max=1, i=1, j=0;
        
        while(i<n) {
            System.out.println("arr[i]="+arr[i]+", arr[j]="+arr[j]);
            if(arr[i]>=dep[j]) {
                while(j<i && dep[j]<arr[i]) {
                    j++;
                }
                i++;
                continue;
            }
            else{
                i++;
                if(i-j>max) {
                    max=i-j;
                    System.out.println("Extra Platform Required. Diff="+max);
                }
            }
        }
        return max;
    }
}
