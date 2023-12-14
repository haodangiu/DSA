package src.Week10;

public class checkBST {

  public static int[] a = new int[10000];
    public static int sz = 0;
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        a[++sz]=root.data;
        inOrder(root.right);
    }

    boolean checkBST(Node root) {
        inOrder(root);
        for (int i = 1 ; i <= sz -1 ; i++)
        {
            if (a[i] <= a[i-1]) return false;
        }
        return true;
    }
}
