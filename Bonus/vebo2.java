package src.Bonus;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class vebo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Long> pqMax = new PriorityQueue<>();
        int i = 0;
        long sum = 0;
        while (n != 0) {
            long tmp = sc.nextInt();
            pqMax.add(tmp);
            sum += tmp;
            if (pqMax.size() > k) {
                sum -= pqMax.poll();
            }

            System.out.print(sum + " ");
            n--;

        }
    }

}
