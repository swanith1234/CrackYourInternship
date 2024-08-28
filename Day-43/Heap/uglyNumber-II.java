class Solution {
  public int nthUglyNumber(int n) {
      // Array to store ugly numbers
      int[] uglyNumbers = new int[n];
      uglyNumbers[0] = 1; // The first ugly number is 1

      // Initialize pointers for 2, 3, and 5
      int i2 = 0, i3 = 0, i5 = 0;

      // Initialize the next multiples of 2, 3, and 5
      int next2 = 2;
      int next3 = 3;
      int next5 = 5;

      for (int i = 1; i < n; i++) {
          // The next ugly number is the minimum of the next multiples
          int nextUgly = Math.min(next2, Math.min(next3, next5));
          uglyNumbers[i] = nextUgly;

          // Update the next value for 2, 3, or 5
          if (nextUgly == next2) {
              i2++;
              next2 = uglyNumbers[i2] * 2;
          }
          if (nextUgly == next3) {
              i3++;
              next3 = uglyNumbers[i3] * 3;
          }
          if (nextUgly == next5) {
              i5++;
              next5 = uglyNumbers[i5] * 5;
          }
      }

      // The nth ugly number
      return uglyNumbers[n - 1];
  }
}
