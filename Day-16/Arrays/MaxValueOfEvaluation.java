import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int maxVal = Integer.MIN_VALUE;
        Deque<int[]> deque = new LinkedList<>();  // stores pairs [xi, yi - xi]

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove points from the deque where xi is out of the range [x - k, x]
            while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            // Calculate the current value if the deque is not empty
            if (!deque.isEmpty()) {
                maxVal = Math.max(maxVal, y + x + deque.peekFirst()[1]);
            }

            // Maintain the deque in decreasing order of (yi - xi)
            while (!deque.isEmpty() && deque.peekLast()[1] <= y - x) {
                deque.pollLast();
            }

            // Add the current point to the deque
            deque.offerLast(new int[]{x, y - x});
        }

        return maxVal;
    }
}
