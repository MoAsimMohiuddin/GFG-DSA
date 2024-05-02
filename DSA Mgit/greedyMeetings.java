import java.util.ArrayList;
import java.util.Collections;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    Meeting(int s, int e) {
        this.start=s;
        this.end=e;
    }

    @Override
    public int compareTo(Meeting a) {
        return this.end-a.end;
    }
}


public class greedyMeetings {
    public static void main(String[] args) {
        ArrayList<Meeting> meetings=new ArrayList<Meeting>();

        Meeting a3=new Meeting(1, 2);
        Meeting a2=new Meeting(3, 4);
        Meeting a1=new Meeting(0, 6);
        Meeting a4=new Meeting(5, 7);
        Meeting a5=new Meeting(8, 9);
        Meeting a6=new Meeting(5, 9);

        meetings.add(a1);
        meetings.add(a2);
        meetings.add(a3);
        meetings.add(a4);
        meetings.add(a5);
        meetings.add(a6);
        Collections.sort(meetings);

        // for(Meeting a:meetings) {
        //     System.out.println(a.end+", ");
        // }

        System.out.println(method(meetings));
    }

    static int method(ArrayList<Meeting> meetings) {
        int result=1, temp=0, len=meetings.size();
        System.out.println("Activity.start="+meetings.get(0).start+", Activity.end="+meetings.get(0).end);
        for(int i=1; i<len; i++) {
            if(meetings.get(i).start>meetings.get(temp).end) {
                System.out.println("Activity.start="+meetings.get(i).start+", Activity.end="+meetings.get(i).end);
                result++;
                temp=i;
            }
        }

        return result;
    }
}

