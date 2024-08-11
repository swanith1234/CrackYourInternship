class Solution {
  public static boolean isDeadEnd(Node root) {
      // Start the recursion with the entire range of positive integers
      return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
  }

  private static boolean isDeadEndUtil(Node node, int min, int max) {
      if (node == null) {
          return false;  // No node, no dead end
      }

      // Check if we have reached a leaf node
      if (node.left == null && node.right == null) {
          // If min and max converge to node's data, it's a dead end
          return min == max;
      }

      // Recur for left and right subtrees with updated ranges
      return isDeadEndUtil(node.left, min, node.data - 1) || 
             isDeadEndUtil(node.right, node.data + 1, max);
  }
}
