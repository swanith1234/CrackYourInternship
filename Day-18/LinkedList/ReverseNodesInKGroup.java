// Definition for singly-linked list.
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || k == 1) {
          return head;
      }
      
      // Dummy node initialization
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      ListNode current = head;
      ListNode prevTail = dummy;
      ListNode newHead = dummy;
      
      while (current != null) {
          // Check if there are at least k nodes left to reverse
          int count = 0;
          ListNode temp = current;
          while (temp != null && count < k) {
              temp = temp.next;
              count++;
          }
          if (count == k) {
              // Reverse k nodes
              ListNode reversedHead = reverse(current, k);
              // Connect with previous part
              prevTail.next = reversedHead;
              prevTail = current;
              current = current.next;
          } else {
              // Less than k nodes remaining, no need to reverse
              prevTail.next = current;
              break;
          }
      }
      
      return newHead.next;
  }
  
  // Helper function to reverse k nodes
  private ListNode reverse(ListNode head, int k) {
      ListNode prev = null;
      ListNode current = head;
      while (k > 0) {
          ListNode nextNode = current.next;
          current.next = prev;
          prev = current;
          current = nextNode;
          k--;
      }
      head.next = current;
      return prev;
  }
}
