package src.Week4;

import java.util.Scanner;

public class linkList {
    static Node head = null;
    class Node {
        int data;
        Node next;
        public Node(int data, linkList.Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void append(int data) {
        head = append(data, head);
    }

    // in danh sich lien ket theo dang de quy
    public String toString() {
        return toString(head);
    }
    private String toString(Node node) {
        if (node == null) return "";
        return node.data + " " + toString(node.next);
    }

    //them vao cuoi linklist
    private Node append(int data, Node node) {
        if (node == null) return new Node(data, null);
        node.next = append(data, node.next);
        return node;
    }

    //them vao dau linklist
    public void addFirst(int data) {
        Node p = new Node(data, head);
        p.next = head;
        head = p;
    }
    //xoa 1 node o vi tri pos

    public void reMove(int pos) {
        Node p = head;
        if (pos == 0) {
            p = p.next;
            head = p;
        } else {

            int cnt = 0;
            while (cnt < pos - 1) {
                p = p.next;
                cnt++;

            }
            p.next = p.next.next;
        }

    }

    //   insert 1 node moi vao vitri pos
    public void insert(int pos, int data) {
        if (pos == 0) addFirst(data);
        Node p = head;
        int cnt = 0;
        Node newN = new Node(data, null);

        while (cnt < pos - 1) {
            p = p.next;
            cnt++;

        }
        newN.next = p.next;
        p.next = newN;
    }

    //dao nguoc list

    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t != 0) {
            linkList list = new linkList();
            int n = input.nextInt();
            while (n != 0) {
                int tmp = input.nextInt();
                list.append(tmp);
                n--;
            }
            head = reverse(head);
            System.out.print(list);

            t--;
        }
    }
}