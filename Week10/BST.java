package src.Week10;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        private Node(Key key, Value val) {
            this.val = val;
            this.key = key;
        }
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int ans = key.compareTo(x.key);
            if (ans < 0) x = x.left;
            else if (ans > 0) x = x.right;
            else return x.val;
        }

        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int tmp = key.compareTo(x.key);
        if (tmp < 0) {
            x.left = put(x.left, key, val);
        } else if (tmp > 0) {
            x.right = put(x.right, key, val);
        } else if (tmp == 0) {
            x.val = val;
        }
        return x;
    }


}
