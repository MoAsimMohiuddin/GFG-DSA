class Node{
    int data;
    Node left;
    Node right;

    Node(int key) {
        this.data=key;
    }
}

public class Trees_1_ImplementationOfTrees {
   public static void main(String[] args) {
    Node root=null;

    Node n1=new Node(10);
    Node n2=new Node(20);
    Node n3=new Node(30);
    Node n4=new Node(40);

    root=n1;

    n1.left=n2;
    n1.right=n3;
    n2.left=n4;

    System.out.println(heightOfTree(root));
   }

   static void preOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
    
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
   static void inOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
    
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
   static void postOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
    
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    static int heightOfTree(Node root) {
        if(root==null) {
            return 0;
        }

        return Math.max(heightOfTree(root.left), heightOfTree(root.right))+1;
    }
}

/*
Traversals of Trees: There are mainly two types of Traversals in trees, 1) Breadth First Traversal, 2) Depth First Traversal.
Breadth First Traversal is basically traversing each node on each level of the tree one by one.

Depth First Traversal is traversing the left subtree first, Then the right Subtree. It is mainly divided into three types.
i) Inorder,
ii) Pre Order,
iii) Post Order.
In inorder traversal, For every subtree, We print the left child first, Then the root then the right child.
In preorder traversal, For every subtree, We print the root first, Then the left child then the right child.
In postorder traversal, For every subtree, We print the left child first, Then the right child then the root.
*/