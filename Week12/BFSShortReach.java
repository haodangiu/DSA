package src.Week12;

import java.util.*;

public class BFSShortReach {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        Integer[] distance = new Integer[n];
        --s;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(s);

        List<List<Integer>> newEdges = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            newEdges.add(new ArrayList<Integer>());
            distance[i] = -1;
        }
        distance[s] = 0;

        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            newEdges.get(u).add(v);
            newEdges.get(v).add(u);
        }

        while (!bfs.isEmpty()) {
            int u = bfs.remove();

            List<Integer> edge = newEdges.get(u);
            for (int v : edge) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 6;
                    bfs.add(v);
                }
            }
        }

        List<Integer> result = new ArrayList<>(Arrays.asList(distance));
        result.remove(Integer.valueOf(0));
        return result;
    }
}