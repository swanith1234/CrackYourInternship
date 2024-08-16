class Solution {
  private int maxSum;

  public int maxPathSum(TreeNode root) {
      maxSum = Integer.MIN_VALUE;
      maxGain(root);
      return maxSum;
  }

  private int maxGain(TreeNode node) {
      if (node == null) {
          return 0;
      }

      // Recursively get the maximum gain from the left and right subtrees
      int leftGain = Math.max(maxGain(node.left), 0); // if negative, consider as 0
      int rightGain = Math.max(maxGain(node.right), 0); // if negative, consider as 0

      // Calculate the price to start a new path where the current node is the highest node
      int priceNewPath = node.val + leftGain + rightGain;

      // Update the maxSum if the priceNewPath is larger
      maxSum = Math.max(maxSum, priceNewPath);

      // For recursion, return the max gain if we continue the same path
      return node.val + Math.max(leftGain, rightGain);
  }
}
