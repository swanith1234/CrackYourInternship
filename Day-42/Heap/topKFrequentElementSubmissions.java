
class Solution {
  public int[] topKFrequent(int[] nums, int k) {
      // Step 1: Count frequencies of each number
      Map<Integer, Integer> frequencyMap = new HashMap<>();
      for (int num : nums) {
          frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
      }
      
      // Step 2: Use a min-heap to keep track of the top k elements
      PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
          new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
      
      for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
          minHeap.add(entry);
          if (minHeap.size() > k) {
              minHeap.poll();
          }
      }
      
      // Step 3: Extract elements from the heap
      int[] topK = new int[k];
      for (int i = 0; i < k; i++) {
          topK[i] = minHeap.poll().getKey();
      }
      
      return topK;
  }
}
