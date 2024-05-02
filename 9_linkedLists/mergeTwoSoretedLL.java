public class mergeTwoSoretedLL {
    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);

        n1.next=n2;
        n2.next=n3;

        Node m1=new Node(25);
        Node m2=new Node(30);

        m1.next=m2;

        Node head=merge(m1, n1);
        printList(head);
    }

    static Node merge(Node head1, Node head2)
    {
        Node tail=null, p1=head1, p2=head2, head=null;

        if(p1.data<p2.data)
        {
            head=p1;
            tail=p1;
            p1=p1.next;
        }
        else
        {
            head=p2;
            tail=p2;
            p2=p2.next;
        }

        while(p1!=null && p2!=null)
        {
            if(p1.data<p2.data)
            {
                tail.next=p1;
                tail=p1;
                p1=p1.next;
            }
            else
            {
                tail.next=p2;
                tail=p2;
                p2=p2.next;
            }
        }

        while(p1!=null)
        {
            tail.next=p1;
            tail=p1;

            p1=p1.next;
        }

        while(p2!=null)
        {
            tail.next=p2;
            tail=p2;

            p2=p2.next;
        }

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
