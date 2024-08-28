import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Min-heap that stores elements as (value, row, col)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initialize the heap with the first element of each row
        for (int r = 0; r < n; r++) {
            minHeap.offer(new int[] { matrix[r][0], r, 0 });
        }
        
        // Remove elements from the heap k times
        for (int i = 0; i < k - 1; i++) {
            int[] smallest = minHeap.poll();
            int row = smallest[1], col = smallest[2];
            
            // If there is a next element in the same row, add it to the heap
            if (col + 1 < n) {
                minHeap.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }
        
        // The root of the heap is now the kth smallest element
        return minHeap.poll()[0];
    }
}
