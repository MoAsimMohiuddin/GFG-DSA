class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class Pr {
    static Node reverseList(Node head)
    {
        // code here
        Node temp1=head;
        Node temp=head.next;
        Node t=temp.next;
        System.out.println("t="+t.data);
        
        while(temp!=null)
        {
            System.out.println("Currently temp="+temp.data+", temp1="+temp1.data);

            t=temp.next;
            temp.next=temp1;
            temp1=temp1.next;
            if(t!=null) temp=t;
        }
        
        return temp;
    }

    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(40);
        Node n5=new Node(50);
        Node n6=new Node(60);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        reverseList(n1);
    }
}
