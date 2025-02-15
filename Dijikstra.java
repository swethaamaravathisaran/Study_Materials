import java.util.*;

class Dijkstra {
    static class Pair {
        int vertex, weight;
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int n, List<Pair>[] graph, int src) {
        // Step 1: Initialize distance array and priority queue
        int[] dist = new int[n];  
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(src, 0));

        // Step 2: Dijkstra’s Algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.vertex;
            int d = current.weight;

            if (d > dist[node]) continue;  // Skip outdated entries

            for (Pair neighbor : graph[node]) {
                int newDist = d + neighbor.weight;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Pair(neighbor.vertex, newDist));
                }
            }
        }

        return dist; // Returns shortest distances from src to all nodes
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 3: Add edges (u → v, weight)
        graph[0].add(new Pair(1, 2));
        graph[0].add(new Pair(2, 4));
        graph[1].add(new Pair(2, 1));
        graph[1].add(new Pair(3, 7));
        graph[2].add(new Pair(4, 3));
        graph[3].add(new Pair(4, 1));

        int src = 0; // Source node
        int[] distances = dijkstra(n, graph, src);

        // Step 4: Print shortest distances
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " -> " + (distances[i] == Integer.MAX_VALUE ? "∞" : distances[i]));
        }
    }
}
