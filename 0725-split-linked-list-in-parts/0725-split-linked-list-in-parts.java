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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];

        ListNode current = head;
        int size = 1;
        while(current.next != null)
        {
            size += 1;
            current = current.next;
        }

        int divisor = size / k;
        int remainder = size % k;
        current = head;

        ListNode[] result = new ListNode[k];
        for (int i=0; i<k; i++)
        {
            if (current == null)
            {
                result[i] = null;
                continue;
            }

            result[i] = current;
            int iterations = divisor + (remainder > 0 ? 1 : 0) -1;
            while (current.next != null && iterations > 0)
            {
                current = current.next;
                iterations--;
            }
            remainder--;
            if (current.next != null)
            {
                ListNode prev = current;
                current = current.next;
                prev.next = null;
            } else {
                current = null;
            }

        }

        return result;
    }
}