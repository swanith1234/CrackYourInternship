class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      // Create a dummy node that points to the head
      ListNode dummy = new ListNode(0, head);
      ListNode first = dummy;
      ListNode second = dummy;
      
      // Move first n+1 steps ahead
      for (int i = 0; i <= n; i++) {
          first = first.next;
      }
      
      // Move both first and second until first reaches the end
      while (first != null) {
          first = first.next;
          second = second.next;
      }
      
      // Skip the desired node
      second.next = second.next.next;
      
      // Return the head of the modified list
      return dummy.next;
  }
}
