class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
      // Base case: if the tree is empty
      if (root == null) {
          return false;
      }
      
      // Check if we are at a leaf node
      if (root.left == null && root.right == null) {
          return root.val == targetSum;
      }
      
      // Recursive case: check the left and right subtrees with updated targetSum
      targetSum -= root.val;
      return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
  }
}
