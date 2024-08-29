import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap to store the k closest points
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );
        
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
            } else if (distance < maxHeap.peek()[0] * maxHeap.peek()[0] + maxHeap.peek()[1] * maxHeap.peek()[1]) {
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }
        
        // Extract the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}
