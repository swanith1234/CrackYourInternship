class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
      // Base cases
      if (p == null && q == null) {
          return true; // Both trees are empty
      }
      if (p == null || q == null) {
          return false; // One tree is empty, and the other is not
      }
      if (p.val != q.val) {
          return false; // The values of the current nodes differ
      }

      // Recursively check the left and right subtrees
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
