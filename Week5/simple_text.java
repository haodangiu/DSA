package src.Week5;

import java.util.Scanner;
import java.util.Stack;

public class simple_text {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<Integer> key = new Stack<>();
        Stack<String> val = new Stack<>();
        StringBuilder s1 = new StringBuilder();
        while (q != 0) {
            int n = sc.nextInt();
            if (n == 1) {
                String w = sc.nextLine().trim();
                s1.append(w);
                s1.trimToSize();
                key.push(n);
                val.push(w);

            } else if (n == 2) {
                int k = sc.nextInt();
                key.push(n);
                String dele = s1.substring(s1.length() - k, s1.length());
                val.push(dele);
                //s1 = new StringBuilder(s1.toString().replace(dele, "").trim());
//                s1.delete(s1.length() - k, s1.length()).trimToSize();
                s1 = new StringBuilder(s1.toString().replace(dele, "").trim());
                //System.out.println(s1);

            } else if (n == 3) {
                int pos = sc.nextInt();
                System.out.println(s1.charAt(pos-1));
            } else if (n == 4) {
                if (key.peek() == 2) {
                    s1.append(val.peek()).trimToSize();
                } else if (key.peek() == 1) {
                    int start = s1.indexOf(val.peek());
                    s1.delete(start, start + val.peek().length()).trimToSize();
                }
                key.pop();
                val.pop();

            }
//            System.out.println(s1);
//            System.out.println(s1.length());

            q--;

        }
    }
}
