/*
 Leetcode : https://leetcode.com/problems/reverse-nodes-in-k-group/

 - reverse only if there are k elements from current position. 
 - predetermine number of groups to reverse.
 - newEnd - last element in the reversed group. prev for next group will be last element in previously reversed group
 - last element - last element in the previously reversed group.

*/


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

    public int getLength(ListNode head) {
      ListNode curr = head;
      int count = 0;

      while (curr != null) {
        count++;
        curr = curr.next;
      }

      return count;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 1) return head;
        int length = getLength(head);
        int count = length/k;

        ListNode curr = head;
        ListNode prev = null;

        while (count > 0) {
          ListNode newEnd = curr;
          ListNode last = prev;
          
          ListNode next = curr.next;

          for (int i = 0 ; curr != null && i < k ; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if (next != null) {
              next = next.next;
            }
          }

          if (last != null) {
            last.next = prev;
          } else {
            head = prev;
          }

          newEnd.next = curr;
          prev = newEnd;
          count--;
        }
        
        return head;      
    }
    
}
