import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create a DP table to store the minimum cost to reach each city with at most i stops.
        int[][] dp = new int[k + 2][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][src] = 0;

        // Update the DP table for each level of stops.
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (dp[i - 1][u] != Integer.MAX_VALUE) {
                    dp[i][v] = Math.min(dp[i][v], dp[i - 1][u] + w);
                }
            }
        }

        // Find the minimum cost to reach the destination with at most k stops.
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= k + 1; i++) {
            minCost = Math.min(minCost, dp[i][dst]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
