import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max Heap to store fuel amounts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int fuel = startFuel; // Current fuel
        int res = 0;          // Number of refueling stops
        int i = 0;            // Index for stations
        
        while (fuel < target) {
            // Add all reachable stations' fuel to maxHeap
            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }
            
            // If no stations are available to refuel and target not reached
            if (maxHeap.isEmpty()) return -1;
            
            // Refuel with the station that has the maximum fuel
            fuel += maxHeap.poll();
            res++;
        }
        
        return res;
    }
}
