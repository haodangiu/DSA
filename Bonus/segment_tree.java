package src.Bonus;

import java.util.Scanner;

public class segment_tree {
    public static int[] a = new int[3000000];
    public static int[] t = new int[3000000];

    public static void build(int l, int r, int id) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.max(t[2 * id], t[2 * id + 1]);
    }

    public static int query(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MIN_VALUE;
        if (u <= l && r <= v) return t[id];
        int mid = (l + r) / 2;
        int left = query(l, mid, 2 * id, u, v);
        int right = query(mid + 1, r, 2 * id + 1, u, v);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        build(1, n, 1);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
//            if (u == v) {
//                System.out.println(t[u]);
//            } else {
            int result = query(1, n, 1, u, v);
            System.out.println(result);
            //  }
        }

        sc.close();
    }

}
