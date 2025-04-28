/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode rabbit = head.next;
        ListNode turtle = head;

        while (rabbit != null)
        {
            if (rabbit == turtle) return true;

            if (rabbit.next == null) return false;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }

        return false;


    }
}