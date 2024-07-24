class Solution {
  public String intToRoman(int num) {
      // Define the Roman numerals and their values
      int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
      
      StringBuilder result = new StringBuilder();
      
      // Iterate through the values and symbols
      for (int i = 0; i < values.length && num > 0; i++) {
          // Append the symbol while the value can be subtracted from num
          while (num >= values[i]) {
              num -= values[i];
              result.append(symbols[i]);
          }
      }
      
      return result.toString();
  }
}
