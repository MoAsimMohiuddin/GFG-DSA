import java.util.Scanner;

class DenominatorEqualToZeroException extends Exception{
    public DenominatorEqualToZeroException(String exc)
    {
        super(exc);
    }

    public static void main(String[] args) {
        try
        {
            Scanner input=new Scanner(System.in);

            System.out.println("Enter two numbers :");
            int num1=input.nextInt();
            int num2=input.nextInt();
            
            input.close();

            if(num2==0)
            {
                throw new DenominatorEqualToZeroException("The denominator cannot be equal to zero");
            }

            System.out.print("a/b=");
            System.out.println(num1/num2);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}