package src.Week8;

import java.util.*;

public class StringRevere {
    public static boolean check(String s)
    {
        Queue<Character> left = new LinkedList<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0 ; i < s.length(); i++)
        {
            left.offer(s.charAt(i));
            right.push(s.charAt(i));
        }
        while (!left.isEmpty() && !right.empty())
        {
            if (left.poll() != right.peek())
            {
                return false;
            }
            right.pop();
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (check(s))
        {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
