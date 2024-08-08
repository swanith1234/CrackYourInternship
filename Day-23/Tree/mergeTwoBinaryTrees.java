class Solution {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null) {
          return root2;
      }
      if (root2 == null) {
          return root1;
      }
      
      // Merge the root nodes by summing their values
      TreeNode mergedRoot = new TreeNode(root1.val + root2.val);
      
      // Recursively merge the left and right children
      mergedRoot.left = mergeTrees(root1.left, root2.left);
      mergedRoot.right = mergeTrees(root1.right, root2.right);
      
      return mergedRoot;
  }
}
