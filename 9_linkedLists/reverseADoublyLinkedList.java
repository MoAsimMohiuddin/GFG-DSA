class Node{
    int data;
    Node prev, next;

    Node(int data)
    {
        this.data=data;
        this.prev=this.next=null;
    }
}

public class reverseADoublyLinkedList {
    public static void main(String[] args)
    {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(40);
        Node n5=new Node(50);

        n1.next=n2;
        n2.prev=n1;
        n2.next=n3;
        n3.prev=n2;
        n3.next=n4;
        n4.prev=n3;
        n4.next=n5;
        n5.prev=n4;
        n5.next=null;


        Node head=n1;

        printList(head);
        head=reverseDLLSwapReferences(head);
        printList(head);
    }

    static Node reverseDLL(Node head)
    {
        Node low, high;
        low=high=head;

        int count=0;
        while(high.next!=null)
        {
            count++;
            high=high.next;
        }

        int i=0;
        while(i<count/2)
        {
            i++;

            int t=low.data;
            low.data=high.data;
            high.data=t;

            low=low.next;
            high=high.prev;
        }

        return head;
    }

    static Node reverseDLLSwapReferences(Node head)
    {
        Node p=null; Node curr=head;

        while(curr!=null)
        {
            p=curr.prev;
            curr.prev=curr.next;
            curr.next=p;
            curr=curr.prev;
        }

        return p.prev;
    }

    static void printList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node deleteFirstNode(Node head)
    {
        if(head==null || head.next==null) return null;

        head=head.next;
        head.prev=null;

        return head;
    }
    
    static Node deleteLastNode(Node head)
    {
        if(head==null || head.next==null) return null;

        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }

        temp.next=null;

        return head;
    }
}
