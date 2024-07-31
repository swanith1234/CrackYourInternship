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
  public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode current = head;
      
      while (current != null) {
          ListNode next = current.next; // Temporarily store the next node
          current.next = prev; // Reverse the current node's pointer
          prev = current; // Move prev and current one step forward
          current = next;
      }
      
      return prev; // prev will be the new head of the reversed list
  }
}
