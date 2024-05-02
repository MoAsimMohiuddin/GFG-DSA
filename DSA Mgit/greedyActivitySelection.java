import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity>{
    int start;
    int end;

    Activity(int s, int e) {
        this.start=s;
        this.end=e;
    }

    @Override
    public int compareTo(Activity a) {
        return this.end-a.end;
    }
}


public class greedyActivitySelection {
    public static void main(String[] args) {
        ArrayList<Activity> activites=new ArrayList<Activity>();

        Activity a3=new Activity(1, 3);
        Activity a2=new Activity(3, 8);
        Activity a1=new Activity(5, 10);

        activites.add(a1);
        activites.add(a2);
        activites.add(a3);
        Collections.sort(activites);

        for(Activity a:activites) {
            // System.out.println(a.end+", ");
        }

        System.out.println(method(activites));
    }

    static int method(ArrayList<Activity> activites) {
        int result=1, temp=0, len=activites.size();

        for(int i=1; i<len; i++) {
            if(activites.get(i).start>=activites.get(temp).end) {
                result++;
                temp=i;
            }
        }

        return result;
    }
}

