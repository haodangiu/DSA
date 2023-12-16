package src.Week4;

import java.util.Scanner;
import java.util.Stack;

public class linkList {
    Node head;

    public linkList() {
        head = null;
    }

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

    // in nguoc list
    static void printReverse(Node head) {
        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.push(head.data);
            head = head.next;
        }
        while (!st.empty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }

    //so sanh 2 list.
    static boolean compareLists(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 != null || p2 != null) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int q = sc.nextInt();
//
//        while (q != 0) {
//            linkList list1 = new linkList();
//            linkList list2 = new linkList();
//            int n = sc.nextInt();
//            while (n != 0) {
//
//                int i = sc.nextInt();
//                list1.append(i);
//
//                n--;
//            }
//            int m = sc.nextInt();
//            while (m != 0) {
//                int j = sc.nextInt();
//                list2.append(j);
//
//                m--;
//            }
//            if (compareLists(list1.head , list2.head))
//            {
//                System.out.println(1);
//            }
//            else System.out.println(0);
//
//
//            q--;
//        }
        int n = sc.nextInt();
        linkList list = new linkList();
        while (n != 0)
        {
            int tmp = sc.nextInt();
            list.append(tmp);
            n--;
        }
        list.head = reverse(list.head);
        System.out.println(list.toString());

    }

}