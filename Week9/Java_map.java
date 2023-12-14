package src.Week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Java_map {
    public static void main(String[] args) {
        Map<String, String> people = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n != 0) {
            String name = sc.nextLine();
            String tmp = sc.nextLine();
            people.put(name, tmp);

            n--;
        }
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            if (people.containsKey(s)) System.out.println(s + "=" + people.get(s));
            else System.out.println("Not found");
        }
    }
}
