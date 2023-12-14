package src.Week5;

import java.util.Scanner;

public class simple_text {
    public static int[] st = new int[100000];
    public static char[] s = new char[100000];
    public static int sz;
    public static int top;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        top = 0;
        sz = 0;
        while (q != 0)
        {
            int n = sc.nextInt();
            if (n == 1)
            {
                String w = sc.nextLine();
                st[top++] = n;
                for (int i = 0 ; i < w.length() ; i++)
                {
                    s[sz++] = w.charAt(i);
                }


            }
            q--;
        }
    }
}
