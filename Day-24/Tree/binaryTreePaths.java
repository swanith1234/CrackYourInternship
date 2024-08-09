class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
      List<String> paths = new ArrayList<>();
      if (root == null) {
          return paths;
      }
      // Start the DFS from the root node
      dfs(root, "", paths);
      return paths;
  }
  
  private void dfs(TreeNode node, String path, List<String> paths) {
      if (node == null) {
          return;
      }
      
      // Append the current node's value to the path
      path += node.val;
      
      // If it's a leaf node, add the path to the list of paths
      if (node.left == null && node.right == null) {
          paths.add(path);
      } else {
          // If not a leaf, continue the DFS on the left and right children
          path += "->";
          dfs(node.left, path, paths);
          dfs(node.right, path, paths);
      }
  }
}
