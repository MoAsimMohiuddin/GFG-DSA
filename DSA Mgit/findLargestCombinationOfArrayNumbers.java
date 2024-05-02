public class findLargestCombinationOfArrayNumbers {
    public static void main(String[] args) {
        int[] arr={3, 30, 34, 5, 9};

        String result=meth(arr);
        System.out.println(result);
    }

    public static String meth(int[] arr) {
        String result="";

        int size=arr.length;
        for(int i=0; i<size; i+=2) {
            if(i==size-1) {
                String subStr=String.valueOf(arr[i]);
                if(Integer.valueOf(subStr.charAt(0))>Integer.valueOf(result.charAt(0))){
                    result=subStr+result;
                }
                else{
                    result+=subStr;
                }
                continue;
            }

            String subStr=String.valueOf(arr[i])+String.valueOf(arr[i+1]);
            if(Integer.valueOf(subStr)>Integer.valueOf(String.valueOf(arr[i+1])+String.valueOf(arr[i]))==false){
                subStr=String.valueOf(arr[i+1])+String.valueOf(arr[i]);
            }

            if(result==""){
                result=subStr;
                continue;
            }
            else{
                if(Integer.valueOf(subStr.charAt(0))>Integer.valueOf(result.charAt(0))){
                    result=subStr+result;
                }
                else{
                    result+=subStr;
                }
            }
        }
        return result;
    }
}

// Comparator<String> comp=(a,b)=>(b,a).compareTo(a+b);