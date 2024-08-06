
class StockSpanner {
  // Stack to store pairs of (price, span)
  private Stack<int[]> stack;

  // Constructor to initialize the stack
  public StockSpanner() {
      stack = new Stack<>();
  }

  // Method to calculate and return the span for the given price
  public int next(int price) {
      int span = 1;

      // Calculate span by popping from stack while the price at the top is less than or equal to the current price
      while (!stack.isEmpty() && stack.peek()[0] <= price) {
          span += stack.pop()[1];
      }

      // Push the current price and its span onto the stack
      stack.push(new int[]{price, span});

      // Return the span
      return span;
  }
}

/**
* Your StockSpanner object will be instantiated and called as such:
* StockSpanner obj = new StockSpanner();
* int param_1 = obj.next(price);
*/
