class Intervals{
    int start;
    int end;
}

public class gfg_18_mergeOverlappingIntervals {
    public static void main(String[] ASIM)
    {
        Intervals[] intervalArray=new Intervals[4];

        Intervals obj1=new Intervals();
        obj1.start=1;
        obj1.end=3;
        Intervals obj2=new Intervals();
        obj2.start=2;
        obj2.end=4;
        Intervals obj3=new Intervals();
        obj3.start=5;
        obj3.end=7;
        Intervals obj4=new Intervals();
        obj4.start=6;
        obj4.end=8;

        intervalArray[0]=obj1;
        intervalArray[1]=obj2;
        intervalArray[2]=obj3;
        intervalArray[3]=obj4;
    }
}
