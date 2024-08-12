
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
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
          return result;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int levelSize = queue.size();
          TreeNode rightmostNode = null;
          
          for (int i = 0; i < levelSize; i++) {
              TreeNode currentNode = queue.poll();
              rightmostNode = currentNode; // Keep updating rightmostNode to the last node of this level
              
              if (currentNode.left != null) {
                  queue.offer(currentNode.left);
              }
              if (currentNode.right != null) {
                  queue.offer(currentNode.right);
              }
          }
          
          // The rightmostNode at this level is the one we can see from the right side
          result.add(rightmostNode.val);
      }
      
      return result;
  }
}
