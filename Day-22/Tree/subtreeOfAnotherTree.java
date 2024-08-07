/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) {
          return false;
      }
      // Check if the tree rooted at the current node is the same as subRoot
      if (isSameTree(root, subRoot)) {
          return true;
      }
      // Otherwise, check the left and right subtrees
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
  
  private boolean isSameTree(TreeNode s, TreeNode t) {
      if (s == null && t == null) {
          return true;
      }
      if (s == null || t == null) {
          return false;
      }
      // Check if the current nodes are the same and recurse for children
      return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
  }
}
