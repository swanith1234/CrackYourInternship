/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      // Create a dummy node to handle edge cases easily
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      // Use two pointers, prev and current, to traverse the list
      ListNode prev = dummy;
      ListNode current = head;
      
      while (current != null) {
          // Detect duplicates
          boolean hasDuplicate = false;
          while (current.next != null && current.val == current.next.val) {
              hasDuplicate = true;
              current = current.next;
          }
          
          if (hasDuplicate) {
              // Skip all duplicates
              prev.next = current.next;
          } else {
              // No duplicates detected, move prev to current
              prev = prev.next;
          }
          
          // Move current to the next node
          current = current.next;
      }
      
      return dummy.next;
  }
}
