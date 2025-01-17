class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      l1 = reverseList(l1);
      l2 = reverseList(l2);
      
      ListNode result = new ListNode(0);
      ListNode current = result;
      int carry = 0;
      
      while (l1 != null || l2 != null) {
          int sum = carry;
          if (l1 != null) {
              sum += l1.val;
              l1 = l1.next;
          }
          if (l2 != null) {
              sum += l2.val;
              l2 = l2.next;
          }
          
          carry = sum / 10;
          current.next = new ListNode(sum % 10);
          current = current.next;
      }
      
      if (carry > 0) {
          current.next = new ListNode(carry);
      }
      
      return reverseList(result.next);
  }
  
  private ListNode reverseList(ListNode head) {
      ListNode prev = null;
      while (head != null) {
          ListNode nextNode = head.next;
          head.next = prev;
          prev = head;
          head = nextNode;
      }
      return prev;
  }
}
