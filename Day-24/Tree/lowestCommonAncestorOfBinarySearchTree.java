/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // Start from the root node of the tree
      TreeNode currentNode = root;
      
      while (currentNode != null) {
          if (p.val < currentNode.val && q.val < currentNode.val) {
              // If both p and q are lesser than the current node, move to the left child
              currentNode = currentNode.left;
          } else if (p.val > currentNode.val && q.val > currentNode.val) {
              // If both p and q are greater than the current node, move to the right child
              currentNode = currentNode.right;
          } else {
              // We have found the split point, i.e., the LCA node
              return currentNode;
          }
      }
      
      return null; // This should never be reached if p and q are guaranteed to be in the tree
  }
}
