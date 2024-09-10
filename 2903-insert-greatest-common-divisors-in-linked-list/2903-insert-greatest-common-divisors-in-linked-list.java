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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;

        ListNode current = head;
        while (current.next != null)
        {
            ListNode next = current.next;

            int gcd = gcd(current.val, next.val);
            ListNode gcdNode = new ListNode(gcd, next);
            current.next = gcdNode;

            current = gcdNode.next;
        }

        return head;
    }

    private int gcd(int a, int b)
    {
        if (a == b) return a;

        if (a > b)
        {
            return gcd(a - b, b);
        }
        else
        {
            return gcd (a, b - a);
        }
    }
}