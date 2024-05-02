import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        int[] arr1={2, 2, 3, 4, 5};
        int[] arr2={1,1,2,3,4};
        ArrayList<Integer> result=findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println(result);
    }
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        int i=0, j=0, index=0;
        if(arr1[i]<arr2[j])
        {
            System.out.println(arr1[i]+" added");
            result.add(arr1[i++]);
            index++;
        }
        else if(arr2[j]<arr1[i])
        {
            System.out.println(arr2[j]+" added");
            result.add(arr2[j++]);
            index++;
        }
        else
        {
            result.add(arr1[i]);
            i++;
            j++;
            index++;
        }

        while(i<n && j<m)
        {
            System.out.println("Entered");
            if(arr1[i]<arr2[j])
            {
                if(result.get(index-1)!=arr1[i])
                {
                    System.out.println(arr1[i]+" added");
                    result.add(arr1[i++]);
                    index++;
                }
                else
                {
                    i++;
                }
            }
            else if(arr2[j]<arr1[i])
            {
                if(result.get(index-1)!=arr2[j])
                {
                    System.out.println(arr2[j]+" added");
                    result.add(arr2[j++]);
                    index++;
                }
                else
                {
                    j++;
                }
            }
            else if(arr1[i]==arr2[j])
            {
                if(result.get(index-1)!=arr1[i])
                {
                    System.out.println(arr1[i]+" added");
                    result.add(arr1[i]);
                    i++;
                    j++;
                    index++;
                }
                else
                {
                    i++;
                    j++;
                }
            }
        }
        
        while(i<n)
        {
            if(result.get(index-1)!=arr1[i])
            {
                System.out.println(arr1[i]+" added");
                result.add(arr1[i++]);
                index++;
            }
            else
            {
                i++;
            }
        }
        
        while(j<m)
        {
            if(result.get(index-1)!=arr2[j])
            {
                System.out.println(arr2[j]+" added");
                result.add(arr2[j++]);
                index++;
            }
            else
            {
                j++;
            }
        }
        
        return result;
    }
    public static int recurFunc(int n)
    {
        if(n==1)
        {
            return 0;
        }

        int count=0;
        while(n!=1)
        {
            if(n%2==0)
            {
                count++;
                n/=2;
            }
            else
            {
                int num1=(n+1)/2, num2=(n-1)/2;
                if(num1%2==0)
                {
                    n=num1;
                }
                else{
                    n=num2;
                }
                count++;
            }
        }

        return count;
    }
    public static int toggle(int n, int[] arr) {
        // code here
        // GFG JANUARY 4th CONTEST 1ST QUESTION.
        for(int i=0; i<n; i++)
        {
            if(arr[i]==0)
            {
                break;
            }
            if(i==n-1)
            {
                return arr.length;
            }
        }
        int oneIndex=0, length=0, maxLength=0;
        
        for(int i=0; i<n; i++)
        {
            length=0;
            if(arr[i]==0)
            {
                while(i<n && arr[i]==0)
                {
                    arr[i]=1;
                    i++;
                }
                
                while(oneIndex<n && arr[oneIndex]==1)
                {
                    length++;
                    oneIndex++;
                }
                if(length>maxLength)
                {
                    maxLength=length;
                }
                oneIndex=i;
            }
        }
        
        return maxLength;
    }

    public static boolean function(String pattern, String s)
    {
        ArrayList<String> listOfPattern=new ArrayList<String>();
        ArrayList<String> listOfWords=new ArrayList<String>();

        HashMap<String, String> hMap=new HashMap<String, String>();

        String str="";
        for(int i=0; i<s.length(); i++)
        {
            if(String.valueOf(s.charAt(i)).equals(" "))
            {
                listOfWords.add(str);
                str="";
                continue;
            }
            str+=s.charAt(i);
        }
        listOfWords.add(str);
        for(int i=0; i<pattern.length(); i++)
        {
            listOfPattern.add(String.valueOf(pattern.charAt(i)));
        }
        
        if(listOfPattern.size()!=listOfWords.size())
        {
            System.out.println("Length not equal");
            return false;
        }
        
        System.out.println(listOfPattern);
        System.out.println(listOfWords);

        int index=0;
        for(int i=0; i<listOfPattern.size(); i++)
        {
            if(!hMap.containsKey(listOfPattern.get(i)))
            {
                hMap.put(listOfPattern.get(i), listOfWords.get(index++));
                // System.out.println("key="+listOfPattern.get(i)+", value="+listOfWords.get(index-1));
            }
            else if(hMap.containsKey(listOfPattern.get(i)))
            {
                if(listOfWords.get(index++).equals(hMap.get(listOfPattern.get(i)))==false)
                {
                    // System.out.println(listOfWords.get(index-1)+"!="+listOfPattern.get(i));
                    return false;
                }
            }
        }

        return true;
    }
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> hMap=new HashMap<Integer, Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++)
        {
            if(hMap.containsKey(arr[i]))
            {
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }
            else
            {
                hMap.put(arr[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> el:hMap.entrySet())
        {
            if(el.getValue()==1)
            {
                result.add(el.getKey());
            }
        }
        
        return result;
    }
    public static int[] linearProbing(int hash_size, int arr[], int sizeOfArray)
    {
        //Your code here
        int[] result=new int[hash_size];
        Arrays.fill(result, -1);
        for(int i=0; i<arr.length; i++)
        {
            int index=arr[i]%hash_size;
            if(result[index]==-1)
            {
                result[index]=arr[i];
            }
            else
            {
                if(index==result.length-1)
                {
                    index=0;
                }
                else
                {
                    index++;
                }
                while(result[index]!=-1)
                {
                    index++;
                    if(index==result.length-1)
                    {
                        index=0;
                    }
                }
                result[index]=arr[i];
            }
        }
        return result;
    }    

    public static List<String> findRepeatedDnaSequences(String s)
    {
        if(s.length()<10)
        {
            return new ArrayList<String>();
        }
        if(s.length()==11)
        {
            List<String> result=new ArrayList<String>();
            String sub=s.substring(0, 10);
            String sub1=s.substring(1, 11);
            if(sub.equals(sub1))
            {
                System.out.println(sub);
                result.add(sub);
            }
            return result;
        }
        String sub=s.substring(0, 10);
        HashSet<String> hSet=new HashSet<String>();
        hSet.add(sub);
        List<String> result=new ArrayList<String>();
        for(int i=1; i<=s.length()-10; i++)
        {
            System.out.println(sub);
            sub=sub.substring(1)+s.charAt(i+9);
            if(!hSet.add(sub))
            {
                result.add(sub);
                hSet.remove(sub);
            }
        }

        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hmap=new HashMap<String, Integer>();
        int indexxx=0;
        List<List<String>> result=new ArrayList<>();
        for(int i=0; i<strs.length; i++)
        {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String temp="";
            for(char ch:arr)
            {
                temp+=ch;
            }
            System.out.println("temp="+temp);
            if(hmap.containsKey(temp)==false)
            {
                hmap.put(temp, indexxx);
                indexxx++;
                ArrayList<String> list=new ArrayList<String>();
                list.add(strs[i]);
                result.add(list);
            }
            else
            {
                int index=hmap.get(temp);
                result.get(index).add(strs[i]);
            }
        }

        return result;
    }


    public static int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		int count=0;
		
		for(int i=0; i<N; i++)
		{
		    for(int j=0; j<N; j++)
		    {
		        boolean result1=indian(mat, i, j);
		        boolean result2=arabian(mat, i, j, N, M);
		        if(result1 && result2)
		        {
                    System.out.println(mat[i][j]+" is it"+ " at index "+i+", "+j);
		            count++;
		        }
		    }
		}
		
		return count;
	}
	
	public static boolean indian(int [][] mat, int i1, int i2) {
	    int index1=i1-1;
	    int index2=i2-1;
	    boolean result1=true;
	    boolean result2=true;
	    while(index2>=0)
	    {
	        if(mat[i1][index2]>mat[i1][i2] || mat[i1][index2]>mat[i1][index2+1])
	        {
	            result1=false;
	        }
	        index2--;
	    }
	    
	    while(index1>=0)
	    {
	        if(mat[index1][i2]>mat[i1][i2] || mat[index1][i2]>mat[index1+1][i2])
	        {
	            result2=false;
	        }
	        index1--;
	    }
	    
	    if(result1 || result2)
        {
            return true;
        }
        else
        {
            return false;
        }
	}
	
	public static boolean arabian(int [][] mat, int i1, int i2, int N, int M) {
	    int index1=i1+1;
	    int index2=i2+1;

	    boolean result1=true;
	    boolean result2=true;        

	    while(index2<M)
	    {
	        if(mat[i1][index2]>mat[i1][i2] || mat[i1][index2]>mat[i1][index2-1])
	        {
	            result1=false;
	        }
	        index2++;
	    }
	    
	    while(index1<N)
	    {
	        if(mat[index1][i2]>mat[i1][i2] || mat[index1][i2]>mat[index1-1][i2])
	        {
	            result2=false;
	        }
	        index1++;
        }

        if(result1 || result2)
        {
            return true;
        }
        else
        {
            return false;
        }
	}

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        for(int i=0; i<n; i+=k)
        {
            if(i+k<n)
            {
                reverse(arr, i, i+k-1);
            }
            else
            {
                reverse(arr, i, n-1);
            }
        }
    }
    
    public static void reverse(ArrayList<Integer> arr, int i, int j)
    {
        while(i<j)
        {
            System.out.println(arr.get(i)+" and "+arr.get(j)+" Are swapped");
            int temp=arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

        public static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max=-1, index=0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++)
        {
            System.out.println("Element="+arr[i]);
            if(i==arr.length-1)
            {
                result.add(arr[i]);
                break;
            }
            
            int element=arr[i], flag=1;
            max=arr[i+1];index=i+1;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[j]>element)
                {
                    System.out.println("For element "+element+" arr[j]"+arr[j]+" is checked. So flag=0");
                    flag=0;
                }
                if(arr[j]>max)
                {
                    max=arr[j];
                    index=j;
                }
            }
            System.out.println("For element "+element+" flag="+flag);
            if(flag==1)
            {
                result.add(element);
                System.out.println(element+" is added");
            }
            System.out.println("Jumped from "+i+" to "+index+" for element "+element);
            i=index-1;
        }
        
        return result;
    }
}