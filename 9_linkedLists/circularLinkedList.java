/*
- In case of singly Linked list, We can Traverse the whole left array from any node.
- Implementation of Algorithms like Round Robin becomes easier.
- We can insert at the beginning or end with just one reference as tail.
*/

class Node{
    int data;
    Node prev,next;

    Node(int data)
    {
        this.data=data;
        this.prev=this.next=null;
    }
}

class singlyNode{
    int data;
    singlyNode next;

    singlyNode(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class circularLinkedList {
    public static void main(String[] args) {
        // Node n1=new Node(10);
        // Node n2=new Node(20);
        // Node n3=new Node(30);
        // Node n4=new Node(40);
        // Node n5=new Node(50);

        // n1.prev=n5;
        // n1.next=n2;
        // n2.prev=null;
        // n2.next=n3;
        // n3.prev=n2;
        // n3.next=n4;
        // n4.prev=n3;
        // n4.next=n5;
        // n5.prev=n4;
        // n5.next=n1;

        // Node head=n1;
        // printList(head);

        singlyNode n1=new singlyNode(10);
        singlyNode n2=new singlyNode(20);
        singlyNode n3=new singlyNode(30);
        singlyNode n4=new singlyNode(40);
        singlyNode n5=new singlyNode(50);

        singlyNode head=n1;
        
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n1;

        printSinglyList(head);
        head=sortedInsert(head, 5);
        printSinglyList(head);
    }

    static singlyNode insertAtBegninning(singlyNode head, int data)
    {
        singlyNode newNode=new singlyNode(data);
        if(head==null) return newNode;

        singlyNode temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
        }

        temp.next=newNode;
        newNode.next=head;

        return newNode;
    }

    static singlyNode insertAtBeginningEfficientSolution(singlyNode head, int data)
    {
        singlyNode newNode=new singlyNode(data);
        if(head==null) return newNode;

        int temp=head.data;
        head.data=newNode.data;
        newNode.next=head.next;
        head.next=newNode;
        newNode.data=temp;

        return head;
    }

    static singlyNode insertAtLast(singlyNode head, int data)
    {
        singlyNode newNode=new singlyNode(data);
        if(head==null)
        {
            newNode.next=newNode;
            return newNode;
        }
        else if(head.next==null)
        {
            head.next=newNode;
            newNode.next=head;

            return head;
        }

        singlyNode temp=head;

        while(temp.next!=head)
        {
            temp=temp.next;
        }

        newNode.next=temp.next;
        temp.next=newNode;

        return head;
    }

    static singlyNode insertAtLastEfficientSolution(singlyNode head, int data)
    {
        singlyNode newNode=new singlyNode(data);

        if(head==null)
        {
            newNode.next=newNode;
            return newNode;
        }

        newNode.next=head.next;
        head.next=newNode;
        
        int temp=head.data;
        head.data=newNode.data;
        newNode.data=temp;

        return newNode;
    }

    static singlyNode deleteFirstNode(singlyNode head)
    {
        if(head==null || head.next==null)
        {
            return null;
        }

        singlyNode temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
        }

        temp.next=temp.next.next;

        return head.next;
    }

    static singlyNode deleteFirstNodeEfficientSolution(singlyNode head)
    {
        if(head==null || head.next==null)
        {
            return null;
        }

        head.data=head.next.data;
        head.next=head.next.next;

        return head;
    }

    static singlyNode deletekthNode(singlyNode head, int k)
    {
        if(head==null)
        {
            return null;
        }
        else if(k==1)
        {
            head.data=head.next.data;
            head.next=head.next.next;
            return head;
        }

        singlyNode temp=head;

        for(int i=0; i<k-2; i++)
        {
            temp=temp.next;
        }

        temp.next=temp.next.next;

        return head;
    }

    static singlyNode sortedInsert(singlyNode head, int key)
    {
        singlyNode newNode=new singlyNode(key);
        if(head==null)
        {
            return newNode;
        }

        singlyNode temp=head;

        while(temp.data<key && temp.next.data<key)
        {
            temp=temp.next;
            if(temp.next==head)
            {
                break;
            }
        }

        if(temp==head)
        {
            newNode.next=temp.next;
            temp.next=newNode;
            int t=temp.data;
            temp.data=newNode.data;
            newNode.data=t;

            return head;
        }

        newNode.next=temp.next;
        temp.next=newNode;

        return head;
    }

    static void printSinglyList(singlyNode head)
    {
        if(head==null) return;
        singlyNode temp=head;

        do{
            System.out.print(temp.data+", ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    static void printList(Node head)
    {
        if(head==null) return;

        Node temp=head;

        do{
            System.out.print(temp.data+", ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    static void printList2(Node head)
    {
        if(head==null) return;

        Node temp=head;
        System.out.print(temp.data+", ");

        for(temp=temp.next; temp!=head; temp=temp.next)
        {
            System.out.print(temp.data+", ");
        }
        System.out.println();
    }
}
