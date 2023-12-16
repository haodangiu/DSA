package src.Week13;

import java.io.*;
import java.util.*;
public class Dijkstra {
    private static void init(int[] weight, boolean[] visited, int n) {
        for (int i = 0; i < n; ++i) {
            visited[i] = false;
            weight[i] = Integer.MAX_VALUE;
        }
    }

    public static int[] dijkstra(int n, List<List<edge>> edges, int start) {
        // Write your code here
        boolean[] visited = new boolean[n];
        int[] weight = new int[n];
        init(weight, visited, n);
        weight[start] = 0;

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(start, 0));

        while (!pq.isEmpty()) {
            edge minEdge = pq.remove();
            if(visited[minEdge.v]) {
                continue;
            }
            start = minEdge.v;
            visited[start] = true;

            for (edge tmp : edges.get(start)) {
                int v = tmp.v;
                int w = tmp.w;
                if(weight[v] > weight[start] + w) {
                    weight[v] = weight[start] + w;
                    pq.add(new edge(v, weight[v]));
                }
            }
        }

        return weight;
    }

    private static void initEdges(int n, List<List<edge>> edges) {
        for (int i = 0; i < n; ++i) {
            edges.add(new ArrayList<edge>());
        }
    }

    private static void inputEdges(int m, List<List<edge>> edges, Scanner scanner) {
        for (int i = 0; i < m; ++i) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            edges.get(u).add(new edge(v, w));
            edges.get(v).add(new edge(u, w));
        }
    }

    private static void solution(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<edge>> edges = new ArrayList<>();
        initEdges(n, edges);
        inputEdges(m, edges, scanner);

        int start = scanner.nextInt() - 1;

        int[] weight = dijkstra(n, edges, start);

        for(int i = 0; i < n; ++i) {
            if(i == start) continue;
            if(weight[i] == Integer.MAX_VALUE) {
                weight[i] = -1;
            }
            System.out.printf("%d ", weight[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t > 0) {
            solution(scanner);
            --t;
        }
    }
}

class edge implements Comparable<edge> {
    int v;
    int w;

    public edge() {
    }

    public edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(edge tmp) {
        if (w < tmp.w) {
            return -1;
        }
        if (w > tmp.w) {
            return 1;
        }
        if (v < tmp.v) {
            return -1;
        }
        if (v > tmp.v) {
            return 1;
        }
        return 0;
    }
}