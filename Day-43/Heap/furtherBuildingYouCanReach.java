
class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
      // Min-heap to track the largest jumps we've used bricks on
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      
      for (int i = 0; i < heights.length - 1; i++) {
          int diff = heights[i + 1] - heights[i];
          
          // If there is a positive difference, we need to climb up
          if (diff > 0) {
              minHeap.add(diff);
              
              // If the size of the heap exceeds the number of ladders, use bricks
              if (minHeap.size() > ladders) {
                  bricks -= minHeap.poll();
              }
              
              // If bricks become negative, we can't go further
              if (bricks < 0) {
                  return i;
              }
          }
      }
      
      // If we never run out of bricks, we can reach the last building
      return heights.length - 1;
  }
}
