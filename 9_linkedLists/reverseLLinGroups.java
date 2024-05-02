import java.util.ArrayList;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class reverseLLinGroups {
    public static void main(String[] args) {
        Node node1=new Node(10);
        Node node2=new Node(20);
        Node node3=new Node(30);
        Node node4=new Node(40);
        Node node5=new Node(50);
        Node node6=new Node(70);
        Node node7=new Node(80);
        Node node8=new Node(90);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=null;

        Node head=node1;

        printList(head);
        head=iterativeSolution(head, 3);
        printList(head);
    }

    static Node recursiveSolution(Node head, int k)
    {
        Node next=null, prev=null, curr=head;
        int count=0;

        while(curr!=null && count<k)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }

        if(next!=null)
        {
            Node rest_head=recursiveSolution(next, k);
            head.next=rest_head;
        }

        return prev;
    }

    static Node iterativeSolution(Node head, int k)
    {
        Node prev=null, next=null, curr=head, result=head, prevFirst=null, first=null;
        boolean isFirstIteration=true;

        while(curr!=null)
        {
            int count=0;
            first=curr;
            prev=null;
            while(curr!=null && count<k)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }

            if(isFirstIteration)
            {
                result=prev;
                isFirstIteration=false;
            }
            else
            {
                prevFirst.next=prev;
            }
            prevFirst=first;
        }

        return result;
    }
    static Node reverseInGroups(Node head, int k)
    {
        ArrayList<Node> list;

        Node result=head;
        for(int i=0; i<k; i++)
        {
            result=result.next;
        }

        Node temp=head, prevHead=head;
        while(prevHead.next!=null)
        {
            list=reverseFunc(temp, prevHead,  k);
            prevHead=list.get(0);
            temp=list.get(1);
        }
        
        return result;
    }

    static ArrayList<Node> reverseFunc(Node head, Node prevHead, int k)
    {
        ArrayList<Node> result=new ArrayList<Node>();
        Node prev=null, next=null, curr=head;
        int flag=0;
        for(int i=0; i<k && curr!=null; i++)
        {
            next=curr.next;
            if(next==null) flag=1;
            curr.next=prev;
            prev=curr;
            if(next!=null) curr=next;
        }

        prevHead.next=prev;
        if(flag==0) head.next=curr;

        result.add(head);
        result.add(curr);
        return result;
    }

    static void printList(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+", ");
            head=head.next;
        }
        System.out.println();
    }
}
