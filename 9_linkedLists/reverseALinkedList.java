import java.util.ArrayList;

class Node
{
    int data;
    Node next;

    public Node(int data, Node nextNode)
    {
        this.data=data;
        this.next=nextNode;
    }
}

public class reverseALinkedList {

    public static void main(String[] args)
    {
        Node n1=new Node(10, null);
        Node n2=new Node(20, null);
        Node n3=new Node(30, null);
        Node n4=new Node(40, null);
        Node n5=new Node(50, null);
        Node n6=new Node(60, null);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        Node head=n1;

        printList(head);
        head=reverseLLRecursive2(head, null);
        printList(head);
    }

    static Node naiveSolution(Node head)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();

        Node temp=head;

        while(temp!=null)
        {
            arr.add(temp.data);
        }

        temp=head;

        while(temp!=null)
        {
            temp.data=arr.remove(arr.size()-1);
        }

        return head;
    }

    public static Node reverseLL(Node head)
    {
        /*
        What we do in this approach is that we store the previously iterated Node in a variable, And when we go to the next node, We reference that node to the previously stored node.
         */
        Node prev=null, nextNode=null, current=head;

        while(current!=null)
        {
            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }

        return prev;
    }

    static Node reverseLLRecursive(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        else
        {
            Node rest_head=reverseLLRecursive(head.next);
            Node rest_tail=head.next;
            rest_tail.next=head;
            head.next=null;

            System.out.println("rest_head="+rest_head.data);
            return rest_head;
        }
    }

    static Node reverseLLRecursive2(Node head, Node prev)
    {
        if(head==null)
        {
            return prev;
        }

        Node next=head.next;
        head.next=prev;
        
        return reverseLLRecursive2(next, head);
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
}

