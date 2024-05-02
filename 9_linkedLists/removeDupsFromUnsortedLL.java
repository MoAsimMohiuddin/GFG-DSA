import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class removeDupsFromUnsortedLL {
    public static void main(String[] args)
    {
        Node node1=new Node(40);
        Node node2=new Node(80);
        Node node3=new Node(56);
        Node node4=new Node(40);
        Node node5=new Node(50);
        Node node6=new Node(80);
        Node node7=new Node(90);
        Node node8=new Node(40);
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
        head=meth(head);
        printList(head);
    }

    static Node meth(Node head)
    {
        HashSet<Integer> hSet=new HashSet<Integer>();

        Node curr=head, iter=head.next;
        hSet.add(head.data);

        while(iter!=null)
        {
            if(!hSet.contains(iter.data))
            {
                hSet.add(iter.data);
                curr.next=iter;
                curr=iter;
            }

            iter=iter.next;
        }

        curr.next=null;

        return head;
    }

    static Node method(Node head)
    {
        Node iter=head, temp=head, t1=null;
         
        HashSet<Integer> hSet=new HashSet<Integer>();
        
        while(iter!=null)
        {
            if(!hSet.contains(iter.data))
            {
                hSet.add(iter.data);
                temp.data=iter.data;
                t1=temp;
                temp=temp.next;
                iter=iter.next;
            }
            else
            {
                iter=iter.next;
            }
        }
        
        t1.next=null;
        
        return head;
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
