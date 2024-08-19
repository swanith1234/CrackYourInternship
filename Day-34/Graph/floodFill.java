class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      int originalColor = image[sr][sc];
      
      // If the original color is the same as the new color, no changes are needed.
      if (originalColor != newColor) {
          fill(image, sr, sc, originalColor, newColor);
      }
      
      return image;
  }
  
  private void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {
      // Check if the current position is within the bounds of the image.
      if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
          return;
      }
      
      // If the color of the current pixel is not the original color, stop the recursion.
      if (image[sr][sc] != originalColor) {
          return;
      }
      
      // Change the color of the current pixel.
      image[sr][sc] = newColor;
      
      // Recursively apply the same operation to all 4-directional neighbors.
      fill(image, sr + 1, sc, originalColor, newColor); // Down
      fill(image, sr - 1, sc, originalColor, newColor); // Up
      fill(image, sr, sc + 1, originalColor, newColor); // Right
      fill(image, sr, sc - 1, originalColor, newColor); // Left
  }
}
