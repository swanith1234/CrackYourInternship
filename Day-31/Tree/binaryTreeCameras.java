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
  private static final int NOT_COVERED = 0;
  private static final int COVERED_NO_CAMERA = 1;
  private static final int HAS_CAMERA = 2;
  
  private int cameras = 0;
  
  public int minCameraCover(TreeNode root) {
      if (dfs(root) == NOT_COVERED) {
          cameras++; // If root is not covered, place a camera at the root
      }
      return cameras;
  }
  
  private int dfs(TreeNode node) {
      if (node == null) {
          return COVERED_NO_CAMERA; // Null nodes are considered covered
      }
      
      int left = dfs(node.left);
      int right = dfs(node.right);
      
      if (left == NOT_COVERED || right == NOT_COVERED) {
          cameras++;
          return HAS_CAMERA; // Place a camera at the current node
      }
      
      if (left == HAS_CAMERA || right == HAS_CAMERA) {
          return COVERED_NO_CAMERA; // This node is covered by a camera in one of its children
      }
      
      return NOT_COVERED; // This node is not covered and doesn't have a camera
  }
}
