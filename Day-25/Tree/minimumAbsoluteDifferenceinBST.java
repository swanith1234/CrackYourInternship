
class Solution {
  private List<Integer> values = new ArrayList<>();
  
  public int getMinimumDifference(TreeNode root) {
      // Perform in-order traversal and collect node values
      inOrderTraversal(root);
      
      // Find minimum difference between consecutive values
      int minDiff = Integer.MAX_VALUE;
      for (int i = 1; i < values.size(); i++) {
          minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
      }
      
      return minDiff;
  }
  
  private void inOrderTraversal(TreeNode node) {
      if (node == null) {
          return;
      }
      // Traverse left subtree
      inOrderTraversal(node.left);
      // Visit current node
      values.add(node.val);
      // Traverse right subtree
      inOrderTraversal(node.right);
  }
}
