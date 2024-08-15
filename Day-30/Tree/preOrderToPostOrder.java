static class Solution {
  // Function that constructs BST from its preorder traversal.
  public Node Bst(int pre[], int size) {
      if (size == 0) return null;

      // Create the root node from the first element of the array
      Node root = new Node(pre[0]);

      // Stack to keep track of the nodes while building the BST
      Stack<Node> stack = new Stack<>();
      stack.push(root);

      for (int i = 1; i < size; i++) {
          Node temp = null;

          // Pop elements from the stack while they are less than the current element
          while (!stack.isEmpty() && pre[i] > stack.peek().data) {
              temp = stack.pop();
          }

          // If the current element is less than the last popped node
          // it belongs to the left subtree of the last popped node
          if (temp != null) {
              temp.right = new Node(pre[i]);
              stack.push(temp.right);
          }
          // Else it belongs to the left subtree of the node on top of the stack
          else {
              stack.peek().left = new Node(pre[i]);
              stack.push(stack.peek().left);
          }
      }

      return root;
  }
}
