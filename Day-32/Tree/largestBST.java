class Solution{
    
  // Helper class to store information about each subtree
  static class BSTInfo {
      boolean isBST;
      int size;
      int min;
      int max;
      
      BSTInfo(boolean isBST, int size, int min, int max) {
          this.isBST = isBST;
          this.size = size;
          this.min = min;
          this.max = max;
      }
  }
  
  public static int largestBst(Node root) {
      return largestBSTHelper(root).size;
  }
  
  private static BSTInfo largestBSTHelper(Node node) {
      // Base case: if the node is null, it's a BST of size 0
      if (node == null) {
          return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
      }
      
      // Recursively check the left and right subtrees
      BSTInfo leftInfo = largestBSTHelper(node.left);
      BSTInfo rightInfo = largestBSTHelper(node.right);
      
      // Current node's min and max
      int minValue = Math.min(node.data, leftInfo.min);
      int maxValue = Math.max(node.data, rightInfo.max);
      
      // Check if the current subtree is a BST
      if (leftInfo.isBST && rightInfo.isBST && node.data > leftInfo.max && node.data < rightInfo.min) {
          int currentSize = leftInfo.size + rightInfo.size + 1;
          return new BSTInfo(true, currentSize, minValue, maxValue);
      } else {
          // If it's not a BST, return the size of the largest BST found so far
          return new BSTInfo(false, Math.max(leftInfo.size, rightInfo.size), minValue, maxValue);
      }
  }
}
