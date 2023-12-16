package src.Week10;

public class LCA {
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if (root.data == v1 || root.data == v2) {
            return root;
        }
        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);
        if (min < root.data && root.data < max) {
            return root;
        }
        if (max < root.data) {
            return lca(root.left, v1, v2);
        }
        return lca(root.right, v1, v2);
    }
}
