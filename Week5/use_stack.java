package src.Week5;

import java.util.Scanner;

public class use_stack {
    public static int[] a = new int[10000];
    public static int tail;
    public static int head;

    public static void enqueue(int n) {
        a[tail++] = n;


    }

    public static void dequeue() {
        head++;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        head = 0;
        tail = 0;
        while (q != 0) {
            int t = sc.nextInt();
            if (t == 1) {
                int n = sc.nextInt();
                enqueue(n);
                if (head == 0) {
                    head = 1;
                }
            } else if (t == 2) {
                dequeue();
            } else if (t == 3) {
                System.out.println(a[head - 1]);
            }
            q--;
        }
    }
}
