class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // Create a dummy node to simplify merging
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;

      // Use two pointers to traverse both lists
      while (list1 != null && list2 != null) {
          if (list1.val <= list2.val) {
              current.next = list1;
              list1 = list1.next;
          } else {
              current.next = list2;
              list2 = list2.next;
          }
          current = current.next;
      }

      // Attach the remaining nodes of the non-exhausted list
      if (list1 != null) {
          current.next = list1;
      } else {
          current.next = list2;
      }

      // Return the merged list, which starts from the next node of the dummy
      return dummy.next;
  }
}
