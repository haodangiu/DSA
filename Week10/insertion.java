package src.Week10;

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

class insertion {


    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);


    }


 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root, int data) {
        if (root == null)
        {
            return new Node(data);
        }
        else {

            Node ans;
            if (data <= root.data) {
                ans = insert(root.left, data);
                 root.left = ans;

            }
            else  {
                ans = insert(root.right, data);
                 root.right = ans;
            }
           return root;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);


    }
}