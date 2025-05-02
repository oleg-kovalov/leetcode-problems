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
    public ListNode reverseBetween(ListNode head, int lc, int rc) {
        if (lc == rc) return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode beforeLeft = dummyHead;
        int count = 0;
        while (count < lc - 1)
        {
            beforeLeft = beforeLeft.next;
            count += 1;
        }

        ListNode prev = beforeLeft.next;
        ListNode curr = prev.next;
        for (int i=0; i<rc-lc; i++)
        {
            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }

        beforeLeft.next.next = curr;
        beforeLeft.next = prev;


        return dummyHead.next;
    }
}