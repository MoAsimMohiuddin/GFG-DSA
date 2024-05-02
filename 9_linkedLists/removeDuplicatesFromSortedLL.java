class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class removeDuplicatesFromSortedLL {
    public static void main(String[] args) {
        Node node1=new Node(10);
        Node node2=new Node(10);
        Node node3=new Node(20);
        Node node4=new Node(20);
        Node node5=new Node(50);
        Node node6=new Node(50);
        Node node7=new Node(60);
        Node node8=new Node(60);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        
        Node head=node1;

        printList(head);
        remDups(head);
        printList(head);
    }

    static Node removeDups(Node head)
    {
        Node temp=head, temp1=null;

        while(temp.data==temp.next.data)
        {
            temp1=temp;
            temp=temp.next;
            temp1.next=null;
        }

        Node result=temp;

        while(temp.next!=null)
        {
            if(temp.data==temp.next.data)
            {
                temp1.next=temp.next;
                temp=temp.next;
            }
            else
            {
                temp1=temp;
                temp=temp.next;
            }
        }

        return result;
    }

    static Node removeDuplicates(Node head)
    {
        Node temp=head, prev=head;

        while(temp!=null)
        {
            if(temp.data!=prev.data)
            {
                prev.next=temp;
                prev=temp;
            }
            temp=temp.next;
        }

        if(prev!=temp)
        {
            prev.next=null;
        }

        return head;
    }

    static void remDups(Node head)
    {
        Node temp=head;

        while(temp!=null && temp.next!=null)
        {
            if(temp.data==temp.next.data)
            {
                temp.next=temp.next.next;
            }
            else
            {
                temp=temp.next;
            }
        }
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
