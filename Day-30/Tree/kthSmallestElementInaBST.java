class Solution {
  public int kthSmallest(TreeNode root, int k) {
      int[] result = new int[2]; // result[0] stores the kth smallest value, result[1] stores the count
      inorderTraversal(root, k, result);
      return result[0];
  }

  private void inorderTraversal(TreeNode node, int k, int[] result) {
      if (node == null) {
          return;
      }

      inorderTraversal(node.left, k, result);
      
      // Increment the count of nodes visited
      result[1]++;
      
      // Check if the current node is the kth smallest
      if (result[1] == k) {
          result[0] = node.val;
          return;
      }
      
      inorderTraversal(node.right, k, result);
  }
}
