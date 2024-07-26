class Solution {
  public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
      int currentNumber = 0;
      char operation = '+';
      s = s.replaceAll("\\s+", "");  // Remove all spaces from the string

      for (int i = 0; i < s.length(); i++) {
          char currentChar = s.charAt(i);

          if (Character.isDigit(currentChar)) {
              currentNumber = currentNumber * 10 + (currentChar - '0');
          }

          if (!Character.isDigit(currentChar) || i == s.length() - 1) {
              if (operation == '+') {
                  stack.push(currentNumber);
              } else if (operation == '-') {
                  stack.push(-currentNumber);
              } else if (operation == '*') {
                  stack.push(stack.pop() * currentNumber);
              } else if (operation == '/') {
                  stack.push(stack.pop() / currentNumber);
              }

              operation = currentChar;
              currentNumber = 0;
          }
      }

      int result = 0;
      while (!stack.isEmpty()) {
          result += stack.pop();
      }

      return result;
  }}