class Tree {
    
  // Helper method to perform inorder traversal and store the node values
  private void inorderTraversal(Node root, List<Integer> nodeList) {
      if (root == null) {
          return;
      }
      inorderTraversal(root.left, nodeList);
      nodeList.add(root.data);
      inorderTraversal(root.right, nodeList);
  }
  
  public float findMedian(Node root) {
      List<Integer> nodeList = new ArrayList<>();
      inorderTraversal(root, nodeList);
      
      int n = nodeList.size();
      if (n % 2 != 0) {
          // If odd, return the middle element
          return nodeList.get(n / 2);
      } else {
          // If even, return the average of the two middle elements
          int mid1 = n / 2 - 1;
          int mid2 = n / 2;
          return (nodeList.get(mid1) + nodeList.get(mid2)) / 2.0f;
      }
  }
}
