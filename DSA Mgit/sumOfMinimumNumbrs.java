import java.util.Scanner;

public class sumOfMinimumNumbrs {
    public static void main(String[] args) {
        int result=sumOfDigits();
        System.out.println("Sum="+result);
    }

    static int sumOfDigits() {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number of Elements :");
        int size=sc.nextInt(), result=0;
        
        for(int i=0; i<size; i++) {
            System.out.println("Enter Element :");
            int element=sc.nextInt();

            result+=smallestDigit(element);
        }

        sc.close();
        return result;
    }

    static int smallestDigit(int element) {
        int result=Integer.MAX_VALUE;

        while(element>0) {
            int rem=element%10;
            if(rem<result){
                result=rem;
            }

            element/=10;
        }

        return result;
    }
}
