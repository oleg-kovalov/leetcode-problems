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

//   - 1 - 2 - 3
//         ^
//             ^
//             ^


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr;

        while (curr.next != null)
        {
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }

        curr.next = prev;


        return curr;

    }
}