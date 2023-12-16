package src.Bonus;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class vebo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt= 0;
        while ( n != 0)
        {
            int type = sc.nextInt();
            if (type == 1)
            {
                int temp = sc.nextInt();
                pq.offer(temp);
                cnt ++;

            }
            if (type == 2)
            {
                int a = sc.nextInt();
                int i = 1;
                while (  i < a)
                {

                    i++;
                }
            }
            n--;
        }
    }
}
