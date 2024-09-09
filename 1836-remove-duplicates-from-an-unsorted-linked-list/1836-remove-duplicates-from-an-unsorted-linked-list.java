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
    public ListNode deleteDuplicatesUnsorted(ListNode head)
    {
        Map<Integer, Integer> frequency = new HashMap<>();

        ListNode current = head;
        while (current != null)
        {
            frequency.merge(current.val, 1, Integer::sum);

            current = current.next;

        }

        System.out.println("frequency: " + frequency);

        ListNode fakeHead = new ListNode(-1, head);
        ListNode result = fakeHead;
        current = head;
        while (current != null)
        {
            if (frequency.get(current.val) > 1)
            {
                result.next = current.next;
            }
            else
            {
                result = current;
            }

            current = current.next;

        }

        return fakeHead.next;
    }
}