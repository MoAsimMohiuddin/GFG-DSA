import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data=data;
    }
}


public class Pr {
    public static void main(String[] args) {
        int[] arr1={100, 200, 1, 3, 2, 4};
        System.out.println(longestConsecutiveSequenceInArray(arr1));
    }

    static int longestConsecutiveSequenceInArray(int[] arr) {
        HashSet<Integer> hSet=new HashSet<>();

        int res=0;
        for(int k: arr) {
            hSet.add(k);
        }

        for(int k: arr) {
            if(!hSet.contains(k-1)) {
                int count=1, el=k+1;

                while(hSet.contains(el)) {
                    count++;el++;
                }

                res=Math.max(res, count);
            }
        }

        return res;
    }

    static int longestSubArrayWithGivenSum(int[] arr, int target) {
        int n=arr.length, res=0, sum=0;

        HashMap<Integer, Integer> hMap=new HashMap<>();

        for(int i=0; i<n; i++) {
            sum+=arr[i];

            if(sum==target) {
                res=Math.max(res, i+1);
            }

            if(hMap.containsKey(sum-target)) {
                int diff=i-hMap.get(sum-target);

                res=Math.max(res, diff);
            }

            if(!hMap.containsKey(sum)) {
                hMap.put(sum, i);
            }
        }

        return res;
    }

    static ArrayList<Integer> subArrayWithGivenSum(int[] arr, int target) {
        Arrays.sort(arr);

        ArrayList<Integer> result=new ArrayList<Integer>();

        int index=0, n=arr.length, sum=0;

        for(int i=0; i<n; i++) {
            result.add(arr[i]);
            sum+=arr[i];


            if(sum==target) {
                return result;
            }else if(sum>target) {
                while(sum>target) {
                    sum-=arr[index++];
                    result.remove(0);

                    if(sum==target) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    static boolean tripletSum(int[] arr, int target) {
        int n=arr.length;

        for(int i=0; i<n-2; i++) {
            if(helperForTriplet(arr, i, target)) {
                return true;
            }
        }

        return false;
    }

    static boolean helperForTriplet(int[] arr, int i, int target) {
        int low=i+1, high=arr.length-1;

        while(low<high) {
            if(arr[low]+arr[high]+arr[i]==target) {
                return true;
            }else if(arr[low]+arr[high]+arr[i]>target) {
                high--;
            }else {
                low++;
            };
        }

        return false;
    }

    static void intersectionOfArrays(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hMap=new HashMap<>();

        for(int k: arr1) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k)+1);
            }else{
                hMap.put(k, 1);
            }
        }

        for(int k: arr2) {
            if(hMap.containsKey(k)) {
                System.out.print(k+",");

                hMap.put(k, hMap.get(k)-1);

                if(hMap.get(k)==0) {
                    hMap.remove(k);
                }
            }
        }
    }

    static ArrayList<ArrayList<Integer>> permutation(int[] arr) {
        int n=arr.length;

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> currentPermutation=new ArrayList<>();

        for(int i=0; i<n; i++) {
            currentPermutation.add(-1);
        }

        boolean[] used=new boolean[n];

        helperForPermutations(res, currentPermutation, used, arr, 0);

        return res;
    }

    static void helperForPermutations(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> currentPermutation, boolean[] used, int[] arr, int depth) {
        int n=arr.length;

        if(depth==n) {
            res.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!used[i]) {
                used[i]=true;
                currentPermutation.set(depth, arr[i]);
                helperForPermutations(res, currentPermutation, used, arr, depth+1);
                used[i]=false;
            }
        } 
    }

    static ArrayList<ArrayList<Integer>> powerSet(int[] arr) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        Arrays.sort(arr);

        helperFunction(arr, res, new ArrayList<>(), 0);

        return res;
    }

    static void helperFunction(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int index) {
        res.add(new ArrayList<>(subset));

        for(int i=index; i<arr.length; i++) {
            subset.add(arr[i]);
            helperFunction(arr, res, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }

    static ArrayList<ArrayList<Integer>> printAllContigousSubArrays(int[] arr) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> subArray=new ArrayList<>();

        int n=arr.length;

        for(int i=0; i<n; i++) {
            subArray.clear();
            for(int j=i; j<n;j++) {
                subArray.add(arr[j]);
                System.out.println("SubArray="+subArray);
                res.add(new ArrayList<>(subArray));
            }
        }

        return res;
    }

    static int chocolateDistribution(int[] chocolates, int students) {
        Arrays.sort(chocolates);

        int result=Integer.MAX_VALUE;

        int n=chocolates.length;
        for(int i=n-students+1; i<n; i++) {
            System.out.println("el1="+chocolates[i-students+1]+", el2="+chocolates[i]);
            int diff=chocolates[i]-chocolates[i-students+1];

            result=Math.min(diff, result);
        }

        return result;
    }

    static boolean arraySubsetOfAnother(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hMap=new HashMap<>();

        for(int k: arr2) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k)+1);
            }else{
                hMap.put(k, 1);
            }
        }

        for(int k: arr1) {
            if(hMap.containsKey(k)) {
                hMap.put(k, hMap.get(k)-1);

                if(hMap.get(k)==0) {
                    hMap.remove(k);
                }
            }
        }

        if(hMap.size()==0) return true;
        else return false;
    }

    static int stockBestDay(int[] arr) {
        int size=arr.length;

        int res=0, least=arr[0];

        for(int i=1; i<size; i++) {
            if(arr[i]>least) {
                res=Math.max(res, arr[i]-least);
            }else{
                least=arr[i];
            }
        }

        return res;
    }

    public static String findMostFollowersUser(List<String> posts) {
        Map<String, Integer> followersCount = new HashMap<>();
        Map<String, Long> latestTimestamp = new HashMap<>();

        // Process each post to count followers and track latest timestamps
        for (String post : posts) {
            String[] parts = post.split("\\|\\|");
            System.out.println("Parts");
            for(String str: parts) {
                System.out.print(str+", ");
            }
            System.out.println();
            if (parts.length >= 5) {
                String poster = parts[0];
                String follower = parts[3];
                long timestamp = Long.parseLong(parts[2]);

                followersCount.put(poster, followersCount.getOrDefault(poster, 0) + 1);
                followersCount.put(follower, followersCount.getOrDefault(follower, 0));

                // Update latest timestamp for both poster and follower
                latestTimestamp.put(poster, Math.max(latestTimestamp.getOrDefault(poster, 0L), timestamp));
                latestTimestamp.put(follower, Math.max(latestTimestamp.getOrDefault(follower, 0L), timestamp));
            }
        }

        // Find the user with the most followers and the latest timestamp in case of ties
        int maxFollowers = 0;
        long latestTimestampForMaxFollowers = 0L;
        String mostFollowersUser = "";

        System.out.println("HashMap");
        System.out.println(followersCount);
        for (Map.Entry<String, Integer> entry : followersCount.entrySet()) {
            String user = entry.getKey();
            int currentFollowers = entry.getValue();
            long currentTimestamp = latestTimestamp.get(user);

            if (currentFollowers > maxFollowers ||
                (currentFollowers == maxFollowers && currentTimestamp > latestTimestampForMaxFollowers)) {
                maxFollowers = currentFollowers;
                latestTimestampForMaxFollowers = currentTimestamp;
                mostFollowersUser = user;
            }
        }

        return mostFollowersUser;
}
    static Node reverseLL(Node head) {
        Node prev=null, nextNode=null, current=head;
        while(current!=null) {
            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }

        return prev;
    }
    static void unCommonElements(int[] arr, int[] brr) {
        HashSet<Integer> set=new HashSet<Integer>();

        for(int k: arr) {
            set.add(k);
        }

        for(int k: brr) {
            if(set.contains(k)) set.remove(k);
            else set.add(k);
        }

        Iterator<Integer> iter=set.iterator();

        while(iter.hasNext()) {
            System.out.print(iter.next()+", ");
        }
    }
    static void quickSort(int[] arr, int low, int high) {
        if(low>=high) return;
        else{
            int pivot=lamutoPartition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    static int lamutoPartition(int[] arr, int low, int high) {
        int pivot=arr[high], index=low;

        for(int i=low; i<high; i++) {
            if(arr[i]<pivot) {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
        }

        int temp=arr[index];
        arr[index]=pivot;
        arr[high]=temp;

        return index;
    }
    static void mergeSort(int[] arr, int low, int high) {
        if(low>=high) {
            return;
        }else{
            int mid=(low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, high);
        }
    }
    static void merge(int[] arr, int low, int high) {
        int[] brr=new int[high-low+1];
        int index=0, mid=(low+high)/2, i=low, j=mid+1;
        
        while(i<=mid && j<=high) {
            if(arr[j]<arr[i]) {
                brr[index++]=arr[j++];
            }else{
                brr[index++]=arr[i++];
            }
        }

        while(i<=mid) {
            brr[index++]=arr[i++];
        }

        while(j<=high) {
            brr[index++]=arr[j++];
        }

        index=0;
        for(int k=low; k<=high; k++) {
            arr[k]=brr[index++];
        }
    }
    static void insertionSort(int[] arr, int n) {
        for(int i=1; i<n; i++) {
            int j=i-1, key=arr[i];

            while(j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=key;
        }
    }
    static void selectionSort(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            int min=arr[i], in=i;
            for(int j=i+1; j<n; j++) {
                if(arr[j]<min) {
                    min=arr[j];
                    in=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[in]=temp;
        }
    }
    static void bubbleSort(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(arr[j]<arr[j-1]) {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
    static int longestSubstringWithoutRepetetion(String s) {
        HashSet<Character> set=new HashSet<>();

        int len=s.length(), max=0, count=0, start=0;

        for(int i=0; i<len; i++) {
            if(set.add(s.charAt(i))) {
                count++;
                max=Math.max(max, count);
                System.out.println(s.charAt(i)+" added, count="+count);
            }else{
                while(s.charAt(start)!=s.charAt(i)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                count=i-start+1;

                set.add(s.charAt(i));
            }
        }

        return max;
    }
    static Node intersectionOfTwoSortedLLs(Node h1, Node h2) {
        HashMap<Integer, Integer> map=new HashMap<>();

        Node resHead=new Node(-1);
        Node r1=resHead;

        Node p1=h1;
        while(p1!=null) {
            map.put(p1.data, map.getOrDefault(p1.data, 0)+1);
            p1=p1.next;
        }

        Node p2=h2;
        while(p2!=null) {
            if(map.containsKey(p2.data)) {
                if(resHead.data==-1) resHead.data=p2.data;
                else{
                    Node newNode=new Node(p2.data);
                    r1.next=newNode;
                    r1=r1.next;
                }

                map.put(p2.data, map.get(p2.data)-1);
                if(map.get(p2.data)==0) map.remove(p2.data);
            }
            p2=p2.next;
        }

        return resHead;
    }

    static ArrayList<Integer> mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        ArrayList<Integer> result=new ArrayList<>();

        int p1=0, p2=0, len1=arr1.length, len2=arr2.length;

        while(p1<len1 && p2<len2) {
            if(arr1[p1]<arr2[p2]) {
                result.add(arr1[p1]);
                p1++;
            }else if(arr2[p2]<arr1[p1]) {
                result.add(arr2[p2]);
                p2++;
            }else{
                result.add(arr1[p1]);
                p1++;
            }
        }

        while(p1<len1) {
            result.add(arr1[p1]);
            p1++;
        }

        while(p2<len2) {
            result.add(arr2[p2]);
            p2++;
        }

        return result;
    }
    static ArrayList<Integer> union(int[] arr1, int[] arr2) {
        ArrayList<Integer> result=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        for(int k:arr1) set.add(k);

        for(int k:arr2) set.add(k);

        Iterator<Integer> iter=set.iterator();

        while(iter.hasNext()) {
            result.add(iter.next());
        }

        return result;
    }

    static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hMap=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int k: arr1) {
            hMap.put(k, hMap.getOrDefault(k, 0)+1);
        }

        for(int k: arr2) {
            if(hMap.containsKey(k)) {
                result.add(k);

                hMap.put(k, hMap.get(k)-1);
                if(hMap.get(k)==0) hMap.remove(k);
            }
        }

        return result;
    }
    static String reverseWords(String S)
    {
        // code here
        String res="", rev="";
        int len=S.length();
        
        for(int i=len-1; i>=0; i--) {
            // System.out.println("i="+S.charAt(i));
            if(S.charAt(i)=='.') {
                System.out.println(res);
                res=res+'.';
                rev+=res;
                res="";
                continue;
            }
            res=S.charAt(i)+res;
        }
        
        return rev.substring(0, rev.length())+res;
    }
    static int maj(int[] arr) {
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        int len=arr.length;

        for(int i=0; i<len; i++) {
            if(hMap.containsKey(arr[i])) {
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }else{
                hMap.put(arr[i], 1);
            }
        }

        for(int k:arr) {
            if(hMap.get(k)>len/2) {return k;}
        }

        return -1;
    }
    static void leadersss(int[] arr){
        int len=arr.length, leader=arr[len-1], temp=len-2;

        for(int i=len-2; i>=0; i--) {
            if(arr[i]>leader) {
                leader=arr[i];
                arr[temp]=leader;
                temp--;
            }
        }

        System.out.println("Leaders are");
        for(int i=temp+1; i<len; i++) {
            System.out.print(arr[i]+", ");
        }
    }
    static void sortArrayOfZerosAndOnes(int[] arr) {
        int counter=0, n=arr.length;

        for(int i=counter; i<n; i++) {
            if(arr[i]==0) {
                int temp=arr[i];
                arr[i]=arr[counter];
                arr[counter]=temp;
                counter++;
            }
        }

        for(int i=counter; i<n; i++) {
            if(arr[i]==1) {
                int temp=arr[i];
                arr[i]=arr[counter];
                arr[counter]=temp;
                counter++;
            }
        }
    }
    public static boolean isRotated(String str1, String str2)
    {
        if(str1.equals(str2)) {
            return false;
        }
        
        int len=str1.length();
        
        for(int i=1; i<len; i++) {
            if(str2.charAt(i)==str1.charAt(0) && str2.charAt(i-1)==str1.charAt(len-1) && (len-i==2 || i==2)) {
                String temp="";
                for(int j=i; j<len; j++) temp+=str2.charAt(j);
                for(int j=0; j<i; j++) temp+=str2.charAt(j);
                System.out.println(temp);
                if(temp.equals(str1)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    static int largestElement(int[] arr) {
        int res=Integer.MIN_VALUE;

        for(int k: arr) {
            if(k>res) {
                res=k;
            }
        }

        return res;
    }

    static int secondLargestElement(int[] arr) {
        int sec=arr[0], lar=arr[0];

        for(int k: arr) {
            if(k>lar) {
                sec=lar;
                lar=k;
            }
        }
        return sec;
    }

    static int maxJI(int[] arr) {
        int res=0, n=arr.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i]<=arr[j]) {
                    res=Math.max(res, j-i);
                }
            }
        }

        return res;
    }

    static boolean checkSorted(int[] arr) {
        boolean desc=true, asc=true;
        int n=arr.length;

        for(int i=0; i<n-1; i++) {
            if(arr[i]>arr[i+1]) {
                asc=false;
            }

            if(arr[i]<arr[i+1]) {
                desc=false;
            }
        }

        System.out.println("ASC="+asc);
        System.out.println("DESC="+desc);

        if(!desc && !asc) {
            return false;
        }else{
            return true;
        }
    }

    static void reverseArray(int[] arr) {
        int n=arr.length, low=0, high=n-1;

        while(low<high) {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }

    static void removeDupsFromSorted(int[] arr) {
        int i=0, j=1, n=arr.length;

        while(j<n) {
            System.out.println("i="+i+", j="+j);
            System.out.println("arr[i]="+arr[i]+", arr[j]="+arr[j]);

            if(arr[i]==arr[j]) {
                j++;
            }else{
                System.out.println("So Swapped");
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }

        System.out.println(j);
    }

    static void moveZerosToEnd(int[] arr) {
        int n=arr.length, i=0, j=n-1;

        while(i<j) {
            while(arr[i]!=0) {
                i++;
            }

            while(arr[j]==0) {
                j--;
            }

            if(i>=j) {
                break;
            }

            System.out.println("arr[i]="+arr[i]+", arr[j]="+arr[j]);

            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    static void leaders(int[] arr) {
        int n=arr.length, leader=arr[n-1], index=n-2;

        for(int i=n-2; i>=0; i--) {
            if(arr[i]>leader) {
                leader=arr[i];
                
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                index--;
            }
        }

        for(int i=index+1; i<n; i++) {
            System.out.print(arr[i]+", ");
        }
    }

    static void frequenciesInSortedArray(int[] arr) {
        int count=1, n=arr.length;

        for(int i=1; i<n; i++) {
            if(arr[i]!=arr[i-1]) {
                System.out.println(arr[i-1]+"="+count);
                count=1;
            }else{
                count++;
            }
        }

        System.out.println(arr[n-1]+"="+count);
    }

    static int trappingRainWater(int[] arr) {
        int waters=0, n=arr.length;

        for(int i=1; i<n-1; i++) {
            int leftMax=findLeftMax(arr, i);
            int rightMax=findRightMax(arr, i);

            int secMax=Math.min(leftMax, rightMax);

            int water=secMax-arr[i];

            if(water>0) {
                waters+=water;
            }
        }

        return waters;
    }

    static int findLeftMax(int[] arr, int index) {
        int max=arr[index-1];

        for(int i=index-1; i>=0; i--) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }

        return max;
    }

    static int findRightMax(int[] arr, int index) {
        int max=arr[index+1], n=arr.length;

        for(int i=index+1; i<n; i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }

        return max;
    }

    static void printArray(int[] arr) {
        for(int k: arr) {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}
