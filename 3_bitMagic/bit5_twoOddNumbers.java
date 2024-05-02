public class bit5_twoOddNumbers {
    public static void main(String[] args) {
        // int[] myArray={1,1,2,2,3,4,4,5,6,6};
        // int[] rArray=efficientSolution(myArray);
        // for(int i=0; i<rArray.length; i++)
        // {
        //     System.out.print(rArray[i]+" ");
        // }
        // System.out.println("");
    }

    public static int[] naiveSolution(int[] myArray)
    {
        int[] resultantArray=new int[2];
        int count=0;
        int resultantArrayIndex=0;
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
                resultantArray[resultantArrayIndex]=myArray[i];
                resultantArrayIndex++;
            }
        }
        return resultantArray;
    }

    // public static int[] efficientSolution(int[] myArray)
    // {
    // }
}
