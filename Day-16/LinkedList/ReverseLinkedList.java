class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
      if (head == null || left == right) return head;

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;

      // Step 1: Reach the node at position `left`
      for (int i = 1; i < left; i++) {
          prev = prev.next;
      }

      // `prev` now points to the node just before `left`
      ListNode current = prev.next;
      ListNode next = current.next;

      // Step 2: Reverse the sublist from `left` to `right`
      for (int i = 0; i < right - left; i++) {
          current.next = next.next;
          next.next = prev.next;
          prev.next = next;
          next = current.next;
      }

      // Return the modified list
      return dummy.next;
  }
}
