
class Solution {
  public List<TreeNode> generateTrees(int n) {
      if (n == 0) return new ArrayList<>();
      return generateTrees(1, n);
  }
  
  private List<TreeNode> generateTrees(int start, int end) {
      List<TreeNode> allTrees = new ArrayList<>();
      if (start > end) {
          allTrees.add(null);  // Base case: return null tree when start > end
          return allTrees;
      }

      // Try every number from start to end as the root
      for (int i = start; i <= end; i++) {
          // Generate all left and right subtrees recursively
          List<TreeNode> leftTrees = generateTrees(start, i - 1);
          List<TreeNode> rightTrees = generateTrees(i + 1, end);

          // Combine each left and right subtree with the current root `i`
          for (TreeNode left : leftTrees) {
              for (TreeNode right : rightTrees) {
                  TreeNode currentTree = new TreeNode(i);
                  currentTree.left = left;
                  currentTree.right = right;
                  allTrees.add(currentTree);
              }
          }
      }

      return allTrees;
  }
}