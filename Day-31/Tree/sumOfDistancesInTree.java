import java.util.*;

class Solution {
    int[] subtreeSize, distSum, result;
    List<Set<Integer>> tree;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        subtreeSize = new int[n];
        distSum = new int[n];
        result = new int[n];
        
        // First DFS to calculate distSum and subtreeSize
        dfs1(0, -1);
        
        // Second DFS to calculate the result for all nodes
        dfs2(0, -1);
        
        return result;
    }
    
    private void dfs1(int node, int parent) {
        subtreeSize[node] = 1; // Count the node itself
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;
            dfs1(neighbor, node);
            subtreeSize[node] += subtreeSize[neighbor];
            distSum[node] += distSum[neighbor] + subtreeSize[neighbor];
        }
    }
    
    private void dfs2(int node, int parent) {
        result[node] = distSum[node];
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;
            // Move root from `node` to `neighbor`
            distSum[neighbor] = distSum[node] - subtreeSize[neighbor] + (n - subtreeSize[neighbor]);
            dfs2(neighbor, node);
        }
    }
}
