package src.Week9;

import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal {
    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            System.out.print(q.peek().data + " ");
            Node temp =q.poll();
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }



    }
}
