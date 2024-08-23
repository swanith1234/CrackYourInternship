import java.util.*;

class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        int[] topoOrder = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 2: Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int index = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topoOrder[index++] = vertex;

            // Decrease the in-degree of all neighbors
            for (int neighbor : adj.get(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Return the topological order
        return topoOrder;
    }
}
