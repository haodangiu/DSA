package src.Week10;

public class checkBST {

    int findMin(Node root) {
        if (root == null) {
            return 10000;
        }
        return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
    }

    int findMax(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && findMax(root.left) >= root.data) {
            return false;
        }
        if (root.right != null && root.data >= findMin(root.right)) {
            return false;
        }
        return (checkBST(root.left) && checkBST(root.right));
    }

}
