import java.util.*;

class Solution {
    private int n;
    private int[][] grid;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int largestIsland(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        
        int islandId = 2;  // Start island ids from 2
        Map<Integer, Integer> areaMap = new HashMap<>();
        
        // Step 1: Label each island with a unique id and calculate its area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }
        
        // Step 2: Check potential merges and calculate the maximum island area
        int maxArea = areaMap.values().stream().max(Integer::compare).orElse(0);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int area = 1;  // Changing this 0 to 1 adds 1 area
                    for (int[] dir : directions) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            int island = grid[x][y];
                            if (!seenIslands.contains(island)) {
                                area += areaMap.get(island);
                                seenIslands.add(island);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int i, int j, int islandId) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int area = 1;
        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            area += dfs(x, y, islandId);
        }
        return area;
    }
}
