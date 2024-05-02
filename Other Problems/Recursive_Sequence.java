public class Recursive_Sequence {
    public static void main(String[] args) {
        System.out.println(sequence(5));
    }

    static long sequence(int n){
        // code here
        return helperFunction(7, 1, 1);
    }
    
    static long helperFunction(int n, int count, int starter) {
        if(count>n) return 0;
        long result=1;
        
        for(int i=0; i<count; i++) {
            result=result*starter;
            starter++;
        }

        System.out.println("Count="+count+", Result="+result);
        
        return result+helperFunction(n, count+1, starter);
    }
}
