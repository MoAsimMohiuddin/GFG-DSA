public class mergeSortDoubly
{
    static Node sortDoubly(Node head)
    {
        // add your code here
        Node temp=head;
        int high=0;
        while(temp!=null)
        {
            high++;
            temp=temp.next;
        }
        mergeSortAscending(head, 0, high-1);

        return head;
    }
    
    public static void mergeSortAscending(Node head, int low, int high)
    {
        if(low>=high)
        {
            return;
        }
        else
        {
            int mid=(low+high)/2;
            mergeSortAscending(head, low, mid);
            mergeSortAscending(head, mid+1, high);
            merge(head, low, high);
        }
    }

    public static void merge(Node head, int low, int high)
    {
        // System.out.println("head="+head.data);
        // System.out.println("low"+low+", high"+high);
        Node headOfAuxillaryList=null, temp=null;
        Node p1=head, p2=head;

        for(int i=0; i<low; i++)
        {
            p1=p1.next;
        }

        Node t=p1;
        int mid=(low+high)/2;
        for(int i=0; i<mid; i++)
        {
            p2=p2.next;
        }

        p2=p2.next;

        // System.out.println("p1="+p1.data+", p2="+p2.data);

        int p1Length=low, p2Length=mid+1;;
        while(p1Length<=mid && p2Length<=high)
        {
            // System.out.println("p1Length="+p1Length+", p2Length="+p2Length);
            if(p1.data<p2.data)
            {
                p1Length++;
                // System.out.println(p1.data+"<"+p2.data);
                Node newNode=new Node(p1.data, null, null);

                if(headOfAuxillaryList==null)
                {
                    headOfAuxillaryList=newNode;
                    temp=newNode;
                    p1=p1.next;
                }
                else
                {
                    newNode.prev=temp;
                    temp.next=newNode;
                    temp=newNode;
                    p1=p1.next;
                }
            }
            else
            {
                p2Length++;
                // System.out.println(p2.data+"<"+p1.data);
                Node newNode=new Node(p2.data, null, null);

                if(headOfAuxillaryList==null)
                {
                    headOfAuxillaryList=newNode;
                    temp=newNode;
                    p2=p2.next;
                }
                else
                {
                    newNode.prev=temp;
                    temp.next=newNode;
                    temp=newNode;
                    p2=p2.next;
                }
            }
        }

        while(p1Length<=mid)
        {
            p1Length++;
            // System.out.println(p1.data+" inserted p1");
            Node newNode=new Node(p1.data, null, null);

            if(headOfAuxillaryList==null)
            {
                head=newNode;
                temp=newNode;
                p1=p1.next;
            }
            else
            {
                newNode.prev=temp;
                temp.next=newNode;
                temp=newNode;
                p1=p1.next;
            }
        }

        while(p2Length<=high)
        {
            p2Length++;
            // System.out.println(p2.data+" inserted p2");
            Node newNode=new Node(p2.data, null, null);

            if(headOfAuxillaryList==null)
            {
                head=newNode;
                temp=newNode;
                p2=p2.next;
            }
            else
            {
                newNode.prev=temp;
                temp.next=newNode;
                temp=newNode;
                p2=p2.next;
            }
        }

        temp=t;
        p1=headOfAuxillaryList;

        while(p1!=null)
        {
            temp.data=p1.data;
            temp=temp.next;
            p1=p1.next;
        }

        // System.out.println("head="+head.data);
        // System.out.println("Current List");
        // printList(head);
    }

    public static void mergeSortDescending(Node head)
    {
        Node low=head, high=head;
        Node temp=head;
        int h=0;
        while(temp!=null)
        {
            h++;
            temp=temp.next;
        }
        mergeSortAscending(head, 0, h-1);

        while(high.next!=null)
        {
            high=high.next;
        }

        int count=0;

        while(count<h/2)
        {
            int t=low.data;
            low.data=high.data;
            high.data=t;
            low=low.next;
            high=high.prev;
            count++;
        }
    }
    public static void printList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node n1=new Node(7, null, null);
        Node n2=new Node(3, null, null);
        Node n3=new Node(5, null, null);
        Node n4=new Node(2, null, null);
        Node n5=new Node(6, null, null);
        Node n6=new Node(4, null, null);
        Node n7=new Node(1, null, null);
        Node n8=new Node(8, null, null);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=null;

        n1.prev=null;
        n2.prev=n1;
        n3.prev=n2;
        n4.prev=n3;
        n5.prev=n4;
        n6.prev=n5;
        n7.prev=n6;
        n8.prev=n7;

        Node head=n1;

        // System.out.println("List before merging");
        // printList(head);
        // merge(head, 0, 7);
        // System.out.println("List after merging");
        // printList(head);

        printList(head);
        sortDoubly(head);
        printList(head);
    }
}

class Node{
    int data;
    Node next, prev;
    public Node(int data, Node nextNode, Node prevNode)
    {
        this.data=data;
        this.next=nextNode;
        this.prev=prevNode;
    }
}