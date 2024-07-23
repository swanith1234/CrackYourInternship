public class Solution {
  public int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;
      int totalSum = 0;
      
      // Calculate the total sum of the cardPoints array
      for (int point : cardPoints) {
          totalSum += point;
      }
      
      // Edge case: if k is equal to the length of the array, return the total sum
      if (k == n) {
          return totalSum;
      }
      
      // Calculate the sum of the first (n - k) cards
      int windowSum = 0;
      for (int i = 0; i < n - k; i++) {
          windowSum += cardPoints[i];
      }
      
      int minWindowSum = windowSum;
      
      // Slide the window over the array
      for (int i = n - k; i < n; i++) {
          windowSum += cardPoints[i] - cardPoints[i - (n - k)];
          minWindowSum = Math.min(minWindowSum, windowSum);
      }
      
      // The maximum score is totalSum minus the minimum window sum
      return totalSum - minWindowSum;
  }
}
