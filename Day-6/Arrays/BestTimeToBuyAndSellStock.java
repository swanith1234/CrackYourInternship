class Solution {
  public int maxProfit(int[] prices) {
      int maxProfit = 0;
      
      // Traverse through the prices array
      for (int i = 1; i < prices.length; i++) {
          // If today's price is greater than yesterday's price
          if (prices[i] > prices[i - 1]) {
              // Add the difference to maxProfit
              maxProfit += prices[i] - prices[i - 1];
          }
      }
      
      return maxProfit;
  }
}
