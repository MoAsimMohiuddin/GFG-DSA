class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class pairwiseSwap {
    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(40);
        Node n5=new Node(50);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node head=n1;

        printList(head);
        head=swappingReferences(head);
        printList(head);
    }

    static Node swappingData(Node head)
    {
        Node temp=head;

        while(temp.next!=null && temp.next.next!=null)
        {
            int t=temp.data;
            temp.data=temp.next.data;
            temp.next.data=t;
            
            temp=temp.next.next;
        }

        if(temp.next!=null)
        {
            int t=temp.data;
            temp.data=temp.next.data;
            temp.next.data=t;
        }

        return head;
    }

    static Node swappingReferences(Node head)
    {
        Node result=head.next, curr=head, lastNode=null, tempRef=head;;

        while(curr!=null && curr.next!=null)
        {
            tempRef=curr.next;
            curr.next=curr.next.next;
            tempRef.next=curr;
            if(lastNode==null)
            {
                lastNode=curr;
                curr=curr.next;
                continue;
            }
            lastNode.next=tempRef;
            lastNode=curr;
            curr=curr.next;
        }

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
