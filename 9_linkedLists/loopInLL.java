class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class loopInLL{
    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(40);
        Node n5=new Node(50);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n3;

        Node head=n1;

        int res=countNodesInALoop(head);
        System.out.println(res);
    }
    static Node detectLoop(Node head)
    {
        Node slow=head, fast=head;

        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                break;
        }

        if(fast!=slow) {
            return null;
        }

        slow=head;

        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }

        System.out.println("Loop="+slow.data);
        return slow;
    }

    static Node detectLoopDummyNodeMethod(Node head)
    {
        Node dummy=new Node(0), temp=head;

        while(temp!=null)
        {
            if(temp.next==null)
            {
                return null;
            }
            if(temp.next==dummy)
            {
                return temp;
            }
            else
            {
                Node temp1=temp;
                temp=temp.next;
                temp1.next=dummy;
            }
        }

        return null;
    }

    static int countNodesInALoop(Node head)
    {
        Node slow=head, fast=head;
        
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast) break;
        }
        
        if(slow!=fast) return 0;

        int count=0;

        do{
            count++;
            fast=fast.next;
        }while(slow!=fast);

        return count;
        // slow=head;
        
        // while(slow!=fast)
        // {
        //     slow=slow.next;
        //     fast=fast.next;
        // }
        
        // int count=0;
        // do{
        //     count++;
        //     fast=fast.next;
        // }while(slow!=fast);
        
        // return count;
    }

    static void removeLoop(Node head)
    {
        Node slow=head, fast=head;
        
        Node temp=fast;
        while(fast!=null && fast.next!=null)
        {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast) break;
        }
        
        if(slow!=fast) {System.out.println("Loop doesn't exist."); return;};
        
        slow=head;
        
        
        while(slow!=fast)
        {
            slow=slow.next;
            temp=fast;
            fast=fast.next;
        }

        System.out.println("slow.data="+slow.data+", fast.data="+fast.data);
        System.out.println("temp.data="+temp.data);
        
        temp.next=null;
    }

    static void removeLoopGFG(Node head)
    {
        Node slow=head, fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                break;
            }
        }

        slow=head;
        while(slow.next!=fast.next)
        {
            slow=slow.next;
            fast=fast.next;
        }

        fast.next=null;

        return;
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
