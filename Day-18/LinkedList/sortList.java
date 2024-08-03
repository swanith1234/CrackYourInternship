// Definition for singly-linked list.
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      
      // Step 1: Split the list into halves
      ListNode mid = getMid(head);
      ListNode left = head;
      ListNode right = mid.next;
      mid.next = null;
      
      // Step 2: Sort each half
      left = sortList(left);
      right = sortList(right);
      
      // Step 3: Merge the sorted halves
      return merge(left, right);
  }
  
  private ListNode getMid(ListNode head) {
      ListNode slow = head;
      ListNode fast = head.next; // Start fast one step ahead to handle even number of nodes
      
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      
      return slow;
  }
  
  private ListNode merge(ListNode left, ListNode right) {
      ListNode dummy = new ListNode();
      ListNode current = dummy;
      
      while (left != null && right != null) {
          if (left.val <= right.val) {
              current.next = left;
              left = left.next;
          } else {
              current.next = right;
              right = right.next;
          }
          current = current.next;
      }
      
      // Append the remaining nodes
      if (left != null) {
          current.next = left;
      } else {
          current.next = right;
      }
      
      return dummy.next;
  }
}
