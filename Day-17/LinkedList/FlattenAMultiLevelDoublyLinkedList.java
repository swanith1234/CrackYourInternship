/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
  public Node flatten(Node head) {
      if (head == null) return null;
      
      // Create a stack to keep track of the nodes
      Stack<Node> stack = new Stack<>();
      Node current = head;
      
      while (current != null) {
          // If current node has a child
          if (current.child != null) {
              // If the current node has a next node, push it onto the stack
              if (current.next != null) {
                  stack.push(current.next);
              }
              // Connect current node to child
              current.next = current.child;
              if (current.next != null) {
                  current.next.prev = current;
              }
              // Set child to null
              current.child = null;
          }
          // If the current node has no next node and stack is not empty
          if (current.next == null && !stack.isEmpty()) {
              // Pop the node from the stack and make it the next node
              current.next = stack.pop();
              if (current.next != null) {
                  current.next.prev = current;
              }
          }
          // Move to the next node
          current = current.next;
      }
      
      return head;
  }
}
