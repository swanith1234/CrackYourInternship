class Solution {
  // Function to find the in-order successor and predecessor of a given key
  public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
      // Initialize predecessor and successor
      pre[0] = null;
      suc[0] = null;
      
      // Helper function to find predecessor and successor
      findPreSucUtil(root, pre, suc, key);
  }
  
  private static void findPreSucUtil(Node node, Node[] pre, Node[] suc, int key) {
      if (node == null) {
          return;
      }
      
      // If key is less than current node's data, go to the left subtree
      if (key < node.data) {
          suc[0] = node; // Possible successor
          findPreSucUtil(node.left, pre, suc, key);
      }
      // If key is greater than current node's data, go to the right subtree
      else if (key > node.data) {
          pre[0] = node; // Possible predecessor
          findPreSucUtil(node.right, pre, suc, key);
      }
      // If key is equal to current node's data
      else {
          // The predecessor is the maximum value in the left subtree
          if (node.left != null) {
              Node temp = node.left;
              while (temp.right != null) {
                  temp = temp.right;
              }
              pre[0] = temp;
          }
          
          // The successor is the minimum value in the right subtree
          if (node.right != null) {
              Node temp = node.right;
              while (temp.left != null) {
                  temp = temp.left;
              }
              suc[0] = temp;
          }
      }
  }
}
