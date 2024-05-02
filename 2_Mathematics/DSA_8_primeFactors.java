import java.lang.Math;

public class DSA_8_primeFactors {
    public static void main(String[] args) {
        moreEfficientApproach(450);
    }
    public static boolean checkPrime(int num)
    {
        if(num==1)
        {
            return false;
        }
        if(num==2 || num==3)
        {
            return true;
        }
        if(num%2==0 || num%3==0)
        {
            return false;
        }

        for(int i=5; i*i<=num; i+=6)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void primeFactors(int num)
    {
        int j;
        for(int i=2; i<=num; i++)
        {
            if(num%i==0 && checkPrime(i)==true)
            {
                j=1;
                while(Math.pow(i,j)<=num)
                {
                    if(num%Math.pow(i,j)==0){
                        System.out.print(i+" ");
                    }
                    j++;
                }
            }
        }
        System.out.println();
    }

    public static void efficientApproach(int num)
    {
        if(num<=1)
        {
            return;
        }
        for(int i=2; i*i<=num; i++)
        {
            while(num%i==0)
            {
                System.out.print(i+" ");
                num=num/i;
            }
        }
        
        if(num>1)
        {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void moreEfficientApproach(int num)
    {
        if(num<=1)
        {
            return;
        }

        while(num%2==0) { System.out.print(2+" "); num/=2; }
        while(num%3==0) { System.out.print(3+" "); num/=3; }

        for(int i=5; i*i<=num; i+=6)
        {
            while(num%i==0)
            {
                System.out.print(i+" ");
                num/=i;
            }
        }
        if(num>3)
        {
            System.out.println(num);
        }
    }
}
