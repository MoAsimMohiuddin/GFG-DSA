public class LinkedListStack{
    class LinkedList{
        int data;
        LinkedList next;

        LinkedList(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    LinkedList head;
    int size;

    LinkedListStack(int data)
    {
        LinkedList node=new LinkedList(data);

        node.next=null;
        head=node;
        this.size++;
    }

    void push(int data)
    {
        LinkedList node=new LinkedList(data);
        node.next=head;
        head=node;
        this.size++;
    }

    LinkedList pop()
    {
        if(this.head==null)
        {
            System.out.println("Stack is Empty");
            return null;
        }

        LinkedList result=head;
        this.head=this.head.next;
        this.size--;
        System.out.println("Popped");
        return result;
    }

    int size()
    {
        return this.size;
    }

    int peek()
    {
        return head.data;
    }
    void printStack()
    {
        if(this.head==null)
        {
            System.out.println("Stack is Empty");
            return;
        }
        LinkedList temp=this.head;

        while(temp!=null)
        {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListStack stack=new LinkedListStack(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.peek());
        System.out.println(stack.size);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.push(69);
        stack.printStack();
    }
}