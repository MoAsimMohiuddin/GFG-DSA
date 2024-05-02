public class DSA_5_GCD {
    public static void main(String[] args)
    {
        int r1=normalApproach(16, 20);
        int r2=euclideanAlgorithm(16, 20);
        int r3=recursiveApproach(16, 20);
        System.out.println("Result1 : "+r1);
        System.out.println("Result2 : "+r2);
        System.out.println("Result3 : "+r3);
    }

    public static int normalApproach(int n1, int n2)
    {
        int min=n1;
        if(n2<min)
        {
            min=n2;
        }
        while(n1!=n2)
        {
            if(n1%min==0 && n2%min==0)
            {
                return min;
            }
            min--; 
        }
        return min;
    }

    public static int euclideanAlgorithm(int n1, int n2)
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

    public static int recursiveApproach(int n1, int n2)
    {
        if(n2==0)
        {
            return n1;
        }
        else
        {
            return recursiveApproach(n2, n1%n2);
        }
    }
}
