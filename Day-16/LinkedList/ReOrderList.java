
class Solution {
  public void reorderList(ListNode head) {
      if (head == null || head.next == null) return;

      // Step 1: Find the middle of the list
      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }

      // Step 2: Reverse the second half of the list
      ListNode prev = null, current = slow, next = null;
      while (current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }

      // Step 3: Merge the two halves
      ListNode first = head, second = prev;
      while (second.next != null) {
          ListNode temp1 = first.next;
          ListNode temp2 = second.next;
          first.next = second;
          second.next = temp1;
          first = temp1;
          second = temp2;
      }
  }
}
