public class swapKthNodes {
    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(40);
        // Node n5=new Node(50);
        // Node n6=new Node(60);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        // n5.next=n6;
        // n6.next=null;

        Node head=n1;

        printList(head);
        head=swap(n1, 4, 1);
        printList(head);
    }

    static Node swap(Node head, int num, int K)
    {
        if(K>num)
        {
            return null;
        }

        if(K==1)
        {
            Node temp=head, temp1=head, temp2=head;

            while(temp1.next!=null)
            {
                temp2=temp1;
                temp1=temp1.next;
            }

            System.out.println("temp="+temp.data+", temp1="+temp1.data+", temp2="+temp2.data);
            temp2.next=temp;
            temp1.next=temp.next;
            temp.next=null;

            return temp1;
        }
        
        Node a1=head, a2=head;
        
        for(int i=0; i<K-1; i++)
        {
            a1=a2;
            a2=a2.next;
        }
        
        Node b1=head, b2=head;
        
        for(int i=0; i<num-K; i++)
        {
            b1=b2;
            b2=b2.next;
        }
        
        Node temp=a1.next;
        a1.next=b1.next;
        b1.next=temp;
        
        temp=a2.next;
        a2.next=b2.next;
        b2.next=temp;
        
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
