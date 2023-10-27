package src.Week8;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class Jesse_and_cookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        Queue pqueue = new PriorityQueue(N);
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }
       


        while (pqueue.size() != 0) {
            System.out.println(pqueue.remove());
        }
    }

}
