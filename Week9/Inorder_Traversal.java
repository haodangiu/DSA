package src.Week9;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Inorder_traversal {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    /**
     * duyet trung vi . duyet tu node tren trai -> duyet goc -> duyet node ben phai
     * @param root goc
     */
    public static void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }



    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }
}