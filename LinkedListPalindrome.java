/*
  LeetCode: https://leetcode.com/problems/palindrome-linked-list/

  Given the head of a singly linked list, return true if it is a palindrome
 or false otherwise.

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
    public ListNode middleNode (ListNode head) {
        ListNode f = head, s = head;

        while (f != null && f. next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }

    public ListNode reverseList (ListNode head) {
        if (head == null) return head;

        ListNode current = head;
        ListNode prev = null;
        ListNode next= current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current= next;

            if(next != null) {
                next = next.next;
            }
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);

        ListNode secondHead = reverseList(middle);
        ListNode reReverseHead = secondHead;

        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                break;
            }

            head = head.next;
            secondHead = secondHead.next;
        }

        reverseList(reReverseHead);

        if (head == null || secondHead == null) return true;

        return false;
    } 
}
