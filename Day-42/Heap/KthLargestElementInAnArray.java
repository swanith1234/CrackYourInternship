import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap with capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through the array
        for (int num : nums) {
            // Add the current number to the heap
            minHeap.add(num);
            
            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
