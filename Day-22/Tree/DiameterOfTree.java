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
  private int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
      depth(root);
      return diameter;
  }

  private int depth(TreeNode node) {
      if (node == null) {
          return 0;
      }
      int leftDepth = depth(node.left);
      int rightDepth = depth(node.right);

      // The diameter through the current node
      diameter = Math.max(diameter, leftDepth + rightDepth);

      // Return the depth of the current node
      return Math.max(leftDepth, rightDepth) + 1;
  }
}
