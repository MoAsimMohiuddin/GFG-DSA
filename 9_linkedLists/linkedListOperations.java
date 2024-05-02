import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data, Node node)
    {
        this.data=data;
        this.next=node;
    }
}

public class linkedListOperations{
    public static void main(String[] args)
    {
        Node node1=new Node(10, null);
        Node node2=new Node(20, null);
        Node node3=new Node(30, null);
        Node node4=new Node(40, null);
        Node node5=new Node(50, null);
        Node node6=new Node(60, null);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;

        Node mid=nthNodeFromEnd(node1, 3);
        System.out.println(mid.data);
    }

    public static void iteration(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println();
    }
    public static void recursiveIteration(Node node)
    {
        if(node==null)
        {
            return;
        }
        else
        {
            System.out.print(node.data+", ");
            recursiveIteration(node.next);
        }
    }

    public static Node insertAtBeginning(Node head)
    {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Node newNode=new Node(data, null);
        newNode.next=head;
        head=newNode;
        sc.close();
        return newNode;
    }

    public static Node insertionAtLast(Node head)
    {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Node newNode=new Node(data, null);

        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        
        temp.next=newNode;
        sc.close();
        return newNode;
    }

    public static Node deleteFirstNode(Node head)
    {
        head=head.next;
        return head;
    }

    public static Node insertAtAPosition(int position, Node head)
    {
        if(head==null)
        {
            return null;
        }
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();

        Node newNode=new Node(data, null);

        if(position==1)
        {
            newNode.next=head;
            head=newNode;
            sc.close();
            return newNode;
        }
        Node temp=head;
        for(int i=0; i<position; i++)
        {
            temp=temp.next;
        }

        newNode.next=temp.next;
        temp.next=newNode;

        sc.close();
        return newNode;
    }

    public static boolean search(int key, Node head)
    {
        if(head==null)
        {
            return false;
        }
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==key)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean searchRecursive(int key, Node node)
    {
        if(node==null)
        {
            return false;
        }
        else
        {
            System.out.println("Current node="+node.data);
            if(node.data==key)
            {
                System.out.println("Found");
                return true;
            }
            else
            {
                boolean result=false;
                result=result||searchRecursive(key, node.next);
                return result;
            }
        }
    }

    public static int searchReturningPosition(int key, Node head)
    {
        if(head==null)
        {
            return -1;
        }
        else if(head.data==key)
        {
            return 1;
        }
        else
        {
            int result=searchReturningPosition(key, head.next);
            if(result==-1)
            {
                return -1;
            }
            else
            {
                return result+1;
            }
        }
    }

    static Node middleElement(Node head)
    {
        if(head==null)
        {
            return null;
        }
        else if(head.next==null)
        {
            return head;
        }

        Node slow=head, fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    static Node nthNodeFromEnd(Node head, int k)
    {
        if(head==null || head.next==null)
        {
            return null;
        }

        Node slow=head, fast=head;

        for(int i=0; i<k; i++)
        {
            if(fast==null)
            {
                return null;
            }
            fast=fast.next;
        }

        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }
}