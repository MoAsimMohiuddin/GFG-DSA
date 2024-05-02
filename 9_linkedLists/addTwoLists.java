class Node{
    int data;
    Node next;

    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class addTwoLists {

    public static void main(String[] args) {
        Node n1=new Node(4);    
        Node n2=new Node(3);    
        Node n3=new Node(2);
        Node n4=new Node(5);
        Node n5=new Node(7);

        Node m1=new Node(5);    
        Node m2=new Node(7);
        Node m3=new Node(9);
        Node m4=new Node(9);
        Node m5=new Node(9);
        Node m6=new Node(8);
        Node m7=new Node(5);
        Node m8=new Node(5);
        
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        m1.next=m2;
        m2.next=m3;
        m3.next=m4;
        m4.next=m5;
        m5.next=m6;
        m6.next=m7;
        m7.next=m8;
        m8.next=null;

        stringsMeth(n1, m1);
        // printList(result);
    }
    static void stringsMeth(Node first, Node second) {
        Node temp=first;
        String str1="", str2="";

        while(temp!=null) {
            str1+=String.valueOf(temp.data);
            temp=temp.next;
        }

        temp=second;

        while(temp!=null) {
            str2+=String.valueOf(temp.data);
            temp=temp.next;
        }

        int n1=Integer.valueOf(str1), n2=Integer.valueOf(str2);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n1+n2);
    }
    static Node functionAddTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        int num1=0, num2=0, l1=0, l2=0;
        
        Node t=first;
        while(t!=null)
        {
            l1++;
            t=t.next;
        }
        
        t=second;
        while(t!=null)
        {
            l2++;
            t=t.next;
        }
        
        int pow1=(int)Math.pow(10, l1-1), pow2=(int)Math.pow(10, l2-1);
        System.out.println("pow1="+pow1+", pow2="+pow2);
        t=first;
        while(t!=null)
        {
            num1=num1+t.data*pow1;
            t=t.next;
            pow1/=10;
        }
        
        t=second;
        while(t!=null)
        {
            num2=num2+t.data*pow2;
            t=t.next;
            pow2/=10;
        }
        
        System.out.println("num1="+num1+", num2="+num2);

        int num3=num1+num2;
        System.out.println("num3="+num3);

        Node temp=null;
        while(num3>0)
        {
            int rem=num3%10;
            Node newNode=new Node(rem);
            newNode.next=temp;
            temp=newNode;
            num3/=10;
        }
        
        return temp;
    }

    static void method(Node first, Node second)
    {
        int num1=0, num2=0, l1=0, l2=0;
        
        Node t=first;
        while(t!=null)
        {
            l1++;
            t=t.next;
        }
        
        t=second;
        while(t!=null)
        {
            l2++;
            t=t.next;
        }
        
        int pow1=(int)Math.pow(10, l1-1), pow2=(int)Math.pow(10, l2-1);
        
        t=first;
        while(t!=null)
        {
            num1=num1+t.data*pow1;
            t=t.next;
            pow1/=10;
        }
        
        t=second;
        while(t!=null)
        {
            num2=num2+t.data*pow2;
            t=t.next;
            pow2/=10;
        }
        
        int num3=num1+num2;

        System.out.println("num3="+num3);
    }
    static void printList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
    }
}
