package src.Week5;

import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class balanced_brackets {

    public static String check(String s) {

        int top = 0;
        char[] st = new char[1000];
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st[++top] = s.charAt(i);
            } else {
                if (top == 0) return "NO";
                else {
                    if ((st[top] == '(' && s.charAt(i) == ')') ||  (st[top] == '[' && s.charAt(i) == ']') || ( st[top] == '{' && s.charAt(i) == '}')) {
                        --top;
                    } else return "NO";
                }
            }

        }
        if ( top != 0) return "NO";
        return "YES";
    }

        public static void main (String[]args){
            Scanner input = new Scanner(System.in);

//            int n = input.nextInt();
//            while (n != 0) {
                String s =input.nextLine();
                //n--;
               System.out.println(check(s));

          //  }

        }

}
