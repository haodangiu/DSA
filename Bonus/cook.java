package src.Bonus;

import java.util.Scanner;

public class cook {
    public int[] arr;
    public int sz;

    public cook(int n) {
        arr = new int[n];
        sz = 0;
    }

    public void enQueue(int val) {
        arr[sz] = val;
        sz++;
        int temp = sz - 1;
        int cha = (temp - 1) / 2;
        while (temp > 0 && arr[temp] < arr[cha]) {
            swap(temp, cha);
            temp = cha;
            cha = (temp - 1) / 2;

        }

    }

    public int deQueue() {
        int minVal = arr[0];
        arr[0] = arr[sz - 1];
        sz--;
        con(0);
        return minVal;
    }

    public void con(int id) {
        int left = 2 * id + 1;
        int right = 2 + 2 * id;
        int root = id;
        if (left < sz && arr[left] < arr[root]) {
            root = left;
        }
        if (right < sz && arr[right] < arr[root]) {
            root = right;
        }
        if (root != id) {
            swap(id, root);
            con((root));
        }

    }

    public boolean empty() {
        return sz == 0;
    }

    public void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public int count(int k) {
        int cnt = 0;
        while (!empty() && arr[0] < k) {
            int a1 = deQueue();
            if (!empty()) {
                int a2 = deQueue();
                int newNode = a1 + a2 * 2;
                enQueue(newNode);
            }
            cnt++;
        }
        if (arr[0] < k) return -1;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        cook pq = new cook(n);
        while (n != 0) {
            int i = sc.nextInt();
            pq.enQueue(i);
            n--;
        }
        int cnt = pq.count(k);
        System.out.println(cnt);


    }
}

