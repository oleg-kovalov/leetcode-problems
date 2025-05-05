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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode beforeGroup = dummyHead;
        while (true)
        {
            ListNode iter = beforeGroup;
            for (int i=0; i<k; i++)
            {
                if (iter.next == null) return dummyHead.next;
                iter = iter.next;
            }
            ListNode afterGroup = iter.next;

            // reverse group
            ListNode prev = beforeGroup.next;
            ListNode curr = prev.next;
            while (curr != afterGroup)
            {
                ListNode tmpNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmpNext;
            }

            // link group edges
            ListNode tmpBeforeGroup = beforeGroup.next; 
            beforeGroup.next.next = afterGroup;
            beforeGroup.next = prev;

            beforeGroup = tmpBeforeGroup;
        }


        // return null;
    }
}