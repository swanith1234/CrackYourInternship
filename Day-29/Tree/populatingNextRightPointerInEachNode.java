class Solution {
  public Node connect(Node root) {
      if (root == null) {
          return null;
      }
      
      // Start with the root node
      Node current = root;
      
      // Loop through each level
      while (current.left != null) {
          Node head = current;
          
          // Loop through nodes at the current level
          while (head != null) {
              // Connect the left child to the right child
              head.left.next = head.right;
              
              // Connect the right child to the next node's left child
              if (head.next != null) {
                  head.right.next = head.next.left;
              }
              
              // Move to the next node in the current level
              head = head.next;
          }
          
          // Move to the next level
          current = current.left;
      }
      
      return root;
  }
}
