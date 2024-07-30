public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;
      
      // Step 1: Find the lengths of both linked lists
      int lengthA = getLength(headA);
      int lengthB = getLength(headB);
      
      // Step 2: Align the start of both linked lists
      if (lengthA > lengthB) {
          headA = advanceBy(headA, lengthA - lengthB);
      } else {
          headB = advanceBy(headB, lengthB - lengthA);
      }
      
      // Step 3: Traverse both lists to find the intersection node
      while (headA != null && headB != null) {
          if (headA == headB) {
              return headA;
          }
          headA = headA.next;
          headB = headB.next;
      }
      
      return null; // No intersection
  }
  
  // Helper function to calculate the length of a linked list
  private int getLength(ListNode head) {
      int length = 0;
      while (head != null) {
          length++;
          head = head.next;
      }
      return length;
  }
  
  // Helper function to advance a linked list by 'n' nodes
  private ListNode advanceBy(ListNode head, int n) {
      while (n > 0 && head != null) {
          head = head.next;
          n--;
      }
      return head;
  }
}
