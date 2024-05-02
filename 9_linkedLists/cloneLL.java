import java.util.HashMap;

class Node
{
    int data;
    Node next;
    Node random;

    Node(int data)
    {
        this.data=data;
        this.next=null;
        this.random=null;
    }
}

public class cloneLL {
    public static void main(String[] args) {
        
    }

    static Node hMapMethod(Node head)
    {
        HashMap<Node, Node> hSet=new HashMap<Node, Node>();

        Node temp=head;
        
        while(temp!=null)
        {
            hSet.put(temp, new Node(temp.data));
            temp=temp.next;
        }

        temp=head;

        while(temp!=null)
        {
            Node clone=hSet.get(temp);
            clone.next=hSet.get(temp.next);
            clone.random=hSet.get(temp.random);
        }

        return hSet.get(head);
    }
}
