class Solution {
  public int maxDepth(TreeNode root) {
      // Base case: If the tree is empty, the depth is 0
      if (root == null) {
          return 0;
      }

      // Recursively find the depth of the left and right subtrees
      int leftDepth = maxDepth(root.left);
      int rightDepth = maxDepth(root.right);

      // The depth of the current node is 1 plus the maximum depth of its subtrees
      return Math.max(leftDepth, rightDepth) + 1;
  }
}
