class Solution {
  private int index = 0;

  Node constructTree(int n, int pre[], char preLN[]) {
      if (index >= n) {
          return null;
      }
      
      // Create a new node with the current index's value
      Node node = new Node(pre[index]);
      
      // If it's a leaf node, return the node as it has no children
      if (preLN[index] == 'L') {
          index++;
          return node;
      }
      
      // If it's a non-leaf node, move to the next index and recursively construct left and right children
      index++;
      node.left = constructTree(n, pre, preLN);
      node.right = constructTree(n, pre, preLN);
      
      return node;
  }
}
