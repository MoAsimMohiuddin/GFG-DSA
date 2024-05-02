/*
Properties of XOR:
x^0=0
x^x=0
*/

public class bit4_oneOddOccuring {
    public static void main(String[] args)
    {
        int[] myArray={1,1,2,2,2,2,3,4,4};
        int result=efficientSolution(myArray);
        System.out.println(result);
    }

    public static int naiveSolution(int[] myArray)
    {
        int count=0;
        for(int i=0; i<myArray.length; i++)
        {
            count=0;
            for(int j=0; j<myArray.length; j++)
            {
                if(myArray[i]==myArray[j])
                {
                    count++;
                }
            }
            if(count%2!=0)
            {
                return i;
            }
        }
        return -1;
    }

    public static int efficientSolution(int[] myArray)
    {
        int XOR=0;
        for(int i=0; i<myArray.length; i++)
        {
            XOR=XOR^myArray[i];
        }
        return XOR;
    }
}
