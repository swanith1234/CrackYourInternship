
class Solution {
  public int evalRPN(String[] tokens) {
      Deque<Integer> stack = new LinkedList<>();
      
      for (String token : tokens) {
          if (isOperator(token)) {
              int b = stack.pop();
              int a = stack.pop();
              int result = applyOperator(a, b, token);
              stack.push(result);
          } else {
              stack.push(Integer.parseInt(token));
          }
      }
      
      return stack.pop();
  }
  
  private boolean isOperator(String token) {
      return "+-*/".contains(token);
  }
  
  private int applyOperator(int a, int b, String operator) {
      switch (operator) {
          case "+":
              return a + b;
          case "-":
              return a - b;
          case "*":
              return a * b;
          case "/":
              return a / b; // integer division
          default:
              throw new IllegalArgumentException("Invalid operator: " + operator);
      }
  }
}
