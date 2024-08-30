
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        // Step 1: Create an array of workers with their quality, wage, and ratio
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        // Step 2: Sort workers by their ratio (wage[i] / quality[i])
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio(), b.ratio()));
        
        // Step 3: Use a max heap to keep track of the smallest k qualities
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        
        // Step 4: Iterate through the workers
        for (Worker worker : workers) {
            maxHeap.add(worker.quality);
            totalQuality += worker.quality;
            
            // If we have more than k workers, remove the one with the highest quality
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            // If we have exactly k workers, calculate the cost and update minCost
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * worker.ratio());
            }
        }
        
        return minCost;
    }
}

class Worker {
    int quality;
    int wage;
    
    Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }
    
    double ratio() {
        return (double) wage / quality;
    }
}
