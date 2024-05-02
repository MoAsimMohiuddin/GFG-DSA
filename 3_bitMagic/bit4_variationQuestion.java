public class bit4_variationQuestion {
    public static void main(String[] args) {
        int[] myArray={1,2,4,5};
        System.out.println(efficientSolution(myArray));
    }

    public static int efficientSolution(int[] myArray)
    {
        int XORforN=0, XORforArray=0;
        for(int i=0; i<myArray.length; i++)
        {
            XORforN=XORforN^i;
        }
        for(int i=0; i<myArray.length; i++)
        {
            XORforArray^=i;
        }

        return((XORforArray^XORforN));
    }
}
