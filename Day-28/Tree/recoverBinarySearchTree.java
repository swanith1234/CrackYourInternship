class Solution {
  private TreeNode first = null;
  private TreeNode second = null;
  private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
      inorderTraversal(root);
      // Swap the values of the two nodes to correct the BST
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
  }

  private void inorderTraversal(TreeNode root) {
      if (root == null) return;

      inorderTraversal(root.left);

      // If this node is smaller than the previous node, it's a violation
      if (first == null && prev.val > root.val) {
          first = prev;
      }
      if (first != null && prev.val > root.val) {
          second = root;
      }

      prev = root;

      inorderTraversal(root.right);
  }
}
