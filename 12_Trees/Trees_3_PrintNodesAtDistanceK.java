class Node{
    int data;
    Node left;Node right;

    Node(int data) {
        this.data=data;
    }
}

public class Trees_3_PrintNodesAtDistanceK {
    public static void main(String[] args) {
        Node root=null;

        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(40);
        Node n4=new Node(50);
        Node n5=new Node(70);
        Node n6=new Node(80);
        Node n7=new Node(30);
        Node n8=new Node(60);

        n4.left=n5;
        n4.right=n6;

        n2.left=n3;
        n2.right=n4;

        n7.right=n8;

        n1.left=n2;
        n1.right=n7;

        root=n1;

        printNodesAtDistanceK(root, 1);
    }

    // static void printNodesAtDistanceK(Node root, int k) {
    //     inOrderTraversal(root, k, 0);
    // }
    
    // static void inOrderTraversal(Node root, int k, int res) {
    //     if(root==null) {
    //         return;
    //     }

    //     if(res==k) {
    //         System.out.print(root.data+", ");
    //     }

    //     inOrderTraversal(root.left, k, res+1);
    //     inOrderTraversal(root.right, k, res+1);
    // } // My Solution


    static void printNodesAtDistanceK(Node root, int k) {
        if(root==null) {
            return;
        }

        if(k==0) {
            System.out.print(root.data+", ");
        }else{
            printNodesAtDistanceK(root.left, k-1);
            printNodesAtDistanceK(root.right, k-1);
        }
    }
}
