import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) return false;
        
        // Map each stone to a set of possible jump lengths that can land on it
        HashMap<Integer, Set<Integer>> dp = new HashMap<>();
        
        // Initialize the dp map with each stone position
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        
        // The first jump must be 1 unit
        dp.get(0).add(1);
        
        // Iterate over each stone and explore possible jumps
        for (int stone : stones) {
            Set<Integer> jumps = dp.get(stone);
            for (int jump : jumps) {
                int nextPos = stone + jump;
                
                if (nextPos == stones[stones.length - 1]) {
                    return true;  // Reached the last stone
                }
                
                if (dp.containsKey(nextPos)) {
                    // Add possible next jumps to the next stone's set
                    if (jump - 1 > 0) {
                        dp.get(nextPos).add(jump - 1);
                    }
                    dp.get(nextPos).add(jump);
                    dp.get(nextPos).add(jump + 1);
                }
            }
        }
        
        // If we reach here, we haven't found a way to reach the last stone
        return false;
    }
}
