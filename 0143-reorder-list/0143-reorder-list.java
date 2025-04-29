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
    public void reorderList(ListNode head) {
        if (head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode middle = slow.next;
        ListNode tail = fast.next != null ? fast.next : fast;

        System.out.println(middle.val);
        System.out.println(tail.val);


        ListNode curr = middle;
        while (curr != tail)
        {
            ListNode tmpNext = curr.next;
            curr.next = tail.next;
            tail.next = curr;
            curr = tmpNext;
        }

        ListNode first = head;
        ListNode second = tail;
        while (second != null)
        {
            ListNode tmpFirst = first.next; 
            ListNode tmpSecond = second.next;

            first.next = second;
            second.next = tmpFirst;
            first = tmpFirst;
            second = tmpSecond;

        }

        first.next = null;


    }
}