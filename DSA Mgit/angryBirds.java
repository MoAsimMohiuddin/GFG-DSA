public class angryBirds {
    public static void main(String[] args) {
        int[] nests={1,2,4,8,9};
        int birds=3;

        System.out.println(method(nests, birds));
    }

    public static int method(int[] nests, int birds) {
        int len=nests.length;

        int start=0, end=nests[len-1]-nests[0], res=0;

        while(start<=end) {
            int mid=(start+end)/2;

            if(canPlace(nests, birds, mid)){
                res=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return res;
    }

    static boolean canPlace(int[] nests, int birds, int distance) {
        int birdsPlaced=1, previos=nests[0], len=nests.length;

        for(int i=0; i<len; i++) {
            int current=nests[i];

            if(current-previos>=distance) {
                birdsPlaced++;
                previos=current;

                if(birdsPlaced==birds) return true;
            }
        }

        return false;
    }
}