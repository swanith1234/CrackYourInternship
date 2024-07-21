class Solution {
  public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) {
          return 0;
      }

      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

      for (int price : prices) {
          if (price < minPrice) {
              minPrice = price;  // Update the minimum price
          } else {
              int profit = price - minPrice;  // Calculate profit
              if (profit > maxProfit) {
                  maxProfit = profit;  // Update the maximum profit
              }
          }
      }

      return maxProfit;
  }
}
