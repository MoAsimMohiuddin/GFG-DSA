import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        subsets("abc");
    }

    static void subsets(String str)
    {
        int lenOfString=str.length(), subsets=1<<lenOfString;

        for(int i=0; i<subsets; i++)
        {
            System.out.print("\"");
            for(int j=0; j<lenOfString; j++)
            {
                if((i&(1<<j))!=0)
                {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.print("\"");
            System.out.println();
        }
    }
    static int powerOfANumber(int n, int x)
    {
        if(n==0)
        {
            return 1;
        }

        int temp=powerOfANumber(n, x/2);
        temp*=temp;

        if(n%2==0)
        {
            return temp;
        }
        else
        {
            return temp*x;
        }
    }

    static void seiveOfEratothenes(int num)
    {
        boolean[] arr=new boolean[num+1];
        Arrays.fill(arr,true);

        for(int i=2; i<=num; i++)
        {
            if(arr[i]==true)
            {
                for(int j=i*i; j<=num; j+=i)
                {
                    arr[j]=false;
                }
            }
        }

        int size=arr.length;
        for(int i=2; i<size; i++)
        {
            if(arr[i]==true)
            {
                System.out.print(i+", ");
            }
        }

        System.out.println();
    }
    static void primeFactorsNormalApproach(int num)
    {
        for(int i=2; i<num; i++)
        {
            if(num%i==0 && checkForPrime(i))
            {
                int j=1;

                while(Math.pow(i,j)<=num)
                {
                    if(num%Math.pow(i,j)==0)
                    {
                        System.out.print(i+" ");
                    }
                    j++;
                }
            }
        }
    }

    static void primeFactorsEfficientApproach(int num)
    {
        for(int i=2; i<num && num>=1; i++)
        {
            if(num%i==0 && checkForPrime(i))
            {
                while(num%i==0){
                    System.out.print(i+" ");
                    num/=i;
                }
            }  
        }
    }
    
    static boolean checkForPrime(int num)
    {
        for(int i=2; i<num; i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }

        return true;
    }

    static int GCD(int num1, int num2)
    {
        while(num1!=num2)
        {
            if(num1>num2)
            {
                num1=num1-num2;
            }
            else
            {
                num2=num2-num1;
            }
        }

        return num1;
    }

    static int GCDRecursive(int num1, int num2)
    {
        if(num2==0)
        {
            return num1;
        }
        else
        {
            return GCDRecursive(num2, num1%num2);
        }
    }

    static String bits(int num)
    {
        String res="";

        while(num>0)
        {
            int rem=num%2;
            res=rem+res;
            num/=2;
        }

        return res;
    }

    static boolean palindrome(int num)
    {
        int rev=0, rem=0, temp=num;

        while(temp>0)
        {
            rem=temp%10;
            rev=rev*10+rem;
            temp/=10;
        }
        System.out.println("rev="+rev);
        return rev==num?true:false;
    }

    static int fact(int num)
    {
        if(num==0 || num==1)
        {
            return 1;
        }

        int fact=1;

        while(num>0)
        {
            fact=fact*(num);
            num-=1;
        }

        return fact;
    }

    static int factRecursive(int num)
    {
        if(num==0 || num==1)
        {
            return 1;
        }
        else
        {
            return num*fact(num-1);
        }
    }
}
