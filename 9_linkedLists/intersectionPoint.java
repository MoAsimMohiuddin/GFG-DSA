class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}


public class intersectionPoint {
    public static void main(String[] args) {
        Node n1=new Node(3);
        Node n2=new Node(4);
        Node n3=new Node(0);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        Node m1=new Node(2);
        Node m2=new Node(1);
        Node m3=new Node(14);
        m1.next=m2;
        m2.next=m3;
        m3.next=null;

        Node c1=new Node(3);
        Node c2=new Node(4);
        Node c3=new Node(5);
        Node c4=new Node(6);
        c1.next=c2;
        c2.next=c3;
        c3.next=c4;
        c4.next=null;
        
        n3.next=c1;
        m3.next=c1;

        Node head1=n1;
        Node head2=m1;

        int result=method(head1, head2);
        System.out.println(result);
    }

    static int method(Node head1, Node head2)
    {
        Node temp=head1;
         
        while(temp!=null)
        {
            temp.data*=-1;
            System.out.println("temp="+temp.data);
            temp=temp.next;
        }
        
        temp=head2;
        
        while(temp!=null)
        {
            System.out.println("temp="+temp.data);
            temp.data*=-1;
            temp=temp.next;
        }
        
        Node result=head1;
        while(result!=null)
        {
            if(result.data>0)
            {
                break;
            }
            result=result.next;
        }
        System.out.println("result="+result.data);
        
        // temp=head1;
        
        // while(temp!=null)
        // {
        //     if(temp.data==result.data)
        //     {
        //         continue;
        //     }
        //     temp.data*=-1;
            
        //     temp=temp.next;
        // }
        // temp=head2;
        // while(temp!=null)
        // {
        //     if(temp.data==result.data)
        //     {
        //         continue;
        //     }
        //     temp.data*=-1;
            
        //     temp=temp.next;
        // }
        
        return result.data;
    }
}
