class Node{
    int data;
    Node next, prev;

    Node(int data)
    {
        this.data=data;
        this.next=this.prev=null;
    }
}

public class doublyLinkedList {
    public static void main(String[] args) {
        
    }

    static Node insertAtBeginning(Node head, int data)
    {
        Node newNode=new Node(data);

        newNode.next=head;
        if(head!=null) head.prev=newNode;

        return newNode;
    }
}
