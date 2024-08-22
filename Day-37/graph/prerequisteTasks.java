import java.util.*;

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Initialize graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N];
        
        // Build the graph and fill the in-degree of each node
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int u = pair[1];
            int v = pair[0];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        
        // Initialize the queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Process the queue
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            
            // Reduce the in-degree of neighboring nodes
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If count equals N, then all nodes were processed, no cycle
        return count == N;
    }
}
