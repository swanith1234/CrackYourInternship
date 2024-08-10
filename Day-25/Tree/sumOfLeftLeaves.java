class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
      return sumOfLeftLeaves(root, false);
  }
  
  private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
      if (node == null) {
          return 0;
      }
      
      // Check if this node is a leaf and is a left child
      if (node.left == null && node.right == null && isLeft) {
          return node.val;
      }
      
      // Recur for left and right subtrees
      int leftSum = sumOfLeftLeaves(node.left, true);
      int rightSum = sumOfLeftLeaves(node.right, false);
      
      return leftSum + rightSum;
  }
}
