public class segregateEvenOddNodes {
    public static void main(String[] args) {
        Node n1=new Node(17);
        Node n2=new Node(15);
        Node n3=new Node(8);
        Node n4=new Node(12);
        Node n5=new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        Node head=n1;

        printList(head);
        head=GFGMethod(head);
        printList(head);
    }

    static Node method(Node head)
    {
        Node temp=head, curr=head;

        while(curr!=null)
        {
            if(curr.data%2==0)
            {
                int swapper=temp.data;
                temp.data=curr.data;
                curr.data=swapper;

                temp=temp.next;
            }

            curr=curr.next;
        }

        return head;
    }

    static Node GFGMethod(Node head)
    {
        Node curr=head, eS=null, eE=null, oS=null, oE=null;

        while(curr!=null)
        {
            int data=curr.data;

            if(data%2==0)
            {
                if(eS==null)
                {
                    eS=curr;
                    eE=eS;
                }
                else
                {
                    eE.next=curr;
                    eE=eE.next;
                }
            }
            else
            {
                if(oS==null)
                {
                    oS=curr;
                    oE=oS;
                }
                else
                {
                    oE.next=curr;
                    oE=oE.next;
                }
            }

            curr=curr.next;
        }

        if(oS==null || eS==null)
        {
            return head;
        }

        eE.next=oS;
        oE.next=null;
        
        return eS;
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
}
