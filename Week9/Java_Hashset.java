package src.Week9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java_Hashset {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while ( n != 0)
        {
            String s = sc.nextLine();
            set.add(s);
            System.out.println(set.size());
            n--;
        }

    }
}
