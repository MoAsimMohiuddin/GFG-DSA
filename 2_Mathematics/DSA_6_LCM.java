public class DSA_6_LCM {
    public static void main(String[] args)
    {
        int r1=normalApproach(12, 8);
        int r2=approachWithGCD(12, 8);
        System.out.println(r1);
        System.out.println(r2);
    }

    public static int normalApproach(int n1, int n2)
    {
        int max=n1;
        if(n2>max)
        {
            max=n2;
        }

        while(true)
        {
            if(max%n1==0 && max%n2==0)
            {
                return max;
            }
            max++;
        }
    }

    public static int approachWithGCD(int n1, int n2)
    {
        int gcd=gcd(n1, n2); 
        return((n1*n2)/gcd);
    }

    public static int gcd(int n1, int n2)
    {
        while(n1!=n2)
        {
            if(n1>n2)
            {
                n1=n1-n2;
            }
            else
            {
                n2=n2-n1;
            }
        }
        return n1;
    }
}
